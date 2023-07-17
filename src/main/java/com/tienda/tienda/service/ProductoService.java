/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.tienda.service;

import com.tienda.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
    
public List<Producto> getProductos (boolean activos);
// Se obtiene un Producto, a partir del id de un cate
public Producto getProducto (Producto categoria);
// Se inserta un nuevo categoria si el id del categori
// Se actualiza un categoria si el id del categoria NO
public void save (Producto categoria);
// Se elimina el categoria que tiene el id pasado por
public void delete (Producto producto);
    
}
