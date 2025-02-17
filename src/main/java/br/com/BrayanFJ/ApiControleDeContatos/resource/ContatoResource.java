package br.com.BrayanFJ.ApiControleDeContatos.resource;

import br.com.BrayanFJ.ApiControleDeContatos.model.Contato;
import br.com.BrayanFJ.ApiControleDeContatos.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contatos") // Mapeia a URL para esta classe
public class ContatoResource {

    @Autowired
    private ContatoService contatoService;

    // Endpoint para criar um novo contato (CRUD - POST)
    @PostMapping
    public Contato criarContato(@RequestBody Contato contato) {
        return contatoService.salvarContato(contato);
    }

    // Endpoint para listar todos os contatos (CRUD - gET)
    @GetMapping
    public List<Contato> listarContatos() {
        return contatoService.listarTodosContatos();
    }

    // Endpoint para buscar um contato por ID (CRUD - GET / este busca por um id especifico )
    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscarContatoPorId(@PathVariable Long id) {
        Optional<Contato> contato = contatoService.buscarContatoPorId(id);
        return contato.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
