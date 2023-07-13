package br.com.banco.repositories;

import br.com.banco.entities.Transferencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {

    @Query(value = "SELECT * FROM transferencia WHERE nome_operador_transacao = ?1", nativeQuery = true)
    Page<Transferencia> buscarPorFiltros(String nomeOperadorTransacao, PageRequest pageRequest);
}
