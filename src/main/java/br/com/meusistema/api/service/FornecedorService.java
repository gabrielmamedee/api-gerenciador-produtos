package br.com.meusistema.api.service;

import br.com.meusistema.api.dto.FornecedorRequestDTO;
import br.com.meusistema.api.dto.FornecedorResponseDTO;

import java.util.List;

public interface FornecedorService {

    FornecedorResponseDTO criarFornecedor(FornecedorRequestDTO dto);
    List<FornecedorResponseDTO> listarTodosFornecedores();
    FornecedorResponseDTO buscarFornecedorPeloId(Long id);
    FornecedorResponseDTO atualizarFornecedorPeloId(Long id, FornecedorRequestDTO dto);
    void deletarFornecedorPeloId(Long id);
}
