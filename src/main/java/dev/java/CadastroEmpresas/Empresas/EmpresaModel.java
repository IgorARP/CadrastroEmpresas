package dev.java.CadastroEmpresas.Empresas;

import dev.java.CadastroEmpresas.Servicos.ServicoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entity transforma uma classe em uma entidade no BD
@Entity
@Table(name = "tb_cadastro_empresas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpresaModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    //A coluna tem que ser unica
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private int cnpj;

    //@ManyToOne uma empresa tem um único servico
    @ManyToOne
    @JoinColumn(name = "servico_id")
    private ServicoModel servicos;
}
