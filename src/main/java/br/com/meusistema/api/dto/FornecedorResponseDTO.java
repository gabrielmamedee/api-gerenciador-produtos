package br.com.meusistema.api.dto;

import br.com.meusistema.api.enums.TipoFornecedorEnum;

public record FornecedorResponseDTO(
        Long id,
        String nomeFantasia,
        String email,
        String cnpj,
        TipoFornecedorEnum tipoFornecedorEnum,
        EnderecoDTO endereco
) {
}
