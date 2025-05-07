package dev.java.CadastroEmpresas.Servicos;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servico")
public class ServicoController {


    //GET- Mandar uma requisição para mostrar os serviços
    @GetMapping("/listar")
    public String listarServico(){return "Serviço listado";}

    //POST- Mandar uma requisição para criar os serviços
    @PostMapping("/criar")
    public String criarServico(){return "Serviço criado";}

    //PUT- Mandar uma requisição para alterar os serviços
    @PutMapping("/alterar")
    public String alterarServico(){return "Serviço alterado";}

    //DELETE- Mandar uma requisição para deletar os serviços
    @DeleteMapping("/deletar")
    public String deletarServico(){return "Serviço deletado";}
}
