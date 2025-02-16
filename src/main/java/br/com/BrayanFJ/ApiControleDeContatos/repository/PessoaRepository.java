package br.com.BrayanFJ.ApiControleDeContatos.repository;

import br.com.BrayanFJ.ApiControleDeContatos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
