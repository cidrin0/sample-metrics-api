Agentes e responsabilidades
- Copilot / assistentes: sugerir mudanças de código, gerar testes, criar patches pequenos.
- CI (quando existir): executar build, testes e linter.
- Mantenedores humanos: revisar PRs que envolvam infra, segurança e design.

Gatilhos
- Pull request para branch main → revisão humana obrigatória.
- Commits trivial/format → podem ser auto-aprovados por formatação tool (se configurado).

Recomendações para automações
- Pipeline CI: build + smoke tests + static analysis + publish build artifact (optionally).  
- Bot de dependabot/renovate para manter libs atualizadas.
- Auto-runner para validar dashboards JSON (Grafana JSONLint) quando arquivos em `config/dashboards/` mudarem.

Política obrigatória para agentes:
- Planejar antes de alterar: todo agente deve gerar um plano descrevendo a mudança antes de aplicar alterações (salvar em agents/plans/ ou agents/last_plan.md).
- Exibir diffs antes do commit: usar o script agents/plan-and-commit.sh para apresentar o plano e o diff ao autor e obter confirmação explícita antes de commitar.
- Mudanças de infra/segurança continuam exigindo revisão humana e serão marcadas pelo workflow infra-review.yml.

