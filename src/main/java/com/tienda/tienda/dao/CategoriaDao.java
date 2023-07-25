package com.tienda.tienda.dao;

import com.tienda.tienda.domain.Categoria;
import org.springframework.data.jpa. repository. JpaRepository;
import java.util.List;

public interface CategoriaDao extends JpaRepository <Categoria, Long> {
    
    List<Categoria> findByDescripcion(String descripcion);
    
}
