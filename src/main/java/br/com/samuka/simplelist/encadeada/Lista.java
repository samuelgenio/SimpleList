package br.com.samuka.simplelist.encadeada;

public class Lista {
    
    /**
     * Armazena o primeiro elemento da lista.
     */
    private Elemento first;
    
    /**
     * Armazena o último elemento da lista.
     */
    private Elemento last;
    
    /**
     * Armazena o element trabalhado no momento.
     */
    private Elemento atual;
    
    /**
     * Verifique se a lista está vazia
     * @return True para possítivo.
     */
    public boolean isEmpty(){
        return first == null;
    }
    
    /**
     * Adiciona o elemento na ultima posição.
     * @param nome
     * @param duracao
     */
    public void add(String nome, int duracao){
        
        Elemento elemento = new Elemento(nome, duracao);
        
        if(!isEmpty()){
            elemento.setAnterior(last);
            last.setProximo(elemento);
            last = elemento;
        }else{
            addFirst(nome, duracao);
        }
        
        
    }
    
    /**
     * Adiciona o elemento na primeira posição.
     * @param nome
     * @param duracao
     */
    public void addFirst(String nome, int duracao){
        
        Elemento elemento = new Elemento(nome, duracao);
        
        if(!isEmpty()){//já possui o first elemento.
            elemento.setProximo(first);
            first.setAnterior(elemento);
            first = elemento;
        }else{//está vazio
            first = last = elemento;
        }
        
        first = elemento;
        
    }
    
    /**
     * Adiciona o valor na posição passada.
     * @param index Posição a ser inserido
     * @param nome
     * @param duracao
     */
    public void add(int index, String nome, int duracao){
        
        Elemento elemento = new Elemento(nome, duracao);
        
        if(!isEmpty()){
            
            Elemento elementoProximo = atPos(index);
            
            if(elementoProximo != null){
             
                elemento.setAnterior(elementoProximo.getAnterior());
                elemento.setProximo(elementoProximo);
                
                if(elementoProximo == first)
                    first = elemento;
                
            }else{//não possui a posição solicitada
                this.add(nome, duracao);
            }
            
        }else{//Se for vazio então só insere na ultima posição
            this.add(nome, duracao);
        }
        
    }
    
    /**
     * Retorna o elemento da posição passada por parâmetro
     * @param index posição a ser encontrada
     * @return elemento da posição informada.
     */
    public Elemento atPos(int index){
        
        int pos = 0;
        Elemento elemento = first;
        while(elemento.getProximo() != null){
            
            pos++;
            
            elemento = elemento.getProximo();
            
            if(pos == index)
                break;
            
        }
        
        return elemento;
    }
    
    public int length() {
        
        int comp = 0;
        atual = first;
        
        while(atual != null) {
            comp++;
            atual = atual.getProximo();
        }
        return comp;
    }
    
            
    public String listValues(){
        
        Elemento elemento = first;
        String retorno = "";
        int i = 0;
        
        do {            
            retorno += i + " - " +  elemento.getNome() +" ( " + elemento.getdDuracao() + " ) \r\n";
            elemento = elemento.getProximo();
            i++;
        } while (elemento.getProximo() != null);
        
        return retorno;
    }
}
