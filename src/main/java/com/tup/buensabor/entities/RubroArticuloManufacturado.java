package com.tup.buensabor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Table(name = "rubro_articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RubroArticuloManufacturado extends Base{

    @ManyToOne()
    @JoinColumn(name = "id_rubro_padre")
    private RubroArticuloManufacturado rubroPadre;

    //@OneToMany(mappedBy = "rubroPadre", cascade = CascadeType.ALL)
    //private List<RubroArticulo> subRubros = new ArrayList<>();

    @NotNull
    private String denominacion;
}
