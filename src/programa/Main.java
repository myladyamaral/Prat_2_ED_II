package programa;

import java.io.IOException;
import java.util.Scanner;

import arvores.AVLTree;
import entidades.Item;
import entidades.LerArquivo;

public class Main {
	public static void main(String[] args) throws IOException {
		long operacoes = 0;//qualquer tipo de operação é somada aqui
		String metodo = "", tamVetor = "", tOrdem ="",tChave ="";
		Scanner sc = new Scanner(System.in);
		LerArquivo ler = new LerArquivo();
		
		//tipo de arvores
		AVLTree avl = new AVLTree();
		
		Item [] v = ler.abrirArquivo();
		
		System.out.println(" /** Funcao de Ordenacao: "
				+ "\nOpcao: ");
		int funcao = sc.nextInt();

		long tempoInicial = System.currentTimeMillis();//conta o tempo em que a execução começou
		switch(funcao) {
			case 1: 
				metodo = "Tentativa Linear";
				operacoes = avl.colisao(v);
				break;
			case 2: 
				metodo = "Lista Encadeada";
//				System.out.println("intro");
//				operacoes = i.sort(v, ordem);
				break;
			case 3: 
				metodo = "árvore AVL";
				//System.out.println("tree");
//				operacoes = m.sort(v,ordem);
				break;
			case 4: 
				metodo = "árvore Rubro-Negra";
				//System.out.println("quick");
//				operacoes = q.sort(v, ordem);
				break;

		}
	
		LerArquivo.printArray(v);
		
		System.out.println("Metodo: " +metodo+ "\n"
				+"Tamanho do vetor: " + v.length + "\n"
				+"Chave: " + tChave + "\n"
				+"Ordem: " + tOrdem + "\n"
				+"Operações: " + operacoes + "\n"
				+("Tempo Total: "+(System.currentTimeMillis() - tempoInicial))+" Milisegundos");
//		EscreveArquivo.escreve(metodo+ ","
//				+ v.length + ","
//				+ tChave + ","
//				+ tOrdem + ","
//				+ operacoes + ","
//				+(System.currentTimeMillis() - tempoInicial));
//		sc.close();
	}
	
}