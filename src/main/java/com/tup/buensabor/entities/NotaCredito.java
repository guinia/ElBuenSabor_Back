package com.tup.buensabor.entities;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "nota_credito")
public class NotaCredito extends Base{
    @NotNull
    @Column(name = "total_monto", precision = 10, scale = 2)
    private BigDecimal monto;

    @OneToOne
    private Factura factura;

    @ManyToOne
    private Persona persona;

}
