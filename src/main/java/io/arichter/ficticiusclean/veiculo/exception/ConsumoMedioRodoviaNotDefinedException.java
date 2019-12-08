package io.arichter.ficticiusclean.veiculo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ConsumoMedioRodoviaNotDefinedException extends RuntimeException {

    public ConsumoMedioRodoviaNotDefinedException() {
        super("É obrigatório informar o consumo médio do veículo na Rodovia");
    }
}
