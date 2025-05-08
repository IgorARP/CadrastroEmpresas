package dev.java.CadastroEmpresas.Empresas;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/empresa/ui")
public class EmpresaControllerUI {

    private final EmpresaService empresaService;

    public EmpresaControllerUI(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }
    //Mostrar todas as Empresas (READ)
    @GetMapping("/listar")
    public String listarEmpresa(Model model) {
        List<EmpresaDTO> empresas = empresaService.listarEmpresa();
        model.addAttribute("empresas", empresas);
        return "listarEmpresas";
    }
    @GetMapping("/deletar/{id}")
    public String deletarEmpresaPorID(@PathVariable Long id) {
       empresaService.deletarEmpresaPorID(id);
       return "redirect:/empresa/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarEmpresasPorID(@PathVariable Long id, Model model){
        EmpresaDTO empresa = empresaService.listarEmpresaPorID(id);
        if (empresa != null){
            model.addAttribute("empresas", empresa);
            return "detalharEmpresa";
        }else {
            model.addAttribute("mensagem", "Empresa não encontrada");
            return "listarEmpresas";
        }
    }
}
