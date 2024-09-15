![Greenway_TextGray](https://github.com/greenway-FIAP/csharp_api/assets/80494196/7b3ee4f3-373d-4aed-b459-d870cc122b77)

# Documentação da API - Greenway

Esta documentação descreve a plataforma **Greenway**, uma solução SaaS desenvolvida para auxiliar empresas a alcançarem metas de sustentabilidade, otimizando processos e gerando benefícios econômicos por meio de uma IA generativa avançada.

## Índice
- [Sobre a Solução](#sobre-a-solução)
- [Recursos da Plataforma](#recursos-da-plataforma)
  - [Análise de Dados](#análise-de-dados)
  - [Sugestões Personalizadas](#sugestões-personalizadas)
  - [Monitoramento Contínuo](#monitoramento-contínuo)
  - [Certificações](#certificações)
- [Integrantes](#integrantes)

## Sobre a Solução

O **Greenway** é uma inovadora plataforma SaaS projetada para auxiliar empresas na gestão de suas operações rumo à sustentabilidade. Através de um acompanhamento detalhado dos processos de produção, a plataforma tem como objetivo promover o desenvolvimento sustentável e, ao mesmo tempo, gerar benefícios econômicos para as organizações.

A plataforma utiliza **IA Generativa de ponta** para analisar os dados gerados pelas empresas e fornecer insights valiosos. Esses insights incluem sugestões de melhorias e boas práticas que ajudam as empresas a alcançar suas metas de sustentabilidade.

Além disso, o **Greenway** monitora continuamente o progresso das empresas em direção à sustentabilidade, garantindo que estejam no caminho certo.

## Recursos da Plataforma

### Análise de Dados

O **Greenway** coleta e analisa os dados operacionais das empresas utilizando uma IA generativa. Essa análise identifica oportunidades de melhoria nos processos, ajudando as empresas a tomar decisões mais informadas para alcançar a sustentabilidade.

### Sugestões Personalizadas

Com base na análise dos dados, a plataforma oferece **sugestões personalizadas** para cada empresa, recomendando modificações nos processos de produção que possam contribuir para a sustentabilidade.

### Monitoramento Contínuo

O progresso das empresas em direção às suas metas de sustentabilidade é **monitorado em tempo real** pela IA. Isso garante que as organizações estejam sempre no caminho certo.

### Certificações

As empresas que utilizam a plataforma recebem **certificações automáticas** em formato de badges. Essas certificações atestam o comprometimento da empresa com práticas sustentáveis, fortalecendo sua reputação no mercado e sua relação com os consumidores.

[Link da Apresentação](https://youtu.be/eGrA5A0sdb8)

## Integrantes

- **RM99513** - Rodrigo Batista Freire - Java Advanced
- **RM99562** - Kaique Santos de Andrade - Mobile Development
- **RM99466** - Marcelo Augusto de Mello Paixão - Development with .NET, DevOps & Cloud Computing e Quality Assurance
- **RM97967** - Vinicius Oliveira de Almeida - Mastering Database
- **RM98644** - Thiago Martins Bezerra - Disruptive Architectures (IA)

##

### Como rodar a aplicação?

1. **Abrir o Projeto**: Abra o IntelliJ IDEA e importe o projeto Java que contém a aplicação. Se você já tem o projeto aberto, pule para o próximo passo.

2. **Localizar a Classe Principal**: No painel de navegação do IntelliJ, encontre a classe GreenwayApplication. Essa é a classe que contém o método `public static void main(String[] args)`, responsável por iniciar a aplicação.

4. **Executar a Aplicação**: Depois de verificar a configuração da classe principal, você pode executar a aplicação clicando no botão "Run" na barra de ferramentas do IntelliJ ou pressionando Shift + F10.

5. **Acompanhar a Saída**: Durante a execução, o IntelliJ exibirá mensagens de saída no console. Certifique-se de observar essas mensagens para acompanhar o progresso da aplicação e identificar possíveis erros.

6. **Documentação**: Para acessar todos os endpoints da aplicação, acesse o link http://localhost:8080/swagger-ui/index.html

##

### Diagramas

- ### Diagrama de classe
![greenway_diagrama_classes (1)](https://github.com/greenway-FIAP/backend/assets/89154929/be1eb7f7-bbbb-47e2-9145-1b865ccdab93)


- ### Diagrama de entidade e relacionamento
![Bd](https://github.com/greenway-FIAP/backend/assets/89154929/4f77882c-d73d-4519-9a5e-ce618520add3)


- ### Diagrama de arquitetura
![greenway_arquitetura_sprint2](https://github.com/greenway-FIAP/backend/assets/80494196/cbd34e2f-afaf-4a06-a8c0-15e0d7286e5d)



##

### Sprint 1 - Endpoints

- product-controller
  * GET -> `api/product/{id}`
  * PUT -> `api/product/{id}`
  * DELETE -> `api/product/{id}`
  * GET -> `api/product`
  * POST -> `api/product`
 
- sector-controller
  * GET -> `api/sector/{id}`
  * PUT -> `api/sector/{id}`
  * DELETE -> `api/sector/{id}`
  * GET -> `api/sector`
  * POST -> `api/sector`

- product-type-controller
  * GET ->  `api/product-type/{id}`
  * PUT -> `api/product-type/{id}`
  * DELETE -> `api/product-type/{id}`
  * GET -> `api/product-type`
  * POST -> `api/product-type`

- process-controller
  * GET -> `api/process/{id}`
  * PUT -> `api/process/{id}`
  * DELETE -> `api/process/{id}`
  * GET -> `api/process`
  * POST -> `api/process`

- company-controller
  * GET -> `api/company/{id}`
  * PUT -> `api/company/{id}`
  * DELETE -> `api/company/{id}`
  * GET -> `api/company`
  * POST -> `api/company`

##

 ### Sprint 2 - Endpoints
 
- resource-type-controller
  * GET ->  `api/resource-type/{id}`
  * PUT -> `api/resource-type/{id}`
  * DELETE -> `api/resource-type/{id}`
  * GET -> `api/resource-type`
  * POST -> `api/resource-type`

- resource-controller
  * GET -> `api/resource/{id}`
  * PUT -> `api/resource/{id}`
  * DELETE -> `api/resource/{id}`
  * GET -> `api/resource`
  * POST -> `api/resource`

- process-resource-controller
  * GET -> `api/processResource/{id}`
  * PUT -> `api/processResource/{id}`
  * DELETE -> `api/processResource/{id}`
  * GET -> `api/processResource`
  * POST -> `api/processResource`

- address-controller
  * GET -> `api/address/{id}`
  * PUT -> `api/address/{id}`
  * DELETE -> `api/address/{id}`
  * GET -> `api/address`
  * POST -> `api/address`

- user-type-controller
  * GET ->  `api/user-type/{id}`
  * PUT -> `api/user-type/{id}`
  * DELETE -> `api/user-type/{id}`
  * GET -> `api/user-type`
  * POST -> `api/user-type`

- user-controller
  * GET -> `api/user/{id}`
  * PUT -> `api/user/{id}`
  * DELETE -> `api/user/{id}`
  * GET -> `api/user`
  * POST -> `api/user`

- company-representative-controller
  * GET -> `api/companyRepresentative/{id}`
  * PUT -> `api/companyRepresentative/{id}`
  * DELETE -> `api/companyRepresentative/{id}`
  * GET -> `api/companyRepresentative`
  * POST -> `api/companyRepresentative`

 
