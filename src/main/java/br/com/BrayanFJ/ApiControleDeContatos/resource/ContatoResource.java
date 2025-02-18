package br.com.BrayanFJ.ApiControleDeContatos.resource;

import br.com.BrayanFJ.ApiControleDeContatos.model.Contato;
import br.com.BrayanFJ.ApiControleDeContatos.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contatos") // Mapeia a URL para esta classe
public class ContatoResource {

    @Autowired
    private ContatoService contatoService;

    //Endpoints

    @Operation(summary = "Endpoint para criar um novo")
    @PostMapping
    public ResponseEntity<Contato> criarContato(@RequestBody Contato contato) {
        Contato novoContato = contatoService.salvarContato(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoContato);
    }


    @Operation(summary = "Endpoint para listar todos os contatos")
    @GetMapping
    public List<Contato> listarContatos() {
        return contatoService.listarTodosContatos();
    }


    @Operation(summary = "Endpoint para buscar um contato por ID")
    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<List<Contato>> listarContatosPorPessoa(@PathVariable Long idPessoa) {
        List<Contato> contatos = contatoService.listarContatosPorPessoa(idPessoa);

        //valida se a pessoa existe
        if (contatos == null || contatos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.emptyList());
        }
        return ResponseEntity.ok(contatos);
    }


    @Operation(summary = "Endpoint para atualizar um contato")
    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizarContato(@PathVariable Long id, @RequestBody Contato contato) {
        Contato contatoAtualizado = contatoService.atualizarContato(id, contato);

        if (contatoAtualizado != null) {
            return ResponseEntity.ok(contatoAtualizado);  // Retorna o contato atualizado
        }
        return ResponseEntity.notFound().build();  // Retorna 404 caso o contato não existir
    }


    @Operation(summary = "Endpoint para excluir um contato")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (!contatoService.deletarContato(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Contato com ID " + id + " não encontrado.");
        }
        return ResponseEntity.noContent().build();
    }

}
