# Agents Defined for Project Development

This directory contains descriptions and usage instructions for automated agents that support the development cycle.

## Included Agents

- **java-developer.md** — Java code implementation and maintenance
- **code-reviewer.md** — Automatic PR review and comments
- **design-analyst.md** — Design analysis and architecture suggestions
- **test-runner.md** — Unit and integration test execution and generation

## Usage

- Consult each file for rules, triggers, and recommended prompts.
- Agents are assistants: critical changes (infrastructure, security, design) must receive human review.

## Mandatory Policy (Plan-First and Diff Preview)

- Before any change, generate a short plan and save it in agents/plans/<name>-<timestamp>.md or agents/last_plan.md.
- Use ./agents/plan-and-commit.sh -p <path-to-plan> -m "message" to display the plan and diff before committing. The script will request explicit confirmation; without confirmation, the commit is aborted.
- Automatic reviews and CI continue; this policy ensures human visibility and traceability of decisions.

## Plans

A plan template is available in agents/plans/plan-template.md — save your plans in agents/plans/ and use ./agents/plan-and-commit.sh to present the plan and diff before committing.

## CONTRIBUTING.md Update

This repository references the 'plan-first' policy and the use of ./agents/plan-and-commit.sh for commits that change code, infrastructure, or design; see CONTRIBUTING.md for details.


