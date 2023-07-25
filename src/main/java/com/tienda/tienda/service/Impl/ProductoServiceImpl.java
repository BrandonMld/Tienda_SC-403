/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda.service.Impl;

import com.tienda.tienda.domain.Producto;
import com.tienda.tienda.dao.ProductoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tienda.tienda.service.ProductoService;


@Service
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired 
    private ProductoDao cateogoriaDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProducto(boolean activos){
    List<Productos> lista = productoDao.findAll();
    
    if(activos){
    
    lista.removeIf(x -> !x.IsActivo());
    }
    return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return ctaegoria.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);

    }
    // Lista de productos con precio entre ordendados por descripción ConsultaAmpliada
@Override
@Transactional(readOnly=true)
public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {
  return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
}
 @Override
    @Transactional(readOnly=true)    
    public List<Producto> metodoJPQL(double precioInf, double precioSup) {
        return productoDao.metodoJPQL(precioInf, precioSup);
    }

     @Override
    @Transactional(readOnly=true)    
    public List<Producto> metodoNativo(double precioInf, double precioSup) {
        return productoDao.metodoNativo(precioInf, precioSup);
    }


    
    
}
