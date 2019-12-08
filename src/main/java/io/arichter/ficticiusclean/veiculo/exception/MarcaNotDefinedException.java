package io.arichter.ficticiusclean.veiculo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MarcaNotDefinedException extends  RuntimeException {

    public MarcaNotDefinedException() {
        super("É obrigatório informar a marca do veículo");
    }
}
