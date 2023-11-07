package com.tup.buensabor.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "receta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Receta extends Base {

    @NotNull
    @Column(name = "receta")
    private String descripcion;
}