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
    public EmpresaModel criarEmpresa(@RequestBody EmpresaModel empresa){
        return empresaService.criarEmpresa(empresa);
    }

    //Mostrar todas as Empresas (READ)
    @GetMapping("/todos")
    public List<EmpresaModel> listarEmpresa(){return empresaService.listarEmpresa();}

    //Mostrar empresa por ID(READ)
    @GetMapping("/listar/{id}")
    public EmpresaModel listarEmpresaPorID(@PathVariable Long id){
        return empresaService.listarEmpresaPorID(id);
    }

    //Alterar dados das Empresas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarEmpresaPorID(){return "Empresa alterada";}

    //Deletar Empresa (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarEmpresaPorID(){return "Empresa deletada";}

}
