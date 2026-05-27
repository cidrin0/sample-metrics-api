Agentes definidos para desenvolvimento do projeto

Este diretório contém descrições e instruções de uso para agentes automáticos que suportam o ciclo de desenvolvimento.

Agentes incluídos:
- java-developer.md — Implementação e manutenção de código Java
- code-reviewer.md — Revisão automática e comentários de PR
- design-analyst.md — Análise de design e sugestões de arquitetura
- test-runner.md — Execução e geração de testes unitários e de integração

Uso
- Consulte cada arquivo para regras, gatilhos e prompts recomendados.
- Agentes são assistentes: mudanças críticas (infra, segurança, design) devem receber revisão humana.

Política obrigatória (plan-first e diff preview)
- Antes de qualquer alteração, gerar um plano curto e salvo em agents/plans/<nome>-<timestamp>.md ou agents/last_plan.md.
- Usar ./agents/plan-and-commit.sh -p <caminho-do-plano> -m "mensagem" para exibir o plano e o diff antes de commitar. O script pedirá confirmação explícita; sem confirmação, o commit é abortado.
- Revisões automáticas e CI continuam; esta política garante visibilidade humana e rastreabilidade das decisões.

- Planos: um template de plano está disponível em agents/plans/plan-template.md — salve seus planos em agents/plans/ e use ./agents/plan-and-commit.sh para apresentação do plano e do diff antes do commit.

- Atualização do CONTRIBUTING.md: este repositório referencia a política 'plan-first' e o uso de ./agents/plan-and-commit.sh para commits que alteram código, infraestrutura ou design; veja CONTRIBUTING.md para detalhes.


