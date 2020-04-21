package br.com.samuka.simplelist.simples;

/**
 *
 * @author Lab.Academico
 */
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
     * Armazena o elemento atual da lista.
     */
    private Elemento atual;
    
    
    public Lista(){
        first = last = atual = null;
    }
    
    /**
     * Verifique se a lista está vazia
     * @return True para possítivo.
     */
    public boolean isEmpty(){
        return first == null;
    }
    
    /**
     * Adiciona o elemento na primeira posição.
     * @param valor
     */
    public void addFirst(int valor){
        
        Elemento elemento = new Elemento(valor);
        
        if(!isEmpty())
            elemento.setProximo(first);
        
        first = elemento;
        
    }
    
    /**
     * Adiciona o elemento na última posição.
     * @param valor
     */
    public void add(int valor){
        
        if(isEmpty())
            addFirst(valor);
        else{
            Elemento element = new Elemento(valor);
           
            if(last != null)
                last.setProximo(element);
            
            last = element;
        }
        
        
        
    }
    
    /**
     * Adiciona o valor na posição passada.
     * @param index Posição a ser inserido
     * @param valor valor a ser inserido
     */
    public void add(int index, int valor){
        //percorreElementos(0, first, last) < index
        if(index >= 0){
            
            Elemento elemento = new Elemento(valor);
            
            //encontraElemento(0, index, first).setProximo(elemento);
            
            elemento.setProximo(encontraElemento(0, index, first));
            
            last = first;
            
            if(index == 0)
                first = elemento;
            
            
            
        }else{
            System.out.println("Posição não existente, será inserido da última posição");
            this.add(valor);
        }
        
    }
    
    /**
     * @return Primeira posição da lista
     */
    private int getFirst(){
        return first.getValor();
    }
    
    /**
     * @return Última posição da lista
     */
    private int getLast(){
        return last.getValor();
    }
    
    /**
     * @return Retorna o comprimento da lista.
     */
    public int lenght(){
        
        int lenght = 0;
        
        if(isEmpty())
            return lenght;
        
        return percorreElementos(0, first, last);
    }

    /**
     * Retorna o valor do elemento da posição informada.
     * @param index posição a ser encontrada
     * @return Valor do elemento.
     */
    public int getElemento(int index){
        
        return encontraElemento(0, index, first).getValor();
        
    }
    
    /**
     * Encontra a posição da valor
     * @param valor Valor a ser encontrado
     * @return index atual da primeira ocorrencia
     */
    public int getElementoValue(int valor){
        return encontraElemento(valor, 0, first, last);
    }
    
    /**
     * Remove o primeiro elemento da lista.
     */
    public void removeFirst(){
        
        first = first.getProximo();
        
    }
    
    /**
     * Remove  último elemento da lista.
     */
    public void remove(){
        atual = encontraElemento(0, percorreElementos(0, first, last) -1, first);
        
        atual.setProximo(null);
        last = atual;
        
    }
    
    /**
     * Remove elemento com o valor encontrado.
     * @param valor valor do elemento a ser removido
     */
    public void removeElemento(int valor){
            
        int posElemento = encontraElemento(valor, 0, first, last);
        
        Elemento elemento =  encontraElemento(0, posElemento, first) ;

        encontraElemento(0, posElemento -1, first).setProximo(encontraElemento(0, posElemento, first));
        
    }
    
    /**
     * Remove elemento da posição passada por parâmetro.
     * @param index posição do elemento a ser removido
     */
    public void remove(int index){
        
        if(index >= 0 && percorreElementos(0, first, last) < index){
            
            Elemento elemento = encontraElemento(0, index, first);
            
            encontraElemento(0, index -1, first).setProximo(encontraElemento(0, index, first));
            
        } 
        
    }
    
    /**
     * Percorre os elementos atuais da lista.
     * @param qtd Quantidade atual de itens encontrados.
     * @param atual Item atual da lista
     * @param ultimo Ultimo item da lista
     * @return quantidade de itens da lista
     */
    private int percorreElementos(int qtd, Elemento atual, Elemento ultimo){
        
        if(atual != ultimo)
            percorreElementos(qtd++, atual.getProximo(), ultimo);
        
        return qtd;
        
    }
    
    /**
     * Percorre os elementos atuais da lista
     * @param index posição atual
     * @param findIndex posição à encontrar.
     * @param atual elemento atual da busca
     * @return Elemento atual da posição requisitada
     */
    private Elemento encontraElemento(int index, int findIndex, Elemento atual){
        
        if(index < findIndex)
            encontraElemento(index++, findIndex, atual.getProximo());
        
        return atual;
        
    }
    
    /**
     * Percorre os elementos atuais da lista
     * @param valor valor a ser encontrado na lista
     * @param findIndex posição à encontrar.
     * @param atual elemento atual da busca
     * @return Elemento atual da posição requisitada
     */
    private int encontraElemento(int valor, int index, Elemento atual, Elemento last){
        
        if(atual.getValor() != valor && atual != last)
            encontraElemento(valor, index++, atual.getProximo(), last);
        
        return index;
        
    }
    
    
    public String listAllValues(){
        
        int i = 0;
        String retorno = "";
        
        while(i < lenght()){
            retorno += "\r\n "+encontraElemento(0, i, first).getValor();
        }
        
        
        return retorno;
    }
    
    
}
