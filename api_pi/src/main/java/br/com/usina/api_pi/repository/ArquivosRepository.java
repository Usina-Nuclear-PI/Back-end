package br.com.usina.api_pi.repository;

import br.com.usina.api_pi.model.Arquivos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArquivosRepository
        extends JpaRepository<Arquivos, Long> {
}
