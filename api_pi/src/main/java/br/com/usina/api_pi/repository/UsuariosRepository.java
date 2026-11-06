package br.com.usina.api_pi.repository;

import br.com.usina.api_pi.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

}