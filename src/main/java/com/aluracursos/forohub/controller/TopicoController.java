package com.aluracursos.forohub.controller;
import com.aluracursos.forohub.dto.DatosActualizarTopico;
import com.aluracursos.forohub.dto.DatosRegistroTopico;
import com.aluracursos.forohub.model.Topico;
import com.aluracursos.forohub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    // CREATE
    @PostMapping
    @Transactional
    public ResponseEntity<Topico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        Topico topico = new Topico(datos.titulo(), datos.mensaje(), datos.autor(), datos.curso());
        topicoRepository.save(topico);
        return ResponseEntity.ok(topico);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Topico>> listadoTopicos() {
        return ResponseEntity.ok(topicoRepository.findAll());
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Topico> retornaTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        return topico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping
    @Transactional
    public ResponseEntity<Topico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datos) {
        Optional<Topico> topicoOpcional = topicoRepository.findById(datos.id());
        if (topicoOpcional.isPresent()) {
            Topico topico = topicoOpcional.get();
            if (datos.titulo() != null) topico.setTitulo(datos.titulo());
            if (datos.mensaje() != null) topico.setMensaje(datos.mensaje());
            return ResponseEntity.ok(topico);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}