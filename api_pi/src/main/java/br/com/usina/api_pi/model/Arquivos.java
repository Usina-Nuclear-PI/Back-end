package br.com.usina.api_pi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "arquivo_importacao") // sua classe se chama Arquivos, mas a tabela SQL se chama arquivo_importacao. Essa anotação garante o mapeamento correto
public class Arquivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long id_usuario;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(length = 255)
    private String descricao;

    @Lob // indica que o atributo armazena um objeto binário grande, compatível com o uso de BLOB
    @Column(nullable = false) // representa as restrições NOT NULL do banco para os campos id_usuario, nome e arquivo
    private byte[] arquivo;

    public void setId(Long id) {
        this.id = id;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public Arquivos() {}

    public Arquivos(Long id, Long id_usuario, String nome, String descricao, byte[] arquivo) {
        setId(id);
        setId_usuario(id_usuario);
        setNome(nome);
        setDescricao(descricao);
        setArquivo(arquivo);
    }

    public Long getId() {
        return id;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public byte[] getArquivo() {
        return arquivo;
    }
}
