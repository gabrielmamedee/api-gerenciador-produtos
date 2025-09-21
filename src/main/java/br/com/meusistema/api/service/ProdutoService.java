package br.com.meusistema.api.service;

import br.com.meusistema.api.dto.ProdutoRequestDTO;
import br.com.meusistema.api.dto.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoService {
    ProdutoResponseDTO criarProduto(ProdutoRequestDTO dto);
    List<ProdutoResponseDTO> listarTodos();
    ProdutoResponseDTO buscarPorId(Long id);
    ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto);
    void deletar(Long id);
}
