/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda.Controller;

import com.tienda.tienda.domain.Categoria;
import com.tienda.tienda.domain.Producto;
import com.tienda.tienda.service.CategoriaService;
import com.tienda.tienda.service.Impl.FirebaseStroreageServicelmpl;
import com.tienda.tienda.service.lmpl.FirebaseStroreageServicelmpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tienda.tienda.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller
@Slf4j
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;
    
    @Autowired
    CategoriaService categoriaService;

    @Autowired
    private FirebaseStroreageServicelmpl firebaseStorageService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        log.info("Consumiendo el recurso /producto/listado");
        List<Producto> productos = productoService.getProductos(false);
        List<Categoria> categorias = categoriaService.getCategorias(true);
        model.addAttribute("productos", productos);
        model.addAttribute("Categorias", categorias);
        model.addAttribute("totalProductos", productos.size());
        return "/producto/modifica";
    }

    @GetMapping("/nuevo")
    public String productonuevo(Producto producto) {
        return "/producto/modifica";
    }

    @PostMapping("/guardar")
    public String categoriNuevo(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            ProductoService.save(producto);
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenfile,
                            "producto"
            producto.getIdProducto()));
        }
        productoService.save(producto);
        return "redirect:/producto/listado"
    }

    @GetMapping("eliminar/(idProducto)")
    public String productoEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado"
    }
    
     @GetMapping("modifica/(idProducto)")
    public String productoModifica(Producto producto, Model model) {
        Producto = productoService.delete(producto);
        List<Categoria> categorias = categoriaService.getCategorias(true);
        model.addAttribute("productos", producto);
        model.addAttribute("categorias", categorias);
        return "/producto/modifica"
    }

}
