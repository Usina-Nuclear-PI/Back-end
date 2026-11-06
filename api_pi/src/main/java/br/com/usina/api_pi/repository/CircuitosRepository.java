package br.com.usina.api_pi.repository;

import br.com.usina.api_pi.model.Circuitos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CircuitosRepository
        extends JpaRepository<Circuitos, Long> {
}
