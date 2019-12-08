package io.arichter.ficticiusclean.veiculo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class ConsumoMedioCidadeNotDefinedException extends RuntimeException {

    public ConsumoMedioCidadeNotDefinedException() {
        super("É obrigatório informar o consumo médio do veículo na cidade");
    }
}
