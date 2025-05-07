package dev.java.CadastroEmpresas.Empresas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    //Listar Todas as empresas
    public List<EmpresaModel> listarEmpresa(){
        return empresaRepository.findAll();
    }
}