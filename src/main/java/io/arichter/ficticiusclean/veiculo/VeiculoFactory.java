package io.arichter.ficticiusclean.veiculo;

import io.arichter.ficticiusclean.veiculo.payload.VeiculoResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class VeiculoFactory {

    public VeiculoResponse create(Veiculo veiculo, BigDecimal litrosCombustivel, BigDecimal valorCombustivel) {
        VeiculoResponse veiculoResponse = new VeiculoResponse();

        veiculoResponse.setNome(veiculo.getNome());
        veiculoResponse.setMarca(veiculo.getMarca());
        veiculoResponse.setModelo(veiculo.getModelo());
        veiculoResponse.setAno(veiculo.getDataFabricacao().getYear());
        veiculoResponse.setLitrosCombustivel(litrosCombustivel);
        veiculoResponse.setValorCombustivel(valorCombustivel);

        return veiculoResponse;
    }
}
