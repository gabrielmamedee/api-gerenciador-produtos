package br.com.meusistema.api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotNull(message = "Preço é obrigatorio")
        @DecimalMin(value = "0.0", message = "Preço deve ser maior ou igual a zero")
        BigDecimal preco,

        String descricao,

        @NotNull(message = "Quantidade em estoque é obrigatorio")
        @Min(value = 0, message = "Quantidade não pode ser negativa")
        Integer quantidadeEstoque,

        @NotNull(message = "Informe o fornecedor")
        Long fornecedorId
) {
}
