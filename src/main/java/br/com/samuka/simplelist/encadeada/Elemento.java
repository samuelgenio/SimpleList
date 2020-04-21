package br.com.samuka.simplelist.encadeada;

public class Elemento {
    
    private String nome;
    
    private int duracao;
    
    private Elemento proximo;
    
    private Elemento anterior;

    public Elemento(String nome, int duracao) {
       this.nome = nome;
       this.duracao = duracao; 
    }

    public int getdDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Elemento getProximo() {
        return proximo;
    }

    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Elemento getAnterior() {
        return anterior;
    }

    public void setAnterior(Elemento anterior) {
        this.anterior = anterior;
    }
}
