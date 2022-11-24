package programa;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

import arvores.*;
import entidades.Item;
import entidades.LerArquivo;

public class Main {
	public static void main(String[] args) throws IOException {
		long operacoes = 0;//qualquer tipo de opera��o � somada aqui
		String metodo = "", tamVetor = "", tOrdem ="",tChave ="";
		Scanner sc = new Scanner(System.in);
		LerArquivo ler = new LerArquivo();
		
		//tipo de arvores
		AVL avl = new AVL();
		AVLTree avlt = new AVLTree();
		
		
		Item [] v = ler.abrirArquivo();
		
		System.out.println(" /** Insira a capacidade maxima do seu Dicionario:");
		int tam = sc.nextInt();
		
		System.out.println(" /** Funcao de Ordenacao: "
				+ "\nOpcao: ");
		int funcao = sc.nextInt();

		long tempoInicial = System.currentTimeMillis();//conta o tempo em que a execu��o come�ou
		switch(funcao) {
			case 1: 
				metodo = "AVL";
				//ler.printArray(v);
//				avl.colisao(avl,10, v);
//				avlt.colisao(10, v);
				HashTentativaLinear htl = new HashTentativaLinear(tam);
				htl.colisao(v);
				break;

		}
	
//		LerArquivo.printArray(v);
		
//		System.out.println("Metodo: " +metodo+ "\n"
//				+"Tamanho do vetor: " + v.length + "\n"
//				+"Chave: " + tChave + "\n"
//				+"Ordem: " + tOrdem + "\n"
//				+"Opera��es: " + operacoes + "\n"
//				+("Tempo Total: "+(System.currentTimeMillis() - tempoInicial))+" Milisegundos");
//		EscreveArquivo.escreve(metodo+ ","
//				+ v.length + ","
//				+ tChave + ","
//				+ tOrdem + ","
//				+ operacoes + ","
//				+(System.currentTimeMillis() - tempoInicial));
//		sc.close();
	}
	
}