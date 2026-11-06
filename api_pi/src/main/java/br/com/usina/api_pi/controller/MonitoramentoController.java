package br.com.usina.api_pi.controller;

import br.com.usina.api_pi.model.Monitoramento;
import br.com.usina.api_pi.repository.MonitoramentoRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitoramento")
public class MonitoramentoController {

    private final MonitoramentoRepository repository;

    public MonitoramentoController(MonitoramentoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Monitoramento> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Monitoramento> criar(
            @RequestBody Monitoramento monitoramento) {

        Monitoramento salvo = repository.save(monitoramento);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monitoramento> atualizar(
            @PathVariable Long id,
            @RequestBody Monitoramento monitoramento) {

        return repository.findById(id)
                .map(existente -> {
                    existente.setDataHora(monitoramento.getDataHora());
                    existente.setIdCircuito(monitoramento.getIdCircuito());
                    existente.setIdTurno(monitoramento.getIdTurno());
                    existente.setIdStatus(monitoramento.getIdStatus());
                    existente.setTemperaturaC(monitoramento.getTemperaturaC());
                    existente.setPressaoBar(monitoramento.getPressaoBar());
                    existente.setVazaoM3H(monitoramento.getVazaoM3H());
                    existente.setPotenciaMw(monitoramento.getPotenciaMw());
                    existente.setRadiacaoMsvH(monitoramento.getRadiacaoMsvH());
                    existente.setVibracaoMmS(monitoramento.getVibracaoMmS());
                    existente.setNivelRefrigerantePct(
                            monitoramento.getNivelRefrigerantePct());
                    existente.setEficienciaTermicaPct(
                            monitoramento.getEficienciaTermicaPct());
                    existente.setIdArquivo(monitoramento.getIdArquivo());
                    existente.setIdUsuario(monitoramento.getIdUsuario());

                    Monitoramento atualizado = repository.save(existente);

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
    public ResponseEntity<Monitoramento> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
