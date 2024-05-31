#!/usr/bin/env sh

# Check that a commit message is provided
if [ "$#" -ne 1 ]; then
  echo "Error: Missing a commit message argument"
  exit 1
fi

# Store the argument as the commit message
commit_message="✔ $1"

# Get the current working branch from git
current_branch=$(git branch --show-current)

# Check if we are in a git repository
if [ -z "$current_branch" ]; then
  echo "Error: Not a git repository or no branch is currently checked out."
  exit 1
fi

git add .
git commit --message "$commit_message"
git push --no-recurse-submodules origin "$current_branch"
