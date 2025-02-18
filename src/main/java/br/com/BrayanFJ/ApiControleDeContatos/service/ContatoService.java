package br.com.BrayanFJ.ApiControleDeContatos.service;

import br.com.BrayanFJ.ApiControleDeContatos.model.Contato;
import br.com.BrayanFJ.ApiControleDeContatos.repository.ContatoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    // Método para salvar um novo contato
    public Contato salvarContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    // Método para buscar todos os contatos
    public List<Contato> listarTodosContatos() {
        return contatoRepository.findAll();
    }

    // Método para buscar um contato por ID
    public List<Contato> listarContatosPorPessoa(Long idPessoa) {
        return contatoRepository.findByPessoaId(idPessoa);
    }

    // Método para atualizar um contato existente
    public Contato atualizarContato(Long id, Contato contato) {
        if (contatoRepository.existsById(id)) {
            contato.setId(id);
            return contatoRepository.save(contato);
        }
        return null;
    }

    // Método para excluir um contato existente
    @Transactional
    public void deletarContato(Long id) {
        if (!contatoRepository.existsById(id)) {
            throw new EntityNotFoundException("Contato com ID " + id + " não encontrado.");
        }
        contatoRepository.deleteById(id);
    }

}
