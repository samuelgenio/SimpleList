package br.com.samuka.simplelist.simples;

public class Elemento {
    
    private int valor;
    
    private Elemento proximo;

    public Elemento(int valor) {
       this.valor = valor; 
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Elemento getProximo() {
        return proximo;
    }

    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }
 
}
