#!/usr/bin/env bash
#
# Retrieves Gradle module name from the given version tag.
# Examples:
#   gears-compose-v1.0.0 -> :gears:gears-compose
#   core-ktx-v1.0.0-1 -> :ktx:core-ktx
#   resultflow-v1.0.0 -> :resultflow
#

set -eu

tag=$1
library=${tag%-v*} # Remove version suffix

# Handle prefix for inner modules
prefix=":"
if [[ $library == *-ktx ]]; then
  prefix=":ktx:"
elif [[ $library == gears-* ]]; then
  prefix=":gears:"
fi

echo "$prefix$library"
