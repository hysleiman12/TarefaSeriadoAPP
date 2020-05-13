package edu.com.faculdadedelta.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Seriado implements Serializable {

    private Long id;
    private String genero;
    private String status;
    private String nome;
    private String comentario;
    private String nota;
    private String dataLan;

    public Seriado() {
    }

    public Seriado(Long id, String genero, String status, String nome, String comentario, String nota, String dataLan) {
        this.id = id;
        this.genero = genero;
        this.status = status;
        this.nome = nome;
        this.comentario = comentario;
        this.nota = nota;
        this.dataLan = dataLan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getDataLan() {
        return dataLan;
    }

    public void setDataLan(String dataLan) {
        this.dataLan = dataLan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seriado seriado = (Seriado) o;
        return Objects.equals(id, seriado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
