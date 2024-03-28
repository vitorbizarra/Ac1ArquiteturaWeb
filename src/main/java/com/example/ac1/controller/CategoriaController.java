package com.example.ac1.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac1.domain.model.Categoria;
import com.example.ac1.domain.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping("/")
    public Categoria inserir(@RequestBody Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    @GetMapping("/")
    public List<Categoria> mostrarTodos() {
        return this.categoriaRepository.findAll();
    }
}
