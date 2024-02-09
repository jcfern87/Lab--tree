package tree;

import java.util.ArrayList;

import estrut.Tree;

public class BinarySearchTree implements Tree{

    private No raiz;

    public BinarySearchTree(){
        this.raiz = null;
    }

    @Override
    public boolean buscaElemento(int valor) {
        No busca = buscaRecursiva(raiz, valor);
        if(busca == null){
            return false;
        }
        return true; 
    }

    //função privada recursiva de procura
    private No buscaRecursiva(No raiz, int valor){
        //Caso o método encontre um nó nulo ou o que tenha o valor procurado
        if (raiz == null || raiz.obterValor() == valor) {
            return raiz;
        }
        if (raiz.obterValor() < valor) {
           return buscaRecursiva(raiz.filhoMaior, valor);
        }
        return buscaRecursiva(raiz.filhoMenor, valor);
    }

    @Override
    public int minimo() {
        return minValor(raiz);
    }

    private int minValor(No raiz) {
        //valor inicial mínimo é a raiz
        int minval = raiz.obterValor();
        //encontrar o minval
        while(raiz.filhoMenor != null){
            minval = raiz.filhoMenor.obterValor();
            raiz = raiz.filhoMenor;
        }
        return minval;
    }

    @Override
    public int maximo() {
        return 0;
    }

    @Override
    public void insereElemento(int valor) {
        raiz = insereRecursivo(raiz, valor);
    }

    //Método recursivo para inserir o nó na árvore
    private No insereRecursivo(No raiz, int valor){
        //árvore está vazia e a raiz é nula
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }
        //árvore não está vazia
        if(raiz.obterValor() > valor){
            raiz.filhoMenor = insereRecursivo(raiz.filhoMenor, valor);
        }
        else if(raiz.obterValor() < valor){
            raiz.filhoMaior = insereRecursivo(raiz.filhoMaior, valor);
        }
        return raiz;
    }

    @Override
    public void remove(int valor) {
        raiz = removeRecursivo(raiz, valor);
    }

    private No removeRecursivo(No raiz, int valor) {
        //caso a árvore esteja vazia
        if(raiz == null){
            return raiz;
        }
        //percorrer a árvore
        if(valor < raiz.obterValor()){ //percorrer a subárvore esquerda
            raiz.filhoMenor = removeRecursivo(raiz.filhoMenor, valor);
        }
        else if(valor > raiz.obterValor()){ //percorre a subárvore direita
            raiz.filhoMaior = removeRecursivo(raiz.filhoMaior, valor);
        }
        else{
            //nó só tem 1 filho
            if(raiz.filhoMaior == null){
                return raiz.filhoMenor;
            }
            else if(raiz.filhoMenor == null){
                return raiz.filhoMaior;
            }
            //nó tem 2 filhos
            //pegar o sucessor emOrdem (valor mínimo na subárvore direita)
            raiz.mudarValor(minValor(raiz.filhoMaior));
        }
        return raiz;
    }

    @Override
    public int[] preOrdem() {
        ArrayList<Integer> arvore = new ArrayList<>();
        preOrdemRecursivo(this.raiz, arvore); 
        int[] tree = new int[arvore.size()];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = arvore.get(i);
        }
        return tree;
    }

    private void preOrdemRecursivo(No raiz, ArrayList<Integer> arvore) {
        if(raiz != null){
            arvore.add(raiz.obterValor()); 
            preOrdemRecursivo(raiz.filhoMenor, arvore);
            preOrdemRecursivo(raiz.filhoMaior, arvore);
        }
    }

    @Override
    public int[] emOrdem() {
        ArrayList<Integer> arvore = new ArrayList<>();
        emOrdemRecursivo(this.raiz, arvore); 
        int[] tree = new int[arvore.size()];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = arvore.get(i);
        }
        return tree;
    }

    //método recursivo que cria um arraylist em ordem da árvore sendo analisada
    private void emOrdemRecursivo(No raiz, ArrayList<Integer> arvore){
        if(raiz != null){
            emOrdemRecursivo(raiz.filhoMenor, arvore);
            arvore.add(raiz.obterValor()); 
            emOrdemRecursivo(raiz.filhoMaior, arvore);
        }
    } 
    @Override
    public int[] posOrdem() {
        ArrayList<Integer> arvore = new ArrayList<>();
        posOrdemRecursivo(this.raiz, arvore); 
        int[] tree = new int[arvore.size()];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = arvore.get(i);
        }
        return tree;
    }

    private void posOrdemRecursivo(No raiz, ArrayList<Integer> arvore) {
        if(raiz != null){
            posOrdemRecursivo(raiz.filhoMenor, arvore);
            posOrdemRecursivo(raiz.filhoMaior, arvore);
            arvore.add(raiz.obterValor()); 
        }
    }

}