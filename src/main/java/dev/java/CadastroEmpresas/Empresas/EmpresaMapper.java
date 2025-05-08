package dev.java.CadastroEmpresas.Empresas;

import org.springframework.stereotype.Component;

@Component
public class EmpresaMapper {

    public EmpresaModel map(EmpresaDTO empresaDTO) {
        EmpresaModel empresaModel = new EmpresaModel();
        empresaModel.setId(empresaDTO.getId());
        empresaModel.setNome(empresaDTO.getNome());
        empresaModel.setEmail(empresaDTO.getEmail());
        empresaModel.setCnpj(empresaDTO.getCnpj());
        empresaModel.setImgUrl(empresaDTO.getImgUrl());
        empresaModel.setServico(empresaDTO.getServico());

        return empresaModel;
    }

    public EmpresaDTO map(EmpresaModel empresaModel){
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setId(empresaModel.getId());
        empresaDTO.setCnpj(empresaModel.getCnpj());
        empresaDTO.setNome(empresaModel.getNome());
        empresaDTO.setEmail(empresaModel.getEmail());
        empresaDTO.setCnpj(empresaModel.getCnpj());
        empresaDTO.setImgUrl(empresaModel.getImgUrl());

        return empresaDTO;
    }
}
