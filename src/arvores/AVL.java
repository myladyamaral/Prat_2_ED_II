package arvores;

import entidades.Dicionario;
import entidades.Item;

public class AVL <K extends Comparable<K>, V> implements Dicionario<K, V>{
	class Node {
	    K chave;
	    V valor;
	    int altura;
	    Node esquerda, direita;
	 
	    Node(K chave, V valor) {
	        this.chave = chave;
	        this.valor = valor;
	        altura = 1;
	    }
	}
	 
	    Node raiz;
	    
	 
	    public Node getRaiz() {
			return raiz;
		}


		//altura da arvore
	    int altura(Node N) {
	        if (N == null)
	            return 0;
	 
	        return N.altura;
	    }
	 
	    // obtem max de dois numeros
	    int max(int a, int b) {
	        return (a > b) ? a : b;
	    }
	 
	    // girar à direita subarvore com raiz em y
	    Node direitaRotate(Node y) {
	        Node x = y.esquerda;
	        Node T2 = x.direita;
	 
	        // Executar rotação
	        x.direita = y;
	        y.esquerda = T2;
	 
	        // atualiza alturas
	        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;
	        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;
	 
	        // nova raiz
	        return x;
	    }
	 
	    // girar à esquerda subarvore com raiz em  x
	    Node esquerdaRotate(Node x) {
	        Node y = x.direita;
	        Node T2 = y.esquerda;
	 
	        // Executar rotação
	        y.esquerda = x;
	        x.direita = T2;
	 
	        //  atualiza alturas
	        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;
	        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;
	 
	        // nova raiz
	        return y;
	    }
	 
	    // balanceia a arvore
	    int getBalance(Node N) {
	        if (N == null)
	            return 0;
	 
	        return altura(N.esquerda) - altura(N.direita);
	    }
	 
	    Node insert(Node node, K chave, V valor) {
	 
	        /* 1.  Perform the normal BST insertion */
	        if (node == null)
	            return (new Node(chave,valor));
	        
	        int compare = chave.compareTo(node.chave);
	        if (compare < 0)
	            node.esquerda = insert(node.esquerda, chave, valor);
	        if (compare > 0)
	            node.direita = insert(node.direita, chave, valor);
	        if(compare==0) { 
	        	return null;
	        }
	        /* 2. Update altura of this ancestor node */
	        node.altura = 1 + max(altura(node.esquerda),
	                              altura(node.direita));
	 
	        /* 3. Get the balance factor of this ancestor
	              node to check whether this node became
	              unbalanced */
	        int balance = getBalance(node);
	 
	        // If this node becomes unbalanced, then there
	        // are 4 cases esquerda esquerda Case
	        if (balance > 1 && chave.compareTo(node.esquerda.chave)< 0)
	            return direitaRotate(node);
	 
	        // direita direita Case
	        if (balance < -1 && chave.compareTo(node.direita.chave) > 0)
	            return esquerdaRotate(node);
	 
	        // esquerda direita Case
	        if (balance > 1 && chave.compareTo(node.esquerda.chave)> 0) {
	            node.esquerda = esquerdaRotate(node.esquerda);
	            return direitaRotate(node);
	        }
	 
	        // direita esquerda Case
	        if (balance < -1 && chave.compareTo(node.direita.chave) < 0) {
	            node.direita = direitaRotate(node.direita);
	            return esquerdaRotate(node);
	        }
	 
	        /* return the (unchanged) node pointer */
	        return node;
	    }
	 
	    // A utility function to print preorder traversal
	    // of the tree.
	    // The function also prints altura of every node
	   public void preOrder(Node node) {
	        if (node != null) {
	            System.out.print(node.chave + " - "+node.valor+"\n");
	            preOrder(node.esquerda);
	            preOrder(node.direita);
	        }
	    }

		@Override
		  public boolean isEmpty() {
	        return altura(raiz) == 0;
	    }
		
		 public int colisao(AVL tree,int tam, Item [] itens) {
			 
			 for(int i = 0; i<=itens.length-1;i++) {
				 K chave = (K) itens[i].getChave();
					if(i>=(tam*95/100)) {
		//cria nova arvore e copia os elementos da antiga para a nova e apaga a antiga				
//						AVLTree tree1 = new AVLTree();
						System.out.println("ULTRAPASSOU 95%");
					}
					else {
						if(tree.raiz==null) {
							tree.raiz = tree.insert(tree.raiz, chave, itens[i]);
						}
						else {
							int compare = chave.compareTo((K) tree.raiz.chave);
						    if (compare == 0) {
						    	tree.raiz.valor = itens[i];
						    	itens[i] = null;
						    }
						    else {
						    	tree.raiz = tree.insert(tree.raiz, chave, itens[i]);
						    }
					    }
						System.out.println("raiz"+itens[i].getChave());
						tree.preOrder(tree.raiz);
					}
			 }
			 System.out.println("AVL FINAL");
			 tree.preOrder(tree.raiz);
			 return 0;
			}
	}
