package br.com.meusistema.api.mapper;

import br.com.meusistema.api.dto.ProdutoRequestDTO;
import br.com.meusistema.api.dto.ProdutoResponseDTO;
import br.com.meusistema.api.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mapping(target = "fornecedor", ignore = true)
    Produto toEntity(ProdutoRequestDTO dto);

    ProdutoResponseDTO toDTO(Produto produto);
}