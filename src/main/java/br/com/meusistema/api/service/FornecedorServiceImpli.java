package br.com.meusistema.api.service;

import br.com.meusistema.api.dto.FornecedorRequestDTO;
import br.com.meusistema.api.dto.FornecedorResponseDTO;
import br.com.meusistema.api.mapper.EnderecoMapper;
import br.com.meusistema.api.mapper.FornecedorMapper;
import br.com.meusistema.api.model.Fornecedor;
import br.com.meusistema.api.repository.FornecedorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FornecedorServiceImpli implements FornecedorService {

    private final FornecedorRepository fornecedorRepository;
    private final FornecedorMapper fornecedorMapper;
    private final EnderecoMapper enderecoMapper;

    @Override
    public FornecedorResponseDTO criarFornecedor(FornecedorRequestDTO dto) {
        // Converte o DTO para Entidade
        Fornecedor fornecedor = fornecedorMapper.toEntity(dto);
        return fornecedorMapper.toDTO(fornecedorRepository.save(fornecedor));

    }

    @Override
    public List<FornecedorResponseDTO> listarTodosFornecedores() {
        return fornecedorRepository.findAll().stream()
                .map(fornecedorMapper::toDTO)
                .toList();
    }

    @Override
    public FornecedorResponseDTO buscarFornecedorPeloId(Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Fornecedor não encontrado"));
        return fornecedorMapper.toDTO(fornecedor);
    }

    @Transactional
    @Override
    public FornecedorResponseDTO atualizarFornecedorPeloId(Long id, FornecedorRequestDTO dto) {
        Fornecedor fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Fornecedor não encontrado"));

        fornecedor.setNome(dto.nome());
        fornecedor.setEmail(dto.email());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setTipoFornecedor(dto.tipoFornecedor());
        fornecedor.setEndereco(enderecoMapper.toEntity((dto.endereco())));

        fornecedorRepository.save(fornecedor);

        return fornecedorMapper.toDTO(fornecedor);
    }

    @Transactional
    @Override
    public void deletarFornecedorPeloId(Long id) {
        if (!fornecedorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Fornecedor não encontrado");
        }

        fornecedorRepository.deleteById(id);
    }
}
