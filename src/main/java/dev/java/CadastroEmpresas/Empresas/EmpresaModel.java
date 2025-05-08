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
public class EmpresaModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }
    private String nome;
    //A coluna tem que ser unica
    @Column(unique = true)
    private String email;

    private String imgUrl;

    @Column(unique = true)
    private int cnpj;

    //@ManyToOne uma empresa tem um único servico
    @ManyToOne
    @JoinColumn(name = "servico_id")
    private ServicoModel servico;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public ServicoModel getServico() {
        return servico;
    }

    public void setServico(ServicoModel servico) {
        this.servico = servico;
    }
}
