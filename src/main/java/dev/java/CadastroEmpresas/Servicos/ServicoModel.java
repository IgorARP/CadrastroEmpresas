package dev.java.CadastroEmpresas.Servicos;

import dev.java.CadastroEmpresas.Empresas.EmpresaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tb_Servico")
public class ServicoModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String urgencia;

    // Um serviço pode ter varias empresas
    @OneToMany(mappedBy = "servico")
    private List<EmpresaModel> empresas;
}
