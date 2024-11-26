package projeto.model;

import java.io.Serializable;

public class Excecao extends Exception implements Serializable {
    public Excecao(String message) {
        super(message);
    }
}
