package tree;

public class No {
    private int valor;
    private No filhoMaior;
    private No filhoMenor;
    
    public No(int valor){
        this.valor = valor;
        this.filhoMaior = null;
        this.filhoMenor = null;
    }

    public int obterValor(){
        return this.valor;
    }
    public No obterFMaior(){
        return this.filhoMaior;
    }
    public No obterFMenor(){
        return this.filhoMenor;
    }

    public void inserirFilho(No filho){
        if(this.valor > filho.obterValor() && this.filhoMaior != null){
            this.filhoMaior = filho;
        }
        else if(this.valor < filho.obterValor() && this.filhoMenor != null){
            this.filhoMenor = filho;
        }
        else if(this.valor == filho.obterValor()){
            if(this.filhoMenor != null){
                this.filhoMenor = filho;
            }
        }
    }
}
