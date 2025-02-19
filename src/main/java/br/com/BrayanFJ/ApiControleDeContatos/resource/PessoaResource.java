package br.com.BrayanFJ.ApiControleDeContatos.resource;

import br.com.BrayanFJ.ApiControleDeContatos.DTO.PessoaMalaDiretaDTO;
import br.com.BrayanFJ.ApiControleDeContatos.model.Pessoa;
import br.com.BrayanFJ.ApiControleDeContatos.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//import br.com.BrayanFJ.ApiControleDeContatos.DTO.PessoaMalaDiretaDTO;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/pessoas")  // Mapeia a URL para esta classe
public class PessoaResource {

    @Autowired  // Injeta o serviço PessoaService
    private PessoaService pessoaService;


    @Operation(summary = "Endpoint para criar uma pessoa")
    @PostMapping
    public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa) {
        if (pessoa.getNome() == null || pessoa.getNome().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null); // Retorna erro 400 se nome for inválido
        }

        Pessoa novaPessoa = pessoaService.criarPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
    }


    @Operation(summary = "Endpoint para buscar uma pessoa por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.buscarPessoaPorId(id);


        if (pessoa.isPresent()) {
            return ResponseEntity.ok(pessoa.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); //Caso não encontre a pessoa retorna null
        }
    }



    @Operation(summary = "Endpoint que retorna os dados de uma Pessoa por ID para mala direta")
    @GetMapping("/malaDireta/{id}")
    public ResponseEntity<PessoaMalaDiretaDTO> buscarMalaDireta(@PathVariable Long id) {
        Optional<PessoaMalaDiretaDTO> resultado = pessoaService.buscarIDMaladireta(id);

        if (resultado.isPresent()) {
            return ResponseEntity.ok(resultado.get());
        } else {
            return ResponseEntity.status(404).body(null); // Retorna 404 caso não encontre a pessoa
        }
    }


    @Operation(summary = "Endpoint para listar todas as pessoas")
    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        List<Pessoa> pessoas = pessoaService.listarPessoas();

        if (pessoas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna erro 404 se não houver pessoas
        }

        return ResponseEntity.ok(pessoas);
    }



    @Operation(summary = "Endpoint para atualizar uma pessoa pelo ID")
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> editar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        if (pessoa.getNome() == null || pessoa.getNome().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Pessoa pessoaEditada = pessoaService.atualizarPessoa(id, pessoa);

        if (pessoaEditada != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(pessoaEditada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  }
    }




    @Operation(summary = "Endpoint para excluir uma pessoa")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        boolean deletado = pessoaService.excluirPessoa(id);

        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID: " + id + " deletado");
        }
    }


}
