#!/usr/bin/env sh

# Define a list of valid conventional commit types
valid_types="feat refactor test fix chore docs style perf build ci revert"

# Function to check if a given type is valid
is_valid_commit_type() {
  type="$1"
  for valid_type in $valid_types; do
    if [ "$type" = "$valid_type" ]; then
      return 0 # Valid commit type
    fi
  done
  return 1 # Invalid commit type
}

# Check that a commit message is provided
if [ "$#" -ne 3 ]; then
  echo "Error: usage: ./tcr.sh <commit type> <baby step type> <details>"
  echo "  - commit type: one of $valid_types (cf https://www.conventionalcommits.org/en/v1.0.0/)"
  echo "  - baby step type:"
  echo "    - refactorings: https://refactoring.com/catalog/"
  echo "    - features: https://en.wikipedia.org/wiki/Transformation_Priority_Premise"
  echo "  - details: extra info about the change"
  exit 1
fi

# Store the arguments in variables
commit_type="$1"
baby_steps_type="$2"
commit_details="$3"

# Validate the commit_type
if ! is_valid_commit_type "$commit_type"; then
  echo "Error: The commit_type must be one of the following: $valid_types (cf https://www.conventionalcommits.org/en/v1.0.0/)"
  exit 1
fi


# Get the current working branch from git
current_branch=$(git branch --show-current)

# Check if we are in a git repository
if [ -z "$current_branch" ]; then
  echo "Error: Not a git repository or no branch is currently checked out."
  exit 1
fi

# Add all changes to the staging area
git add .

# Commit with the provided commit message
commit_message="✅ $commit_type: $baby_steps_type: $commit_details"
git commit --message "$commit_message"

# Push the commit to the origin
git push --no-recurse-submodules origin "$current_branch"