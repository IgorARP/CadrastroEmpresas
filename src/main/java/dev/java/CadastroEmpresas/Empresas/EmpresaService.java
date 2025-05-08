package dev.java.CadastroEmpresas.Empresas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;
    private EmpresaMapper empresaMapper;

    public EmpresaService(EmpresaRepository empresaRepository, EmpresaMapper empresaMapper) {
        this.empresaRepository = empresaRepository;
        this.empresaMapper = empresaMapper;
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
    public EmpresaDTO criarEmpresa(EmpresaDTO empresaDTO){
       EmpresaModel empresa = empresaMapper.map(empresaDTO);
       empresa = empresaRepository.save(empresa);
       return empresaMapper.map(empresa);
    }

    //Deletar EmpresaPorID TEM QUE SER METODO VOID
    public void deletarEmpresaPorID(Long id){
         empresaRepository.deleteById(id);
    }

    //Atualizar Empresa
    public EmpresaModel atualizarEmpresa(Long id, EmpresaModel empresa) {
        if (empresaRepository.existsById(id)) {
            empresa.setId(id);
            return empresaRepository.save(empresa);
        }
        return null;
    }

}