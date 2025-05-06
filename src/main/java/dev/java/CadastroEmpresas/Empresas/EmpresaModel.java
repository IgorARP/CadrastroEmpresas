package dev.java.CadastroEmpresas.Empresas;

import dev.java.CadastroEmpresas.Servicos.ServicoModel;
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

    //@ManyToOne uma empresa tem um único servico
    @ManyToOne
    @JoinColumn(name = "servico_id")
    private ServicoModel servicos;
}
