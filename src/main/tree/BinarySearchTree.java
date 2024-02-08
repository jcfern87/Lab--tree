package tree;

import estrut.Tree;

public class BinarySearchTree implements Tree{

    private No raiz;

    @Override
    public boolean buscaElemento(int valor) {
        int terminou = 0;
        boolean encontrou = false;
        No ramo = raiz;
        while(terminou == 0){
            if(ramo == null){
                terminou = 1;
            }
            else if(ramo.obterValor() == valor){
                encontrou = true;
                terminou = 1;
            }
            else{
                if(valor > ramo.obterValor()){
                    ramo = ramo.obterFMaior();
                }
                else if(ramo.obterFMaior().obterValor() == valor){
                    ramo = ramo.obterFMaior();
                }
                else if(ramo.obterFMenor().obterValor() == valor){
                    ramo = ramo.obterFMenor();
                } 
            }
        }
        return encontrou;
    }

    @Override
    public int minimo() {
        return 0;
    }

    @Override
    public int maximo() {
        return 0;
    }

    @Override
    public void insereElemento(int valor) {
        if(raiz == null){
            raiz = new No(valor);
        }
        No ramo = raiz;
        Boolean inseriu = false;
        while (inseriu == false) {    
            if(ramo == null){
                ramo = new No(valor);
                inseriu = true;
            }
            else{
                if(ramo)
            }
        }    
    }

    @Override
    public void remove(int valor) {
        return;
    }

    @Override
    public int[] preOrdem() {
        return new int[]{1,2};
    }

    @Override
    public int[] emOrdem() {
        return new int[]{1,2};
    }

    @Override
    public int[] posOrdem() {
        return new int[]{1,2};
    }

}