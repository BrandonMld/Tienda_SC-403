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

/**
 *
 * @author brand
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("mensaje", "Hola desde el controlador");

        return "index";
    }


}
