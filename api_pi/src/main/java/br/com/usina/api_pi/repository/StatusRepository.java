package br.com.usina.api_pi.repository;

import br.com.usina.api_pi.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
