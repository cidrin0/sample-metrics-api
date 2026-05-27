# Contributing

Obrigado por contribuir com o projeto Sample Spring Boot Metrics API!
Este documento descreve como você pode colaborar de forma eficiente e segura.

## Como contribuir

1. Fork e clone este repositório.
2. Crie uma branch de feature ou correção:
   ```bash
   git checkout -b feature/minha-melhoria
   ```
3. Execute o build localmente:
   ```bash
   ./gradlew build
   ```
4. Faça suas alterações e adicione testes sempre que possível.
5. Antes de abrir o PR, rode:
   - `./gradlew build`
   - `./gradlew bootRun` (quando apropriado)
   - `curl -f http://localhost:8080/actuator/health`
   - `curl -f http://localhost:8080/actuator/prometheus`
6. Abra um Pull Request para a branch `main` com descrição clara das mudanças.

## Padrões de código

- Prefira nomes claros para classes, métodos e variáveis.
- Siga as convenções Java do projeto.
- Evite comentários desnecessários; o código deve ser legível por si só.
- Ao alterar APIs públicas, atualize `OpenApiConfig.java` quando necessário.

## Testes

- Adicione testes unitários e de integração sempre que possível.
- Verifique se os testes existentes continuam passando.
- Se incluir novos endpoints ou métricas, adicione smoke tests ou validação correspondente.

## Configuração e segredos

- Use `.env.example` como modelo e nunca comite o arquivo `.env`.
- Não inclua credenciais em código ou arquivos de configuração versionados.
- Atualize `.gitignore` se precisar excluir novos arquivos de configuração local.

## Pedido de revisão

- Explique o propósito do PR.
- Liste os arquivos alterados e o impacto esperado.
- Mencione se a mudança exige revisão de segurança, arquitetura ou dados.

## Política Plan-First (agentes)

Antes de mudanças significativas de código, arquitetura ou infraestrutura, crie um plano em agents/plans/ usando agents/plans/plan-template.md. Use o script ./agents/plan-and-commit.sh -p <plano> -m "mensagem" para revisar o plano e o diff antes de commitar. Commits que alterem infraestrutura, segurança ou design devem mencionar o plano no PR e podem requerer revisão humana adicional.

Consulte agents/README.md para detalhes sobre agentes, gatilhos e políticas relacionadas.

