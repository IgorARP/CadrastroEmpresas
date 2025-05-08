Apresentação

O Cadastro de empresas é um sistema CRUD desenvolvido para gerenciar listas personalizadas de empresas (ou qualquer outro tipo de relação entre objetos e grupos). O projeto permite organizar empresas em listas específicas, facilitando a categorização e a personalização. Cada empresa tem suas caracteristicas como, nome, email, cnpj, 

Tecnologias utilizadas
Java (Spring Boot)

Spring Data JPA

JPA(Java Persistence API)

Hibernate(ORM)

Postman

Camadas estruturadas:
Estrutura do Domínio / Observações
APIs RESTful para criar, consultar e atualizar empresas e listas.

Organização de empresas em listas personalizadas, com a capacidade de definir posições específicas dentro de cada lista.

Arquitetura MVC:

Controller: Exposição das APIs REST.
Service: Contém a lógica de negócios.
Repository: Comunicação com o banco de dados.
DTOs: Transferência de dados otimizada para evitar exposição direta de entidades.
