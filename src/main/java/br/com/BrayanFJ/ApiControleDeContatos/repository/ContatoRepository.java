package br.com.BrayanFJ.ApiControleDeContatos.repository;

import br.com.BrayanFJ.ApiControleDeContatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
