package br.com.BrayanFJ.ApiControleDeContatos.DTO;

import br.com.BrayanFJ.ApiControleDeContatos.model.Pessoa;

public record PessoaMalaDiretaDTO(Long id, String nome, String enderecoMalaDireta) {

    public PessoaMalaDiretaDTO(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(),
                pessoa.getEndereco() + " - CEP: " + pessoa.getCep() +
                        " - " + pessoa.getCidade() + "/" + pessoa.getUf());
    }
}
