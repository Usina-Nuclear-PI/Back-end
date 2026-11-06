package br.com.usina.api_pi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "circuitos")
public class Circuitos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Circuitos() {}

    public Circuitos(Long id, String nome) {
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
