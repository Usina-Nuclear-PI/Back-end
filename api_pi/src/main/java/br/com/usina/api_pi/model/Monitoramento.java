
package br.com.usina.api_pi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "monitoramento")
public class Monitoramento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Long id;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "id_circuito", nullable = false)
    private Long idCircuito;

    @Column(name = "id_turno", nullable = false)
    private Long idTurno;

    @Column(name = "id_status", nullable = false)
    private Long idStatus;

    @Column(name = "temperatura_c", precision = 10, scale = 2)
    private BigDecimal temperaturaC;

    @Column(name = "pressao_bar", precision = 10, scale = 2)
    private BigDecimal pressaoBar;

    @Column(name = "vazao_m3_h", precision = 10, scale = 2)
    private BigDecimal vazaoM3H;

    @Column(name = "potencia_mw", precision = 10, scale = 2)
    private BigDecimal potenciaMw;

    @Column(name = "radiacao_msv_h", precision = 10, scale = 4)
    private BigDecimal radiacaoMsvH;

    @Column(name = "vibracao_mm_s", precision = 10, scale = 2)
    private BigDecimal vibracaoMmS;

    @Column(name = "nivel_refrigerante_pct", precision = 5, scale = 2)
    private BigDecimal nivelRefrigerantePct;

    @Column(name = "eficiencia_termica_pct", precision = 5, scale = 2)
    private BigDecimal eficienciaTermicaPct;

    @Column(name = "id_arquivo", nullable = false)
    private Long idArquivo;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setIdCircuito(Long idCircuito) {
        this.idCircuito = idCircuito;
    }

    public void setIdTurno(Long idTurno) {
        this.idTurno = idTurno;
    }

    public void setIdStatus(Long idStatus) {
        this.idStatus = idStatus;
    }

    public void setTemperaturaC(BigDecimal temperaturaC) {
        this.temperaturaC = temperaturaC;
    }

    public void setPressaoBar(BigDecimal pressaoBar) {
        this.pressaoBar = pressaoBar;
    }

    public void setVazaoM3H(BigDecimal vazaoM3H) {
        this.vazaoM3H = vazaoM3H;
    }

    public void setPotenciaMw(BigDecimal potenciaMw) {
        this.potenciaMw = potenciaMw;
    }

    public void setRadiacaoMsvH(BigDecimal radiacaoMsvH) {
        this.radiacaoMsvH = radiacaoMsvH;
    }

    public void setVibracaoMmS(BigDecimal vibracaoMmS) {
        this.vibracaoMmS = vibracaoMmS;
    }

    public void setNivelRefrigerantePct(BigDecimal nivelRefrigerantePct) {
        this.nivelRefrigerantePct = nivelRefrigerantePct;
    }

    public void setEficienciaTermicaPct(BigDecimal eficienciaTermicaPct) {
        this.eficienciaTermicaPct = eficienciaTermicaPct;
    }

    public void setIdArquivo(Long idArquivo) {
        this.idArquivo = idArquivo;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Monitoramento() {
    }

    public Monitoramento(Long id, LocalDateTime dataHora, Long idCircuito, Long idTurno, Long idStatus, BigDecimal temperaturaC, BigDecimal pressaoBar, BigDecimal vazaoM3H, BigDecimal potenciaMw, BigDecimal radiacaoMsvH, BigDecimal vibracaoMmS, BigDecimal nivelRefrigerantePct, BigDecimal eficienciaTermicaPct, Long idArquivo, Long idUsuario) {
        setId(id);
        setDataHora(dataHora);
        setIdCircuito(idCircuito);
        setIdTurno(idTurno);
        setIdStatus(idStatus);
        setTemperaturaC(temperaturaC);
        setPressaoBar(pressaoBar);
        setVazaoM3H(vazaoM3H);
        setPotenciaMw(potenciaMw);
        setRadiacaoMsvH(radiacaoMsvH);
        setVibracaoMmS(vibracaoMmS);
        setNivelRefrigerantePct(nivelRefrigerantePct);
        setEficienciaTermicaPct(eficienciaTermicaPct);
        setIdArquivo(idArquivo);
        setIdUsuario(idUsuario);
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Long getIdCircuito() {
        return idCircuito;
    }

    public Long getIdTurno() {
        return idTurno;
    }

    public Long getIdStatus() {
        return idStatus;
    }

    public BigDecimal getTemperaturaC() {
        return temperaturaC;
    }

    public BigDecimal getPressaoBar() {
        return pressaoBar;
    }

    public BigDecimal getVazaoM3H() {
        return vazaoM3H;
    }

    public BigDecimal getPotenciaMw() {
        return potenciaMw;
    }

    public BigDecimal getRadiacaoMsvH() {
        return radiacaoMsvH;
    }

    public BigDecimal getVibracaoMmS() {
        return vibracaoMmS;
    }

    public BigDecimal getNivelRefrigerantePct() {
        return nivelRefrigerantePct;
    }

    public BigDecimal getEficienciaTermicaPct() {
        return eficienciaTermicaPct;
    }

    public Long getIdArquivo() {
        return idArquivo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }
}
