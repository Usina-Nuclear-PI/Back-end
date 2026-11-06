package br.com.usina.api_pi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "turnos")
public class Turnos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Turnos() {}

    public Turnos(Long id, String nome) {
        setId(id);
        setNome(nome);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
