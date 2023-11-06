package com.tup.buensabor.entities;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ArticuloManufacturado extends Base {

    @NotNull
    @Column(name = "denominacion")
    private String denominacion;

    @NotNull
    @Column(name = "descripcion",length = 1000)
    private String descripcion;

    @NotNull
    @Column(name = "tiempo_estimado_cocina")
    private Integer tiempoEstimadoCocina;

    @NotNull
    @Column(name = "precio_venta", precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(length = 500, name = "url_imagen")
    private String urlImagen;

    @Column(length = 1000, name = "receta")
    private String receta;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "id_articulomanufacturado")
    @Builder.Default
    private List<DetalleArticuloManufacturado> detalles = new ArrayList<>();

    //public void agregarDetalle(List<DetalleArticuloManufacturado> detalleArticuloManufacturado){
        //detalles.addAll(detalleArticuloManufacturado);
    //}
    public void agregarDetalle(DetalleArticuloManufacturado detalleArticuloManufacturado){
        detalles.add(detalleArticuloManufacturado);
    }

}
