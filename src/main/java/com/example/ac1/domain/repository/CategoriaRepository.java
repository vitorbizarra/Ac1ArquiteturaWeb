package com.example.ac1.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ac1.domain.model.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Categoria inserir(Categoria categoria) {
        entityManager.merge(categoria);
        return categoria;
    }

    @Transactional
    public Categoria editar(Categoria categoria) {
        entityManager.merge(categoria);
        return categoria;
    }

    @Transactional
    public void excluir(Categoria categoria) {
        entityManager.remove(categoria);
    }

    public List<Categoria> selecionarTodos() {
        return entityManager
                .createQuery("from tbl_categorias", Categoria.class)
                .getResultList();
    }

    public Categoria selecionarPorId(int id) {
        String jpql = "select * from tbl_categorias as p where p.id = :id";

        TypedQuery<Categoria> query = entityManager.createQuery(jpql, Categoria.class);

        query.setParameter("id", id);

        return query.getResultList().getFirst();
    }
}
