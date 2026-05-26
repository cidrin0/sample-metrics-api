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
