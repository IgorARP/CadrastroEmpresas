package dev.java.CadastroEmpresas;

import jakarta.persistence.*;

//Entity transforma uma classe em uma entidade no BD
@Entity
@Table(name = "tb_cadastro_empresas")
public class EmpresaModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int cnpj;
}
