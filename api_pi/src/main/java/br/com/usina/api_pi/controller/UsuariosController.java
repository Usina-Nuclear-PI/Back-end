package br.com.usina.api_pi.controller;

import br.com.usina.api_pi.model.Usuarios;
import br.com.usina.api_pi.repository.UsuariosRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private final UsuariosRepository repository;

    public UsuariosController(UsuariosRepository repository) {
        this.repository = repository;
    }

    // Login: o front chama POST /usuarios/login com { email, senha }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> body) {
        String email = body.get("email") == null ? "" : body.get("email").trim();
        String senha = body.get("senha") == null ? "" : body.get("senha");

        return repository.findFirstByEmailIgnoreCaseAndSenha(email, senha)
                .map(u -> {
                    // Nunca devolve a senha para o front
                    Map<String, Object> usuario = new LinkedHashMap<>();
                    usuario.put("id", u.getId());
                    usuario.put("nome", u.getNome());
                    usuario.put("email", u.getEmail());

                    Map<String, Object> resposta = new LinkedHashMap<>();
                    resposta.put("success", true);
                    resposta.put("usuario", usuario);
                    return ResponseEntity.ok(resposta);
                })
                .orElseGet(() -> {
                    Map<String, Object> resposta = new LinkedHashMap<>();
                    resposta.put("success", false);
                    resposta.put("message", "Email ou senha inválidos");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resposta);
                });
    }

    @GetMapping
    public List<Usuarios> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuarios> criar(@RequestBody Usuarios usuario) {
        Usuarios salvo = repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> atualizar(
            @PathVariable Long id,
            @RequestBody Usuarios usuario) {

        return repository.findById(id)
                .map(existente -> {
                    existente.setNome(usuario.getNome());
                    existente.setEmail(usuario.getEmail());
                    existente.setSenha(usuario.getSenha());

                    Usuarios atualizado = repository.save(existente);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}