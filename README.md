# Calculadora de Apdex

## Descrição

Este projeto implementa uma calculadora de Apdex (Application Performance Index) em Java, seguindo a metodologia de Test-Driven Development (TDD). O Apdex é uma métrica que mede a satisfação do usuário com base no tempo de resposta de uma aplicação.

## Autor

**Gustavo Bispo Cordeiro - RM558515**

## Arquitetura

### Estrutura de Classes

1. **`Apdex`**: Classe principal responsável por calcular e classificar o Apdex
2. **`ApdexTest`**: Classe de testes que valida o comportamento da calculadora

### Fórmula do Apdex

O Apdex é calculado usando a seguinte fórmula:

```
Apdex = (S + T/2) / N
```

Onde:
- **S** = Requisições satisfatórias (≤ 500ms)
- **T** = Requisições toleráveis (> 500ms e ≤ 2 segundos)
- **N** = Total de requisições

### Classificações do Apdex

| Classificação | Faixa de Valores |
|---------------|------------------|
| Excelente     | ≥ 0.94          |
| Bom           | ≥ 0.85 e < 0.94 |
| Razoável      | ≥ 0.70 e < 0.85 |
| Ruim          | ≥ 0.50 e < 0.70 |
| Inaceitável   | < 0.50          |

## Tecnologias Utilizadas

- **Java 17**
- **Maven 3.x**
- **JUnit 5**
- **IntelliJ IDEA** (recomendado)

## Estrutura do Projeto

```
QA-CP/
├── pom.xml                          # Configuração do Maven
├── README.md                        # Documentação do projeto
├── src/
│   ├── main/java/com/qa/
│   │   └── Apdex.java              # Classe principal
│   └── test/java/com/qa/
│       └── ApdexTest.java          # Classe de testes
└── .gitignore                       # Arquivos ignorados pelo Git
```

## Como Executar

### Pré-requisitos

1. Java JDK 17 instalado
2. Maven 3.x instalado
3. IDE (recomendado: IntelliJ IDEA)

### Executando os Testes

```bash
# Compilar e executar todos os testes
mvn test

# Executar apenas os testes
mvn surefire:test

# Compilar o projeto
mvn compile
```

### Executando no IntelliJ IDEA

1. Abra o projeto no IntelliJ IDEA
2. Configure o JDK 17 nas configurações do projeto
3. Execute a classe `ApdexTest` para rodar os testes
4. Ou use o Maven Tool Window para executar comandos Maven

## Implementação TDD

Este projeto foi desenvolvido seguindo a metodologia Test-Driven Development (TDD):

### 1. Red (Vermelho)
- Primeiro, foram escritos os testes que falhavam
- Testes cobrem todas as classificações de Apdex
- Incluem testes de valores limite e casos especiais

### 2. Green (Verde)
- Implementação da classe `Apdex` para fazer os testes passarem
- Cálculo correto da fórmula do Apdex
- Classificação adequada baseada nos valores calculados

### 3. Refactor (Refatoração)
- Código limpo e bem documentado
- Métodos com responsabilidades bem definidas
- Getters para facilitar testes e debug

## Casos de Teste Implementados

1. **`testApdexExcelente()`**: Verifica classificação "Excelente" (≥ 0.94)
2. **`testApdexBom()`**: Verifica classificação "Bom" (≥ 0.85 e < 0.94)
3. **`testApdexRazoavel()`**: Verifica classificação "Razoável" (≥ 0.70 e < 0.85)
4. **`testApdexRuim()`**: Verifica classificação "Ruim" (≥ 0.50 e < 0.70)
5. **`testApdexInaceitavel()`**: Verifica classificação "Inaceitável" (< 0.50)
6. **`testCalcularApdex()`**: Testa o cálculo específico do valor do Apdex
7. **`testConstrutor()`**: Verifica se o construtor funciona corretamente
8. **`testValoresLimite()`**: Testa valores exatos dos limites de classificação

## Exemplo de Uso

```java
// Criar uma instância da calculadora de Apdex
Apdex apdex = new Apdex(376, 0, 24);

// Calcular o valor do Apdex
double valor = apdex.calcularApdex(); // Retorna 0.94

// Obter a classificação
String classificacao = apdex.classificarApdex(); // Retorna "Excelente"

// Acessar informações detalhadas
int total = apdex.getTotalRequisicoes(); // 400
int satisfatorias = apdex.getSatisfatorias(); // 376
int toleraveis = apdex.getToleraveis(); // 0
int frustrantes = apdex.getFrustrantes(); // 24
```

## Contribuição

Para contribuir com o projeto:

1. Faça um fork do repositório
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## Licença

Este projeto é parte de um trabalho acadêmico e está disponível para fins educacionais.

## Contato

Para dúvidas ou sugestões, entre em contato através do GitHub.
