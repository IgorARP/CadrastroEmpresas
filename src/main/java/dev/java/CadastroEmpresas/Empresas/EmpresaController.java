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
    public EmpresaDTO criarEmpresa(@RequestBody EmpresaDTO empresa){
        return empresaService.criarEmpresa(empresa);
    }

    //Mostrar todas as Empresas (READ)
    @GetMapping("/todos")
    public List<EmpresaDTO> listarEmpresa(){
        return empresaService.listarEmpresa();
    }

    //Mostrar empresa por ID(READ)
    @GetMapping("/listar/{id}")
    public EmpresaDTO listarEmpresaPorID(@PathVariable Long id){
        return empresaService.listarEmpresaPorID(id);
    }

    //Alterar dados das Empresas (UPDATE)
    @PutMapping("/alterar/{id}")
    public EmpresaDTO alterarEmpresaPorID(@PathVariable Long id, @RequestBody EmpresaDTO empresaAtualizada){
        return empresaService.atualizarEmpresa(id,empresaAtualizada);
    }

    //Deletar Empresa (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarEmpresaPorID(@PathVariable Long id){
        empresaService.deletarEmpresaPorID(id);
    }

}
