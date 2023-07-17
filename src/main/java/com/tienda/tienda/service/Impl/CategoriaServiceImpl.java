/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda.service.Impl;

import com.tienda.tienda.domain.Categoria;
import com.tienda.tienda.dao.CategoriaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tienda.tienda.service.ProductoService;


@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired 
    private CategoriaDao cateogoriaDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategoria(boolean activos){
    List<Categorias> lista = categoriaDao.findAll();
    
    if(activos){
    
    lista.removeIf(x -> !x.IsActivo());
    }
    return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return ctaegoria.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);

    }
    
    
    
}
