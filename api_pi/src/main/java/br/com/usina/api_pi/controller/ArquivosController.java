package br.com.usina.api_pi.controller;

import br.com.usina.api_pi.model.Arquivos;
import br.com.usina.api_pi.repository.ArquivosRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arquivos")
public class ArquivosController {

    private final ArquivosRepository repository;

    public ArquivosController(ArquivosRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Arquivos> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Arquivos> criar(@RequestBody Arquivos arquivo) {
        Arquivos salvo = repository.save(arquivo);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Arquivos> atualizar(
            @PathVariable Long id,
            @RequestBody Arquivos arquivo) {

        return repository.findById(id)
                .map(existente -> {
                    existente.setId_usuario(arquivo.getId_usuario());
                    existente.setNome(arquivo.getNome());
                    existente.setDescricao(arquivo.getDescricao());
                    existente.setArquivo(arquivo.getArquivo());

                    Arquivos atualizado = repository.save(existente);

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
    public ResponseEntity<Arquivos> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
