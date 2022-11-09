package arvores;

public class AVLTree<Key extends Comparable<Key>, Item> {
	public int colisao(Item[] itens) {
		int size = itens.length;
		return 0;
	}
    private class Node {
        Key chave;
        Item item;
        Node esq, dir;

        int altura;
        int tamanho;

        Node(Key chave, Item item, int tamanho, int altura) {
            this.chave = chave;
            this.item = item;

            this.tamanho = tamanho;
            this.altura = altura;
        }
    }

    private Node raiz;

    public int tamanho() {
        return tamanho(raiz);
    }

    private int tamanho(Node no) {
        if (no == null) {
            return 0;
        }

        return no.tamanho;
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(Node no) {
        if (no == null) {
            return -1;
        }

        return no.altura;
    }

    public boolean isEmpty() {
        return tamanho(raiz) == 0;
    }

    private Node rotacaoEsquerda(Node no) {
        if (no == null || no.dir == null) {
            return no;
        }

        Node newRoot = no.dir;

        no.dir = newRoot.esq;
        newRoot.esq = no;

        no.altura = 1 + Math.max(altura(no.esq), altura(no.dir));
        newRoot.altura = 1 + Math.max(altura(newRoot.esq), altura(newRoot.dir));

        return newRoot;
    }

    private Node rotacaoDireita(Node no) {
        return null;
    	//IMPLEMENTAR
    }

    public void put(Key chave, Item item) {
        if (chave == null) {
            return;
        }

        if (item == null) {
            delete(chave);
            return;
        }

        raiz = put(raiz, chave, item);
    }

    private Node put(Node no, Key chave, Item item) {
        if (no == null) {
            return new Node(chave, item, 1, 0);
        }

        int compare = chave.compareTo(no.chave);

        if (compare < 0) {
            no.esq = put(no.esq, chave, item);
        } else if (compare > 0) {
            no.dir = put(no.dir, chave, item);
        } else {
            no.item = item;
        }

        no.altura = 1 + Math.max(altura(no.esq), altura(no.dir));
        no.tamanho = tamanho(no.esq) + 1 + tamanho(no.dir);

        return balance(no);
    }

    private Node balance(Node no) {

        if (fatorBalanceamento(no) < -1) {
            //dir-esq case
            if (fatorBalanceamento(no.dir) > 0) {
                no.dir = rotacaoDireita(no.dir);
            }
            no = rotacaoEsquerda(no);
        }

        if (fatorBalanceamento(no) > 1) {
            //esq-dir case
            if (fatorBalanceamento(no.esq) < 0) {
                no.esq = rotacaoEsquerda(no.esq);
            }
            no = rotacaoDireita(no);
        }

        return no;
    }

    /**
     * RETORNAR O FATOR DE BALANCEMANETO
     */
    private int fatorBalanceamento(Node no) {
        //IMPLEMENTAR
    	return 0;
    }

    public Item get(Key chave) {
        if (chave == null) {
            return null;
        }

        return get(raiz, chave);
    }

    private Item get(Node no, Key chave) {
        if (no == null) {
            return null;
        }

        int compare = chave.compareTo(no.chave);
        if (compare < 0) {
            return get(no.esq, chave);
        } else if (compare > 0) {
            return get(no.dir, chave);
        } else {
            return no.item;
        }
    }

    public boolean contains(Key chave) {
        if (chave == null) {
            throw new IllegalArgumentException("Argument to contains() cannot be null");
        }
        return get(chave) != null;
    }

  

    public void delete(Key chave) {
    }
    	

    private boolean isAVL() {
        return isAVL(raiz);
    }

    private boolean isAVL(Node no) {
        if (no == null) {
            return true;
        }

        int fatorBalanceamento = fatorBalanceamento(no);
        if (fatorBalanceamento < -1 || fatorBalanceamento > 1) {
            return false;
        }

        return isAVL(no.esq) && isAVL(no.dir);
    }

}
