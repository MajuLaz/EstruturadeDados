class Node {
    int valor;
    Node esquerda;
    Node direita;

    public Node(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}

class ArvoreBinariaBusca {
    private Node raiz;

    public ArvoreBinariaBusca() {
        raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserir_(raiz, valor);
    }

    private Node inserir_(Node atual, int valor) {
        if (atual == null) {
            return new Node(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = inserir_(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserir_(atual.direita, valor);
        }

        return atual;
    }

    public void percorrerPreOrdem() {
        percorrerPreOrdem(raiz);
    }

    private void percorrerPreOrdem(Node node) {
        if (node != null) {
            System.out.print(node.valor + " ");
            percorrerPreOrdem(node.esquerda);
            percorrerPreOrdem(node.direita);
        }
    }

    public void percorrerEmOrdem() {
        percorrerEmOrdem(raiz);
    }

    private void percorrerEmOrdem(Node node) {
        if (node != null) {
            percorrerEmOrdem(node.esquerda);
            System.out.print(node.valor + " ");
            percorrerEmOrdem(node.direita);
        }
    }

    public void percorrerPosOrdem() {
        percorrerPosOrdem(raiz);
    }

    private void percorrerPosOrdem(Node node) {
        if (node != null) {
            percorrerPosOrdem(node.esquerda);
            percorrerPosOrdem(node.direita);
            System.out.print(node.valor + " ");
        }
    }

    public void removerMaior() {
        raiz = removerMaior(raiz);
    }

    private Node removerMaior(Node atual) {
        if (atual == null) {
            return null;
        }

        if (atual.direita == null) {
            return atual.esquerda;
        }

        atual.direita = removerMaior(atual.direita);
        return atual;
    }

    public void removerMenor() {
        raiz = removerMenor(raiz);
    }

    private Node removerMenor(Node atual) {
        if (atual == null) {
            return null;
        }

        if (atual.esquerda == null) {
            return atual.direita;
        }

        atual.esquerda = removerMenor(atual.esquerda);
        return atual;
    }

    public void remover(int valor) {
        raiz = remover_(raiz, valor);
    }

    private Node remover_(Node atual, int valor) {
        if (atual == null) {
            return null;
        }

        if (valor == atual.valor) {
            if (atual.esquerda == null) {
                return atual.direita;
            } else if (atual.direita == null) {
                return atual.esquerda;
            }

            atual.valor = encontrarMenorValor(atual.direita);
            atual.direita = removerMenor(atual.direita);
        } else if (valor < atual.valor) {
            atual.esquerda = remover_(atual.esquerda, valor);
        } else {
            atual.direita = remover_(atual.direita, valor);
        }

        return atual;
    }

    private int encontrarMenorValor(Node node) {
        if (node.esquerda == null) {
            return node.valor;
        } else {
            return encontrarMenorValor(node.esquerda);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        arvore.inserir(8);
        arvore.inserir(3);
        arvore.inserir(11);
        arvore.inserir(1);
        arvore.inserir(5);
        arvore.inserir(9);
        arvore.inserir(14);
        arvore.inserir(6);
        arvore.inserir(10);
        arvore.inserir(12);
        arvore.inserir(15);
        arvore.inserir(7);
        arvore.inserir(13);

        System.out.println("Arvore Binaria de Busca:");
        arvore.percorrerEmOrdem();

        System.out.println("\nRemovendo o maior elemento:");
        arvore.removerMaior();
        arvore.percorrerEmOrdem();

        System.out.println("\nRemovendo o menor elemento:");
        arvore.removerMenor();
        arvore.percorrerEmOrdem();

        int valorARemover = 11;
        System.out.println("\nRemovendo o elemento " + valorARemover + ":");
        arvore.remover(valorARemover);
        arvore.percorrerEmOrdem();
    }
}