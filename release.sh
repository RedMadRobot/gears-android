#!/usr/bin/env bash
#
# Prepares the specified library for release. Creates a release branch from the 'main'.
#
# Usage: ./release.sh [release-name]
#   Where `release-name` is: [library-name]-v[version]
#
# Example: ./release.sh gears-compose-v1.0.0
#
# Original release script: https://github.com/RedMadRobot/android-library-template/blob/main/release.sh

set -euo pipefail

# The script could be run from any directory.
cd "$(dirname "$0")"

# Handle release input parameter
release=${1:?Please specify the release to be released as a parameter}
module=$(./scripts/get-module-name.sh "$release")
module_path=${module#:} # :gears:gears-compose -> gears:gears-compose
module_path=${module_path//://} # gears:gears-compose -> gears/gears-compose
library=${release%-v*} # gears-compose-v1.0.0 -> gears-compose

# Configure the script
properties="$module_path/gradle.properties"
changelog="$module_path/CHANGELOG.md"
readme="$module_path/README.md"
build_script="$module_path/build.gradle.kts"
files_to_update_version=("$properties" "$build_script" "$readme")
github_repository_url="https://github.com/RedMadRobot/gears-android"

#region Utils
function error() {
  echo "❌ $1"
  return 1
}

function get_current_version() {
  local version=""
  if [[ -f $properties ]]; then
    version=$(grep "^version=" "$properties")
  fi

  if [[ -z $version && -f $build_script ]]; then
    version=$(grep "^version = \"" "$build_script")
  fi

  if [[ -z $version ]]; then
    error "Can't find current version. Checked locations: $properties, $build_script"
  fi

  echo "$version" | cut -d'=' -f2 | tr -d ' "'
}

function replace() {
  local file=$3

  # Escape linebreaks
  local replacement=${2//$'\n'/\\\n}
  # Portable in-place edit.
  # See: https://stackoverflow.com/a/4247319
  sed -i".bak" -E "s~$1~$replacement~g" "$file"
  rm "$file.bak"
}

function diff_link() {
  echo -n "$github_repository_url/compare/${1}...${2}"
}
#endregion

# Check if the module exists
[[ -d $module_path ]] || error "Module '$module' not found on path '$module_path'."

# 0. Fetch remote changes
echo "️⏳ Creating release branch..."
release_branch="release/$release"
git checkout --quiet -b "$release_branch"
git pull --quiet --rebase origin main
echo "✅ Branch '$release_branch' created"
echo

# 1. Calculate module and version values for later
last_version=$(get_current_version)
version=${release##*-v} # library-v1.0.0 -> 1.0.0
if [[ "$last_version" == "$version" ]]; then
  echo "🤔 Version $version is already set."
  exit 0
fi
echo "🚀 [$module] Update $last_version → $version"
echo

# 2. Update version everywhere
for file in "${files_to_update_version[@]}" ; do
  if [[ -f $file ]]; then
    replace "$last_version" "$version" "$file"
    echo "✅ Updated version in $file"
  fi
done

# 3. Update header in CHANGELOG.md
date=$(date -u +%Y-%m-%d)
header_replacement=\
"## Unreleased

- *No changes*

## $version ($date)"
replace "^## Unreleased.*" "$header_replacement" "$changelog"
echo "✅ Updated CHANGELOG.md header"

# 4. Ask if the changes should be pushed to remote branch
echo
echo "Do you want to commit the changes and push the release branch and tag?"
echo "The release tag push triggers a release workflow on CI."
read -p " Enter 'yes' to continue: " -r input
if [[ "$input" != "yes" ]]; then
  echo "👌 SKIPPED."
  exit 0
fi

# 5. Push changes, trigger release on CI, and give a link to open PR
echo
echo "⏳ Pushing the changes to the remote repository..."
git add "$readme" "$changelog" "$properties" "$build_script"
git commit --quiet --message "$library: $version"
git tag "$release"
git push --quiet origin HEAD "$release"
echo "🎉 DONE."
echo "Create a Pull Request: $(diff_link main "$release_branch")"
