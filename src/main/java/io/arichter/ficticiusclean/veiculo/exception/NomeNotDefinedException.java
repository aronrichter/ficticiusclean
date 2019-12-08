package io.arichter.ficticiusclean.veiculo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeNotDefinedException extends RuntimeException {

    public NomeNotDefinedException() {
        super("É obrigatório informar o nome do veículo");
    }
}
