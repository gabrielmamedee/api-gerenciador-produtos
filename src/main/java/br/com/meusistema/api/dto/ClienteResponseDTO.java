package br.com.meusistema.api.dto;

public record ClienteResponseDTO (
        Long id,
        String nome,
        String cpf,
        String email,
        EnderecoDTO endereco
) {
}
