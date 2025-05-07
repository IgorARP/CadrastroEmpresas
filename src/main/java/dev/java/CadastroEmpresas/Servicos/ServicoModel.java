package dev.java.CadastroEmpresas.Servicos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java.CadastroEmpresas.Empresas.EmpresaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "tb_servico")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServicoModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String urgencia;

    // Um serviço pode ter varias empresas
    @OneToMany(mappedBy = "servico")
    @JsonIgnore
    private List<EmpresaModel> empresas;
}
