package br.com.meusistema.api.mapper;

import br.com.meusistema.api.dto.EnderecoDTO;
import br.com.meusistema.api.model.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    Endereco toEntity(EnderecoDTO dto);

    EnderecoDTO toDTO(Endereco endereco);
}
