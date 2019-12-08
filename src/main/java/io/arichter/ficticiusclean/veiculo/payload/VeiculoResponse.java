package io.arichter.ficticiusclean.veiculo.payload;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class VeiculoResponse {

    private String nome;
    private String marca;
    private String modelo;
    private Integer ano;
    private BigDecimal litrosCombustivel;
    private BigDecimal valorCombustivel;
}
