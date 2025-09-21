package br.com.meusistema.api.mapper;

import br.com.meusistema.api.dto.ClienteRequestDTO;
import br.com.meusistema.api.dto.ClienteResponseDTO;
import br.com.meusistema.api.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    Cliente toEntity(ClienteRequestDTO dto);

    ClienteResponseDTO toDTO(Cliente cliente);
}
