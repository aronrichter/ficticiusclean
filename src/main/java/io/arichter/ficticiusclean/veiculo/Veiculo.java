package io.arichter.ficticiusclean.veiculo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String marca;
    private String modelo;
    private LocalDate dataFabricacao;
    private BigDecimal consumoMedioCidade;
    private BigDecimal consumoMedioRodovia;
}
