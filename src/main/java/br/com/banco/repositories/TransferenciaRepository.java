package br.com.banco.repositories;

import br.com.banco.entities.Transferencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {

    @Query(value = "SELECT * FROM transferencia WHERE nome_operador_transacao = ?1", nativeQuery = true)
    Page<Transferencia> buscarPorFiltros(String nomeOperadorTransacao, PageRequest pageRequest);

    @Query(value = "SELECT * FROM transferencia WHERE data_transferencia >= ?1 AND data_transferencia <= ?2", nativeQuery = true)
    List<Transferencia> buscarPorData(LocalDateTime dataInicio, LocalDateTime dataFim);
}
