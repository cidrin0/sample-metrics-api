#!/usr/bin/env bash
set -euo pipefail

usage() {
  cat <<EOF
Usage: $0 -p PLAN_FILE -m "commit message" [-b branch]

Options:
  -p PLAN_FILE   Path to the plan file generated before making changes (required)
  -m MESSAGE     Commit message (required)
  -b BRANCH      (optional) create and switch to this branch before committing
EOF
  exit 2
}

PLAN_FILE=""
MSG=""
BRANCH=""

while getopts "p:m:b:" opt; do
  case "$opt" in
    p) PLAN_FILE="$OPTARG" ;; 
    m) MSG="$OPTARG" ;; 
    b) BRANCH="$OPTARG" ;; 
    *) usage ;; 
  esac
done

if [ -z "$PLAN_FILE" ] || [ -z "$MSG" ]; then
  echo "ERROR: plan file and commit message are required."
  usage
fi

if [ ! -f "$PLAN_FILE" ]; then
  echo "ERROR: plan file '$PLAN_FILE' not found. Create the plan before running this script."
  exit 3
fi

if [ -n "$BRANCH" ]; then
  echo "Creating and switching to branch: $BRANCH"
  git checkout -b "$BRANCH"
fi

echo "--- PLAN ---"
cat "$PLAN_FILE"
echo "--- END PLAN ---"

# Show git status and diff
echo
echo "--- GIT STATUS ---"
git status --porcelain

echo "--- DIFF (unstaged) ---"
if git diff --quiet; then
  echo "(no unstaged changes)"
else
  git --no-pager diff --color
fi

echo "--- DIFF (staged) ---"
if git diff --cached --quiet; then
  echo "(no staged changes)"
else
  git --no-pager diff --cached --color
fi

# Confirm
printf "\nAprovar e commitar as mudanças listadas acima? [y/N]: "
read -r CONFIRM
if [[ "$CONFIRM" != "y" && "$CONFIRM" != "Y" ]]; then
  echo "Commit abortado pelo usuário."
  exit 1
fi

# Stage all and commit
git add -A
COMMIT_SHA=$(git commit -m "$MSG" || true)
if [ -z "$COMMIT_SHA" ]; then
  echo "Sem alterações para commitar."
else
  echo "Commit realizado."
fi

echo "Done."
