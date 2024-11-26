package projeto.model.classes.utilizador;

import projeto.model.Excecao;
import projeto.model.classes.Ato;
import projeto.model.classes.receitas.Receita;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Utilizador implements Serializable {
    private String id;
    private String nome;
    private String apelido;
    private String cc;
    private String genero;
    private String contacto;
    private LocalDateTime dataCriacao;
    private Map<String, Ato> atos;
    private Map<String, Receita> receitas;


    public Utilizador(String nome, String apelido, String cc) throws Excecao {
        if (nome.isBlank()){
            throw new Excecao("Nome vazio.");
        }
        if (apelido.isBlank()){
            throw new Excecao("Apelido vazio.");
        }
        if (!cc.matches("\\d{9}")){
            throw new Excecao("CC inválido.");
        }
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.apelido = apelido;
        this.cc = cc;
        this.dataCriacao = LocalDateTime.now();
        this.atos = new HashMap<>();
        this.receitas = new HashMap<>();
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getApelido() {return apelido;}
    public void setApelido(String apelido) {this.apelido = apelido;}

    public String getGenero() {return genero;}
    public void setGenero(String genero) throws Excecao {
        if (!genero.matches("(?i)F|M|outro")) {
            throw new Excecao("Erro: Género inválido! Use F, M ou outro.");
        }
        else {
            this.genero = genero.trim().toUpperCase();
        }
    }


    public String getCc() {return cc;}
    public void setCc(String cc) {
        if (!cc.matches("\\d{9}")) { // Exemplo de validação
            throw new IllegalArgumentException("Número de CC inválido.");
        }
        this.cc = cc;
    }

    public String getContacto() {return contacto;}
    public void setContacto(String contacto) {this.contacto = contacto;}

    public LocalDateTime getDataCriacao() {return dataCriacao;}

    public Map<String, Ato> getAtos() {return atos;}
    public void setAtos(Map<String, Ato> atos) {this.atos = atos;}
    public void adicionaAto(Ato ato) {this.atos.put(ato.getId(), ato);}
    public void removeAto(String id) {this.atos.remove(id);}

    public Map<String, Receita> getReceitas() {return receitas;}
    public void setReceitas(Map<String, Receita> receitas) {this.receitas = receitas;}
    public void adicionaReceita(Receita receita) {this.receitas.put(receita.getId(), receita);}
    public void removeReceita(String id) {this.receitas.remove(id);}

    @Override
    public String toString() {
        return
                "ID: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Apelido: " + apelido + "\n" +
                "CC: " + cc + "\n" +
                "Genero: " + genero + "\n" +
                "Contacto: " + contacto + "\n" +
                "Data de Registo " + dataCriacao;
    }
}
