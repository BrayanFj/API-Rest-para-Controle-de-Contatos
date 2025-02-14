package br.com.BrayanFJ.ApiControleDeContatos.repository;

import br.com.BrayanFJ.ApiControleDeContatos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
