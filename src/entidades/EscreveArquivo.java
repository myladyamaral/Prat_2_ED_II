package entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscreveArquivo {
	
	public static void escreve(String linha) {
		File arquivo = new File("C:/Users/Mylady/Documents/resultados.txt");
		try {
			if (!arquivo.exists()) {
				// cria um arquivo (vazio)
				arquivo.createNewFile();
			}
			// caso seja um diretório, é possível listar seus arquivos e diretórios
			File[] arquivos = arquivo.listFiles();
			// escreve no arquivo
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(linha);
			bw.newLine();
			bw.close();
			fw.close();
			// faz a leitura do arquivo

//			FileReader fr = new FileReader(arquivo);
//			BufferedReader br = new BufferedReader(fr);
//			// enquanto houver mais linhas
//			while (br.ready()) {
//				// lê a proxima linha
//				String linha1 = br.readLine();
//				// faz algo com a linha
//				System.out.println(linha1);
//			}
//			br.close();
//			fr.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
