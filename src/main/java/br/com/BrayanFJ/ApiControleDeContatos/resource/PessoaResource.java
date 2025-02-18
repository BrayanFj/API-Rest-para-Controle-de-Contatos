package br.com.BrayanFJ.ApiControleDeContatos.resource;

import br.com.BrayanFJ.ApiControleDeContatos.model.Pessoa;
import br.com.BrayanFJ.ApiControleDeContatos.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import br.com.BrayanFJ.ApiControleDeContatos.model.PessoaMalaDiretaDTO;
import br.com.BrayanFJ.ApiControleDeContatos.model.Pessoa;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/pessoas")  // Mapeia a URL para esta classe
public class PessoaResource {

    @Autowired  // Injeta o serviço PessoaService
    private PessoaService pessoaService;

    // Endpoint para criar uma pessoa
    @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.salvarPessoa(pessoa);  // Chama o serviço para salvar
    }

    // Endpoint para buscar uma pessoa pelo ID
    @GetMapping("/{id}")
    public Optional<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
        return pessoaService.buscarPessoaPorId(id);  // Chama o serviço para buscar pelo ID
    }

    // Retorna os dados de uma Pessoa por ID para mala direta
    //@Operation(summary = "Retorna os dados de uma Pessoa por ID para mala direta")
    @GetMapping("/maladireta/{id}")
    public ResponseEntity<PessoaMalaDiretaDTO> obterMalaDireta(@PathVariable Long id) {
        PessoaMalaDiretaDTO dto = pessoaService.obterMalaDiretaPorId(id);
        return ResponseEntity.ok(dto);
    }

    // Endpoint para listar todas as pessoas
    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();  // Chama o serviço para lista
         }


    //Endpoint para atualizar uma pessoa pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        try {
            Pessoa pessoaAtualizada = pessoaService.atualizarPessoa(id, pessoa);
            return ResponseEntity.ok(pessoaAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    // Endpoint para excluir uma pessoa
    @DeleteMapping("/{id}")
    public void excluirPessoa(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);  // Chama o serviço para excluir
    }



}
