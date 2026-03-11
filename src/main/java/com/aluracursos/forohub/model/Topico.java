package com.aluracursos.forohub.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @Column(unique = true)
    private String mensaje;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private String status = "ACTIVO";
    private String autor;
    private String curso;

    public Topico() {}

    public Topico(String titulo, String mensaje, String autor, String curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.curso = curso;
    }

    // Getters y Setters rápidos (o usa records en el DTO)
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public String getStatus() { return status; }
    public String getAutor() { return autor; }
    public String getCurso() { return curso; }
}