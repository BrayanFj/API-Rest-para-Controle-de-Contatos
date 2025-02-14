package br.com.BrayanFJ.ApiControleDeContatos.service;

import br.com.BrayanFJ.ApiControleDeContatos.model.Pessoa;
import br.com.BrayanFJ.ApiControleDeContatos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    // Método para salvar uma pessoa
    public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    // Método para buscar todas as pessoas
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    // Método para buscar uma pessoa por ID
    public Optional<Pessoa> buscarPessoaPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    // Método para excluir uma pessoa
    public void excluirPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

    //Método para atualizar a pessoa
    public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaOptional.get();
            pessoa.setNome(pessoaAtualizada.getNome());
            pessoa.setEndereco(pessoaAtualizada.getEndereco());
            pessoa.setCep(pessoaAtualizada.getCep());
            pessoa.setCidade(pessoaAtualizada.getCidade());
            pessoa.setUf(pessoaAtualizada.getUf());

            return pessoaRepository.save(pessoa);
        } else {
            throw new RuntimeException("Pessoa não encontrada!");
        }
    }


}
