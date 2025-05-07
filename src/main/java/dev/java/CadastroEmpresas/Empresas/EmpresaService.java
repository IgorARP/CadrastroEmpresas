package dev.java.CadastroEmpresas.Empresas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Lista empresa por ID
    public EmpresaModel listarEmpresaPorID(Long id){
        Optional<EmpresaModel>empresaPorID = empresaRepository.findById(id);
        return empresaPorID.orElse(null);
    }

    //Criar uma nova empresa
    public EmpresaModel criarEmpresa(EmpresaModel empresaModel){
        return empresaRepository.save(empresaModel) ;
    }

    //Deletar EmpresaPorID TEM QUE SER METODO VOID
    public void deletarEmpresaPorID(Long id){
         empresaRepository.deleteById(id);
    }
}