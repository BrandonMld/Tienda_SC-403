/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda.service.Impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author brand
 */
@Service
public class FirebaseStroreageServicelmpl {

    
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id) {
        try {
            String extension = archivoLocalCliente.getOriginalFilename();
            String fileName = "img" + sacaNumero(id) + extension;
            File file = this.convertToFile(archivoLocalCliente);
            file.delete();

           
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    private File convertToFile(MultipartFile archivoLocalCliente) throws IOException {
        File tempFile = File.createTempFile("img", null);
        try ( FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(archivoLocalCliente.getBytes());
            fos.close();
        }
        return tempFile;
    }

    private String sacaNumero(long id) {
        return String.format("%019d", id);
    }
}
    
