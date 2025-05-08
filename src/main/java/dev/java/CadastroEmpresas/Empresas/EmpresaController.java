package dev.java.CadastroEmpresas.Empresas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar Empresa(CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarEmpresa(@RequestBody EmpresaDTO empresa) {
        EmpresaDTO novaempresa = empresaService.criarEmpresa(empresa);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Empresa Criada C0m sucesso: " + novaempresa.getNome() + " (ID):" + novaempresa.getId());
    }

    //Mostrar todas as Empresas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<EmpresaDTO>> listarEmpresa() {
        List<EmpresaDTO> empresas = empresaService.listarEmpresa();
        return ResponseEntity.ok(empresas);
    }

    //Mostrar empresa por ID(READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarEmpresaPorID(@PathVariable Long id) {

        EmpresaDTO empresas = empresaService.listarEmpresaPorID(id);

        if (empresas != null){
            return ResponseEntity.ok(empresas);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A empresa com esse id: "+id+" não foi encontrada nos nossos registros");
        }
    }

    //Alterar dados das Empresas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarEmpresaPorID(@PathVariable Long id, @RequestBody EmpresaDTO empresaAtualizada) {
        EmpresaDTO empresas= empresaService.atualizarEmpresa(id, empresaAtualizada);
        if (empresas !=null){
            return ResponseEntity.ok(empresas);

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A empresa com esse id: "+id+" não foi encontrada nos nossos registros");
        }
    }

    //Deletar Empresa (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarEmpresaPorID(@PathVariable Long id) {
        if (empresaService.listarEmpresaPorID(id) != null) {
            empresaService.deletarEmpresaPorID(id);
            return ResponseEntity.ok("Empresa deletada com sucesso ");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A Empresa com a id: " + id + " Nao encontrada");
        }
    }
}

