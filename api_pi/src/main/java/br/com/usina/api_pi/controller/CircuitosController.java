package br.com.usina.api_pi.controller;

import br.com.usina.api_pi.model.Circuitos;
import br.com.usina.api_pi.repository.CircuitosRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/circuitos")
public class CircuitosController {

    private final CircuitosRepository repository;

    public CircuitosController(CircuitosRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Circuitos> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Circuitos> criar(@RequestBody Circuitos circuito) {
        Circuitos salvo = repository.save(circuito);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Circuitos> atualizar(
            @PathVariable Long id,
            @RequestBody Circuitos circuito) {

        return repository.findById(id)
                .map(existente -> {
                    existente.setNome(circuito.getNome());

                    Circuitos atualizado = repository.save(existente);

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
    public ResponseEntity<Circuitos> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
