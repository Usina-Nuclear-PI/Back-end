package br.com.usina.api_pi.repository;

import br.com.usina.api_pi.model.Monitoramento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoramentoRepository
        extends JpaRepository<Monitoramento, Long> {
}
