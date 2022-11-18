package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public interface Dicionario<K,V> extends Map<K,V>, Cloneable, Serializable{
	
	
	public default int size(List<Item> itens) {
		//retorna o numero de itens no dicionario
		return 0;
	}
	public default String get(List<Item> itens,Item item, String chave) {
		//retorna o valor associado a uma chave se a chave estiver presente
		return "0";
	}
	
	public default String insert(List<Item> itens,String chave, String valor) {
		//associa uma chave a um valor no dicionário
		//substituindo o valor anterior da chave sejá estiver presente.
		return "0";
	}
	
	public default void remove(List<Item> itens,Item item, String chave) {
		//remove uma chave e seu valor associado se a chave estiver presente.
	}
	

	@Override
	public default int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public default boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public default boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public default V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public default V put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public default V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public default void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public default void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public default Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public default Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public default Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
}
