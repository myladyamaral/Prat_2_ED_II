package entidades;

public class Item implements Comparable<Item>{

	private String chave;
	private String valor;
	private String valor1;
	private String valor2;
	
	public Item(String chave, String valor) {
		super();
		this.chave = chave;
		this.valor = valor;
	}


	public String getChave() {
		return chave;
	}


	public void setChave(String chave) {
		this.chave = chave;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValor1() {
		return valor1;
	}


	public void setValor1(String valor1) {
		this.valor1 = valor1;
	}


	public String getValor2() {
		return valor2;
	}


	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}


	public int compareTo(Item C) {
		Item aux = C;
		//aux.getChave().toUpperCase(); //Para trabalhar somente com maiúsculas
		
		int tamStr1 = this.getChave().length();
		int tamStr2 = aux.getChave().length();
		
		if(this.chave.equals(C.getChave())){
			return 0;
		}
		else {
			int i=0;
			while(i< tamStr1 && i<tamStr2) {
				if(this.getChave().charAt(i) < C.getChave().charAt(i)) {
					return -1;
				}
				else if(this.getChave().charAt(i) > C.getChave().charAt(i)) {
					return 1;
				}
				i++;
			}
			
		}
		System.out.println("Erro");
		return 0;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return chave+"\t"+valor+"\t"+valor1+"\t"+valor2;
	}
	
	
	
}
