package br.com.usina.api_pi.controller;

import br.com.usina.api_pi.model.Turnos;
import br.com.usina.api_pi.repository.TurnosRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnosController {

    private final TurnosRepository repository;

    public TurnosController(TurnosRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Turnos> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Turnos> criar(@RequestBody Turnos turno) {
        Turnos salvo = repository.save(turno);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turnos> atualizar(
            @PathVariable Long id,
            @RequestBody Turnos turno) {

        return repository.findById(id)
                .map(existente -> {
                    existente.setNome(turno.getNome());

                    Turnos atualizado = repository.save(existente);
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
    public ResponseEntity<Turnos> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
