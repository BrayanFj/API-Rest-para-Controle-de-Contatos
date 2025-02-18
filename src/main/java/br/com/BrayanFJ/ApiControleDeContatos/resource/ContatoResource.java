package br.com.BrayanFJ.ApiControleDeContatos.resource;

import br.com.BrayanFJ.ApiControleDeContatos.model.Contato;
import br.com.BrayanFJ.ApiControleDeContatos.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @GetMapping("/pessoa/{idPessoa}")
    public List<Contato> listarContatosPorPessoa(@PathVariable Long idPessoa) {
        return contatoService.listarContatosPorPessoa(idPessoa);
    }


    // Endpoint para atualizar um contato (CRUD - PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizarContato(@PathVariable Long id, @RequestBody Contato contato) {
        Contato contatoAtualizado = contatoService.atualizarContato(id, contato);

        if (contatoAtualizado != null) {
            return ResponseEntity.ok(contatoAtualizado);  // Retorna o contato atualizado
        }
        return ResponseEntity.notFound().build();  // Retorna 404 caso o contato não existir
    }

    // Endpoint para excluir um contato (CRUD - PUT)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        contatoService.deletarContato(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Contato com ID " + id + " removido com sucesso.");
    }


}
