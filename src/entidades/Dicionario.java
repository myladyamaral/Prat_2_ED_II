package entidades;


public interface Dicionario<K,V>{
//	ArrayList<Item>	 itens= new ArrayList<Item>();
	
	public int size();
	public V get(K key);
	public void insert(K key, V value);
	public void remove(K key);
	public void colisao(Item[] itens);
	
	
	

	
}
