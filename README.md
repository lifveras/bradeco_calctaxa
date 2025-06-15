# Componente `CalculaTaxa` - PIC

Este repositório contém o **componente CalculaTaxa** implementado em Java, baseado no padrão **PIC (Padrão de Interface de Componentes)**. Este componente é responsável por calcular taxas (como impostos) com base na categoria de itens, utilizando uma abordagem **orientada à interface** com separação entre **interfaces providas**, **requeridas** e lógica interna.

---

Perfeito! Com base na estrutura atualizada que você compartilhou, segue a seção reescrita do README adaptada ao componente **CalculaTaxa**:

---

## Estrutura do Projeto

A estrutura do projeto do componente `CalculaTaxa` segue o padrão **PIC** (Processo de Integração de Componentes), organizando as classes em pastas com **responsabilidades bem definidas**:

```
src/
└── main/
    └── java/
        └── io/github/lifveras/bradeco_template_dependencia_pic/
            ├── internal/
            │   └── model/
            │       ├── Categoria.java               <-- Enum ou classe de definição de categorias de itens
            │   ├── Item.java                    <-- Classe representando o item sobre o qual será aplicada a taxa
                └── RegistroDeTaxas.java         <-- Lógica interna para mapear taxas por categoria
            │
            └── provided/
                ├── interfaces/
                │   └── CalculadoraTaxaInterface.java        <-- Interface provida: serviço de cálculo de taxa
                │
                ├── CalculadoraTaxaConcreteInterface.java    <-- Implementação concreta da interface provida
                └── CalculadoraTaxaInterfacePort.java        <-- Porta de entrada do componente (adapta o uso da interface concreta)
```

### 📦 `internal/model/`

Contém as **entidades e lógica de domínio interna**, como definição de categorias, estrutura do item e regras de registro de taxas.

### 📦 `provided/interfaces/`

Contém a **interface provida** pelo componente, ou seja, os serviços públicos oferecidos para uso externo.

### 📦 Arquivos no nível `provided/`

- `CalculadoraTaxaConcreteInterface.java`: implementação concreta da interface provida.
- `CalculadoraTaxaInterfacePort.java`: **porta de entrada** do componente, conectando a interface concreta ao contexto externo, permitindo injeção de dependências.

---

## Como funciona

O componente recebe uma lista de itens com nome, preço e categoria. A partir disso, ele consulta o `RegistroDeTaxas` para buscar a proporção de taxa correspondente à categoria de cada item e retorna um mapa com os nomes dos itens e os respectivos valores calculados da taxa.

---

## Dependência

Este componente depende do pacote de abstrações do PIC:

📦 Repositório: [github.com/lifveras/bradeco_pic_abstract](https://github.com/lifveras/bradeco_pic_abstract)

Adicione ao seu `pom.xml`:

```xml
<dependency>
    <groupId>io.github.lifveras</groupId>
    <artifactId>bradeco_pic_abstract</artifactId>
    <version>1.0.0</version>
</dependency>
```

---

## Executando os Testes

Para rodar os testes:

```bash
mvn test
```

Certifique-se de que os testes estejam localizados corretamente em `src/test/java`.

---

## Sobre o padrão PIC

O padrão PIC (Processo de Integração de Componentes) é uma abordagem estruturada para construção de software baseada em **interfaces**, **portos** e **dependências externas bem definidas**, promovendo a reutilização e manutenibilidade de componentes.

📘 Livro: [Desenvolvimento Orientado a Componentes com UML](https://www.amazon.com.br/Desenvolvimento-orientado-componentes-com-UML-ebook/dp/B07DYDSMCZ/ref=sr_1_1)
📺 [Parte Teórica no YouTube](https://www.youtube.com/watch?v=0BmWe7d17NU&list=PLQb3t1uw-rpFIPbyWZCfOc9CTN5chPa0d)
📺 [Parte Prática no YouTube](https://www.youtube.com/watch?v=4mnZnNAYHKc&list=PLQb3t1uw-rpHXs0N674qsdYB_Dlgoriy3)

---

## Autor do Componente

- Luiz Gustavo Véras
- [gustavo_veras@ifsp.edu.br](mailto:gustavo_veras@ifsp.edu.br)
- [@lifveras no GitHub](https://github.com/lifveras)
