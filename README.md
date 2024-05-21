![Greenway_TextGray](https://github.com/greenway-FIAP/backend/assets/80494196/d916d6b5-ebd5-472f-ad88-f067bbcc8fb6)


### Sobre a solução
O Greenway é uma inovadora plataforma SaaS projetada para auxiliar empresas na gestão de suas operações rumo à sustentabilidade. Ao oferecer um acompanhamento minucioso dos processos de produção, nosso objetivo é fomentar o desenvolvimento sustentável, ao mesmo tempo em que impulsionamos benefícios econômicos para as organizações. Nossa plataforma, equipada com uma IA Generativa de ponta, tem a capacidade de analisar os dados gerados pelas empresas e fornecer insights valiosos. Através de sugestões personalizadas, promovemos modificações e boas práticas que contribuem para o alcance de metas sustentáveis. Além disso, monitoramos continuamente o progresso das empresas através da IA, garantindo que estejam no caminho certo para a sustentabilidade. Um dos diferenciais do Greenway é a certificação por meio de badges gerados automaticamente pela plataforma, que atestam o comprometimento das empresas com a redução dos impactos no meio ambiente. Essa validação não apenas reforça a reputação das empresas no mercado, mas também fortalece o relacionamento com os consumidores finais. Ao criar novos canais de comunicação e aumentar a transparência, lealdade, preferência e confiança também são cultivadas junto ao público-alvo.

[Link da apresentação](https://youtu.be/eGrA5A0sdb8)

##

### Integrantes

- 99513 - Rodrigo Batista Freire - Back-end

- 99562 - Kaique Santos de Andrade - Web e Mobile

- 99466 - Marcelo Augusto de Mello Paixão - DevOps e IA

- 97967 - Vinicius Oliveira de Almeida - Mastering Database

- 98644 - Thiago Martins Bezerra - Quality Assurance

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

 
