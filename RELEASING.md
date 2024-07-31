# Releasing

1. Run the script `release.sh` with release name in format `[library]-v[version]`:
   ```bash
   ./release.sh gears-compose-v1.0.0
   ````

2. The script will ask you if you want to push the release branch and create a release tag.

3. Ensure `CHANGELOG.md` looks good and is ready to be published.
   Make the necessary edits.

4. Type "yes" to the console if everything is okay.

5. Click the link printed in the console to create a Pull Request for release branch.

6. Merge the Pull Request as soon as the "Check" workflow succeeds.

Release tag push triggers a GitHub Actions workflow, which publishes the release artifacts to Maven Central and creates a GitHub release.

## Manual release preparation

To prepare the release manually, follow the steps the script does:

1. Ensure the repository is up to date, and the main branch is checked out.

2. Create the release branch with the name `release/[library]-v[version]`

3. Update the version in `gradle.properties`, `build.gradle.kts` and `README.md` ("Usage" section).

4. Update the `CHANGELOG.md`:
    1. Replace `Unreleased` section with the release version
    2. Add a link to the diff between the previous and the new version (if possible)
    3. Add a new empty `Unreleased` section on the top

5. Commit the changes, create a tag on the commit, and push it to the remote repository.
   The tag should follow the format `[library]-v[version]`.

6. Create a Pull Request for the release branch and merge it.
