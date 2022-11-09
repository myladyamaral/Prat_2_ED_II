package entidades;

import java.util.List;

public interface Dicionario <Key extends Comparable<Key>,Item>{
	
	
	public default int size(List<Item> itens) {
		return itens.size();
	}
	public default String get(List<Item> itens,Item item, String chave) {
		return "Chave não encontrada";
	}
	
	public default String insert(List<Item> itens,String chave, String valor) {
		return "";
	}
	
	public default void remove(List<Item> itens,Item item, String chave) {
	}
}
