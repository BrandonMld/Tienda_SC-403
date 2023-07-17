package com.tienda.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id catecoria")
    private Long idCategoria; // Se transforma en id categoria private String descripcion;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    @OneToMany
    @JoinColumn(name="id_categoria")
    private List<Producto> productos;

    public Categoria() {
    }

    public Categoria(String descripcion, String rutaImagen, boolean activo) {
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }

   
}
