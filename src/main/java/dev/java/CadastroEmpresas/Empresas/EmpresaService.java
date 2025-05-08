package dev.java.CadastroEmpresas.Empresas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;
    private EmpresaMapper empresaMapper;

    public EmpresaService(EmpresaRepository empresaRepository, EmpresaMapper empresaMapper) {
        this.empresaRepository = empresaRepository;
        this.empresaMapper = empresaMapper;
    }

    //Listar Todas as empresas
    public List<EmpresaDTO> listarEmpresa(){
        List<EmpresaModel> empresa = empresaRepository.findAll();
        return empresa.stream()
                .map(empresaMapper::map)
                .collect(Collectors.toList());
    }

    //Lista empresa por ID
    public EmpresaDTO listarEmpresaPorID(Long id){
        Optional<EmpresaModel>empresaPorID = empresaRepository.findById(id);
        return empresaPorID.map(empresaMapper::map).orElse(null);
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
    public EmpresaDTO atualizarEmpresa(Long id, EmpresaDTO empresaDTO) {
        Optional<EmpresaModel> empresaExistente = empresaRepository.findById(id);
        if (empresaExistente.isPresent()){
            EmpresaModel empresaAtualizada = empresaMapper.map(empresaDTO);
            empresaAtualizada.setId(id);
            EmpresaModel empresaSalvo = empresaRepository.save(empresaAtualizada);
            return empresaMapper.map(empresaSalvo);
        }
        return null;
    }

}