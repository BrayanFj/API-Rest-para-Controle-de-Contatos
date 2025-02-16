package br.com.BrayanFJ.ApiControleDeContatos.service;

import br.com.BrayanFJ.ApiControleDeContatos.model.Contato;
import br.com.BrayanFJ.ApiControleDeContatos.repository.ContatoRepository;
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
    public Optional<Contato> buscarContatoPorId(Long id) {
        return contatoRepository.findById(id);
    }

    // Método para atualizar um contato existente
    public Contato atualizarContato(Long id, Contato contato) {
        if (contatoRepository.existsById(id)) {
            contato.setId(id);
            return contatoRepository.save(contato);
        }
        return null;
    }

    // Método para excluir um contato por ID
    public boolean excluirContato(Long id) {
        if (contatoRepository.existsById(id)) {
            contatoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
