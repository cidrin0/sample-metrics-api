## Agents and Responsibilities

- Copilot / assistants: suggest code changes, generate tests, create small patches.
- CI (when available): run build, tests, and linter.
- Human maintainers: review PRs involving infrastructure, security, and design.

## Triggers

- Pull request to main branch → mandatory human review.
- Trivial/format commits → can be auto-approved by formatting tool (if configured).

## Recommendations for Automation

- CI Pipeline: build + smoke tests + static analysis + publish build artifact (optionally).
- Dependabot/renovate bot to keep libraries updated.
- Auto-runner to validate Grafana JSON dashboards (JSONLint) when files in `config/dashboards/` change.

## Mandatory Policy for Agents

- Plan before making changes: every agent must generate a plan describing the change before applying it (save in agents/plans/ or agents/last_plan.md).
- Display diffs before commit: use the agents/plan-and-commit.sh script to present the plan and diff to the author and get explicit confirmation before committing.
- Infrastructure/security changes continue to require human review and will be marked by the infra-review.yml workflow.

