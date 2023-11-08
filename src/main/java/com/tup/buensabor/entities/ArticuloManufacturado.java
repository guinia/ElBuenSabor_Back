package com.tup.buensabor.entities;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ARTICULOMANUFACTURADO")
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


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "id_articulomanufacturado")
    @Builder.Default
    private List<DetalleArticuloManufacturado> detalles = new ArrayList<>();

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_receta")
    private Receta receta;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_rubro_articulo_manufacturado")
    private RubroArticuloManufacturado rubroArticuloManufacturado;

    //public void agregarDetalle(List<DetalleArticuloManufacturado> detalleArticuloManufacturado){
        //detalles.addAll(detalleArticuloManufacturado);
    //}
    public void agregarDetalle(DetalleArticuloManufacturado detalleArticuloManufacturado){
        detalles.add(detalleArticuloManufacturado);
    }

}
