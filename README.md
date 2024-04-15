# Greenway

## Sobre a solução
O Greenway é uma inovadora plataforma SaaS projetada para auxiliar empresas na gestão de suas operações rumo à sustentabilidade. Ao oferecer um acompanhamento minucioso dos processos de produção, nosso objetivo é fomentar o desenvolvimento sustentável, ao mesmo tempo em que impulsionamos benefícios econômicos para as organizações. Nossa plataforma, equipada com uma IA Generativa de ponta, tem a capacidade de analisar os dados gerados pelas empresas e fornecer insights valiosos. Através de sugestões personalizadas, promovemos modificações e boas práticas que contribuem para o alcance de metas sustentáveis. Além disso, monitoramos continuamente o progresso das empresas através da IA, garantindo que estejam no caminho certo para a sustentabilidade. Um dos diferenciais do Greenway é a certificação por meio de badges gerados automaticamente pela plataforma, que atestam o comprometimento das empresas com a redução dos impactos no meio ambiente. Essa validação não apenas reforça a reputação das empresas no mercado, mas também fortalece o relacionamento com os consumidores finais. Ao criar novos canais de comunicação e aumentar a transparência, lealdade, preferência e confiança também são cultivadas junto ao público-alvo.

[Link da apresentação](https://youtu.be/WJ93nQ6kmbc)

## Integrantes

- 99513 - Rodrigo Batista Freire - Quality Assurance

- 99562 - Kaique Santos de Andrade - Web e Mobile

- 550841 - Lucas Araujo Oliveira Silva - Back-end e IA

- 99466 - Marcelo Augusto de Mello Paixão - DevOps

## Como rodar a aplicação?

1. **Abrir o Projeto**: Abra o IntelliJ IDEA e importe o projeto Java que contém a aplicação. Se você já tem o projeto aberto, pule para o próximo passo.

2. **Localizar a Classe Principal**: No painel de navegação do IntelliJ, encontre a classe GreenwayApplication. Essa é a classe que contém o método `public static void main(String[] args)`, responsável por iniciar a aplicação.

4. **Executar a Aplicação**: Depois de verificar a configuração da classe principal, você pode executar a aplicação clicando no botão "Run" na barra de ferramentas do IntelliJ ou pressionando Shift + F10.

5. **Acompanhar a Saída**: Durante a execução, o IntelliJ exibirá mensagens de saída no console. Certifique-se de observar essas mensagens para acompanhar o progresso da aplicação e identificar possíveis erros.

6. **Documentação**: Para acessar todos os endpoints da aplicação, acesse o link http://localhost:8080/swagger-ui/index.html


## Diagramas

- ### Diagrama de classe
  <img src="https://github.com/greenway-FIAP/backend/blob/main/diagramas/greenway_diagrama_classes.jpg">

- ### Diagrama de entidade e relacionamento
  <img src="https://github.com/greenway-FIAP/backend/blob/main/diagramas/greenway_modelagem_banco.jpg">

- ### Diagrama de arquitetura
  <img src="https://github.com/greenway-FIAP/backend/blob/main/diagramas/greenway_arquitetura.jpg">

## Endpoints

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
