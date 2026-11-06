package br.com.usina.api_pi.repository;

import br.com.usina.api_pi.model.Turnos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnosRepository extends JpaRepository<Turnos, Long> {
}
