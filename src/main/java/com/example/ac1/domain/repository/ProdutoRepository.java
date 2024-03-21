package com.example.ac1.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.domain.model.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto inserir(Produto produto) {
        entityManager.merge(produto);
        return produto;
    }

    @Transactional
    public Produto editar(Produto produto) {
        entityManager.merge(produto);
        return produto;
    }

    @Transactional
    public void excluir(Produto produto) {
        entityManager.remove(produto);
    }

    public List<Produto> selecionarTodos() {
        return entityManager
                .createQuery("from tbl_produtos", Produto.class)
                .getResultList();
    }

    public Produto selecionarPorId(int id) {
        String jpql = "select * from tbl_produtos as p where p.id = :id";

        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);

        query.setParameter("id", id);

        return query.getResultList().getFirst();
    }
}
