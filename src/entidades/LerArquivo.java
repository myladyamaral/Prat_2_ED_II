package entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LerArquivo extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -716728475752189092L;

	public Item[] abrirArquivo(){
		
		JFileChooser arq = new JFileChooser("C:");
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos de texto", "txt", "csv");
		arq.setFileFilter((javax.swing.filechooser.FileFilter) filtro);
		//acionando o filtro que faz aparecer a caixa de dialogo
		arq.addChoosableFileFilter((javax.swing.filechooser.FileFilter) filtro); 
		arq.setDialogTitle("Selecione um arquivo...");
		arq.showOpenDialog(new JFrame("")); 
		arq.setVisible (true);
		String endereco = arq.getSelectedFile().getAbsolutePath(); //Coleta de Endereço
		File arquivo = new File(endereco);
		
		System.out.println("String");
		return ler(endereco, arquivo);
	
	}
					
	public Item[] ler(String endereco, File arquivo){
		
		int numL = numLinhasArquivo(endereco);//Método definido para saber qual será o tamanho do vetor
		Item[] vetor = new Item[numL];
		
		if (arquivo.canRead()) {
			
			Item key = null;
			
			try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
				
				String line = br.readLine();
				int i = 0;
				while (line != null) {
					String[] vect = line.split(",");
					
	                String chave = vect[0];
	                String valor = vect[1];
	                key = new Item(chave, valor);
	                vetor[i++] = key;//adicionando a chave ao vetor

					line = br.readLine();
					
				}
			}
			catch (IOException e) { // trata as exceções do tipo FileNotFoundException   
		        System.out.println(e.getMessage());;   
		    }
				
		}
		
		return vetor;
					
	}
	public static void printArray(Item[] array){
		int size = array.length;
		//criando uma variavel auxiliar para conversao de tipo;
		Item k = null;
		for(int i=0; i<size; i++){
			k =  (Item)array[i];
			System.out.println("Chave: " + k.getChave());
			System.out.println("Valor 1: " + k.getValor());
			System.out.println("Valor 2: " + k.getValor1());
			System.out.println("Valor 3: " + k.getValor2());
		}
		System.out.println();
	}		
	

	public int numLinhasArquivo(String endereco) {//função necessaria para inicializar o vetor
		int numLin = 0;
		try {		
			Scanner arq = new Scanner (new File (endereco));	      
	        while (arq.hasNextLine()){
	        	arq.nextLine();
	        	numLin ++;
	        }
		}
		catch (IOException e) { // trata as exceções do tipo FileNotFoundException   
	        System.out.println(e.getMessage());;   
	    }
		return numLin;
	}
		
	}
	
