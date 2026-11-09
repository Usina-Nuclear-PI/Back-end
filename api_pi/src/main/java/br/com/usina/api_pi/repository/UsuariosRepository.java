package br.com.usina.api_pi.repository;

import br.com.usina.api_pi.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    Optional<Usuarios> findFirstByEmailIgnoreCaseAndSenha(String email, String senha);
}