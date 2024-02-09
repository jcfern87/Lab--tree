package tree;

public class No {
    private int valor;
    public No filhoMaior;
    public No filhoMenor;
    
    public No(int valor){
        this.valor = valor;
        this.filhoMaior = null;
        this.filhoMenor = null;
    }

    public int obterValor(){
        return this.valor;
    }
    public void mudarValor(int valor){
        this.valor = valor;
    }
}
