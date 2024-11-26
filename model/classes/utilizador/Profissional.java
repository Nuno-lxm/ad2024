package projeto.model.classes.utilizador;

import projeto.model.Excecao;

import java.io.Serializable;

public class Profissional extends Utilizador implements Serializable {
    private String profissao;

    public Profissional(String nome, String apelido, String cc) throws Excecao {
        super(nome, apelido, cc);
    }

    public String getProfissao() {return profissao;}
    public void setProfissao(String profissao) throws Excecao{
        if (!profissao.matches("(?i)^Médico$|^Enfermeiro$|^Farmacêutico$")) {
            throw new Excecao("Erro: Profissão inválida!");
        }
        else {
            this.profissao = profissao.trim();
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "Profissão: " + profissao + "\n";
    }
}