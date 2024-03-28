package com.example.ac1.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ac1.domain.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    /**
     * Um método de consulta que retorne todos as categorias que começam com um
     * determinado nome.
     * Este método deve receber um parâmetro do tipo String chamado nome e retornar
     * uma lista de
     * categorias em que o nome começa com o nome informado.
     */
    public List<Categoria> findByNameStartingWith(String prefix);

    /**
     * Um método que retorna uma determinada categoria pelo ID e todos os produtos
     * relacionados
     * a essa categoria, para isso utilizar o método LEFT JOIN FETCH.
     */
    @Query("select c from Categoria c left join fetch c.produtos p where c.id = :id ")
    public Categoria findCategoriaFetchProdutos(@Param("id") Long id);
}
