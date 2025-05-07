package dev.java.CadastroEmpresas.Empresas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar Empresa(CREATE)
    @PostMapping("/criar")
    public String criarEmpresa(){return "Empresa Criada";}

    //Mostrar todas as Empresas (READ)
    @GetMapping("/todos")
    public List<EmpresaModel> listarEmpresa(){return empresaService.listarEmpresa();}

    //Alterar dados das EMpresas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarEmpresaPorID(){return "Empresa alterada";}

    //Deletar EMpresa (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarEmpresaPorID(){return "Empresa deletada";}

}
