Agentes e responsabilidades
- Copilot / assistentes: sugerir mudanças de código, gerar testes, criar patches pequenos.
- CI (quando existir): executar build, testes e linter.
- Mantenedores humanos: revisar PRs que envolvam infra, segurança e design.

Gatilhos
- Pull request para branch main → revisão humana obrigatória.
- Commits trivial/format → podem ser auto-aprovados por formatação tool (se configurado).
