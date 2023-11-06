package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.model.Proprietario;
import br.com.fiap.service.ProprietarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    private final ProprietarioService proprietarioService;

    @Autowired
    public ProprietarioController(ProprietarioService proprietarioService) {
        this.proprietarioService = proprietarioService;
    }

    @GetMapping
    public List<Proprietario> getAllProprietarios() {
        return proprietarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proprietario> getProprietarioById(@PathVariable Long id) {
        Optional<Proprietario> proprietario = proprietarioService.findById(id);
        return proprietario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Proprietario> createProprietario(@RequestBody Proprietario proprietario) {
        Proprietario savedProprietario = proprietarioService.save(proprietario);
        return new ResponseEntity<>(savedProprietario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proprietario> updateProprietario(@PathVariable Long id, @RequestBody Proprietario proprietario) {
        Optional<Proprietario> existingProprietario = proprietarioService.findById(id);
        if (existingProprietario.isPresent()) {
            Proprietario updatedProprietario = proprietarioService.updateProprietario(id, proprietario);
            return new ResponseEntity<>(updatedProprietario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProprietario(@PathVariable Long id) {
        proprietarioService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
