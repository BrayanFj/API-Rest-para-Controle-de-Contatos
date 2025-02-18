package br.com.BrayanFJ.ApiControleDeContatos.service;

import br.com.BrayanFJ.ApiControleDeContatos.model.Pessoa;
import br.com.BrayanFJ.ApiControleDeContatos.DTO.PessoaMalaDiretaDTO;
import br.com.BrayanFJ.ApiControleDeContatos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    // Método para criar uma pessoa
    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    // Método para listar todas as pessoas
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    // Método para buscar uma pessoa por ID
    public Optional<Pessoa> buscarPessoaPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public Optional<PessoaMalaDiretaDTO> buscarIDMaladireta(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

        // Se a pessoa for encontrada, cria o DTO para Mala Direta
        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaOptional.get();
            return Optional.of(new PessoaMalaDiretaDTO(pessoa));
        } else {
            return Optional.empty(); // Retorna vazio se não encontrar a pessoa
        }
    }


    // Método para excluir uma pessoa
    public boolean excluirPessoa(Long id) {
        pessoaRepository.deleteById(id);
        return false;
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
