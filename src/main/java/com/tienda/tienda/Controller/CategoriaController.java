/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda.Controller;

import com.tienda.tienda.domain.Categoria;
import com.tienda.tienda.service.lmpl.FirebaseStroreageServicelmpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tienda.tienda.service.ProductoService;


@Controller
@Slf4j
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    ProductoService categoriaService;

    @Autowired
    private FirebaseStroreageServicelmpl firebaseStorageService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        log.info("Consumiendo el recurso /categoria/listado");
        List<Categoria> categorias = categoriaService.getPorDescripcion("Item");
        model.addAtribute("categorias", categorias);
        model.addAtribute("totalCategorias", categorias.size());
        return "/categoria/modifica";
    }

    @GetMapping("/nuevo")
    public String categorianuevo(Categoria categoria) {
        return "/categoria/modifica";
    }

    @PostMapping("/guardar")
    public String categoriNuevo(Categoria categoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            categoriaService.save(categoria);
            ProductoService.save(categoria);
            categoria.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenfile,
                            "categoria"
            categoria.getIdCategoria()));
        }
        ctaegoriaService.save(categoria);
        return "redirect:/categoria/listado"
    }

    @GetMapping("eliminar/(idCategoria)")
    public String categoriaEliminar(Categoria categoria) {
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado"
    }
    
     @GetMapping("modifica/(idCategoria)")
    public String categoriaModifica(Categoria categoria, Model model) {
        Categoria = categoriaService.delete(categoria);
        model.addAtribute("categorias", categorias);
        return "/categoria/modifica"
    }

}
