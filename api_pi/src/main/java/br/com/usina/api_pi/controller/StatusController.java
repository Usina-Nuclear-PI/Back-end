package br.com.usina.api_pi.controller;

import br.com.usina.api_pi.model.Status;
import br.com.usina.api_pi.repository.StatusRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final StatusRepository repository;

    public StatusController(StatusRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Status> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Status> criar(@RequestBody Status status) {
        Status salvo = repository.save(status);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> atualizar(
            @PathVariable Long id,
            @RequestBody Status status) {

        return repository.findById(id)
                .map(existente -> {
                    existente.setDescricao(status.getDescricao());

                    Status atualizado = repository.save(existente);
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
    public ResponseEntity<Status> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
