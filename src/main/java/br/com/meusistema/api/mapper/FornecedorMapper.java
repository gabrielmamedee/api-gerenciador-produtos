package br.com.meusistema.api.mapper;

import br.com.meusistema.api.dto.FornecedorRequestDTO;
import br.com.meusistema.api.dto.FornecedorResponseDTO;
import br.com.meusistema.api.model.Fornecedor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FornecedorMapper {

    @Mapping(target = "id", ignore = true)
    Fornecedor toEntity(FornecedorRequestDTO dto);

    @Mapping(source = "tipoFornecedor", target = "tipoFornecedorEnum")
    FornecedorResponseDTO toDTO(Fornecedor fornecedor);
}
