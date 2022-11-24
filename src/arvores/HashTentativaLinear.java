package arvores;

import java.util.Arrays;

import entidades.Dicionario;
import entidades.Item;

public class HashTentativaLinear<K, V> implements Dicionario<K, V> {
	private int N; // numero de pares de chaves na tabela
	private int M = 16; // Tamanho da tabela hash com tratamento linear
	private K[] chaves; // the chaves
	private V[] itens; // the itemues

	public HashTentativaLinear() {
		chaves = (K[]) new Object[M];
		itens = (V[]) new Object[M];
	}

	public HashTentativaLinear(int cap) {
		chaves = (K[]) new Object[cap];
		itens = (V[]) new Object[cap];
		M = cap;
	}

	/**
	 * Calcula o Hash
	 * 
	 * @param chave
	 * @return inteiro no valor da chave
	 */
	private int hash(K chave) {
		System.out.println("hash: " +chave);
		System.out.println("hashCODE: " +chave.hashCode());
		int pos = (chave.hashCode() & 0x7fffffff) % M;
		System.out.println("pos: " +pos);
		return pos;
	}

	/**
	 * Redimensiona a tabela de acordo com a quantidade de chaves/ multiplica o tamanho do hash por dois.
	 * 
	 * @param cap
	 */
	private void resize(int cap) {

		HashTentativaLinear<K, V> t;
		t = new HashTentativaLinear<K, V>(cap*2);

		for (int i = 0; i < chaves.length; i++)
			if (chaves[i] != null)
				t.insert(chaves[i], itens[i]);
		chaves = t.chaves;
		itens = t.itens;
		M = t.M;

	}

	/**
	 * Testa se chave informada já esta mapeada.
	 * 
	 * @param chave
	 * @return boolean
	 */
	public boolean contains(K chave) {
		if (chave == null) {
			System.out.println("chave nula");
			
			//throw new IllegalArgumentException("Argument to contains() cannot be null");
		}

		return get(chave) != null;
	}
	 public boolean cheia() {
		    int i, qtde=0;
		    for (i=0; i<M; i++)
		 	if(chaves[i]!=null ) qtde++;
		    if (qtde == M) return true;
		    return false;
		}
	/**
	 * Insere um novo objeto no Hash
	 * 
	 * @param chave
	 * @param item
	 */
	@Override
	public void insert(K chave, V item) {
		if (cheia()) { // Se tabela cheia, imprime aviso e sai da função
		       System.out.println("\n->ATENCAO Tabela cheia");
		       return; // saida imediata da função, nao executa os comandos abaixo
		 }
			
		int pos = hash(chave); // CALCULA POSIÇAO
			
		    // INICIO ROTINA TRATAMENTO DE COLISAO
		if (chaves[pos]!=null) { // se ocorreu colisao
			if (chaves[pos].equals(chave)) { // se a chave ja existe
				itens[pos] = item;
				System.out.println("\n->ATENCAO Esse item ja foi cadastrado");
				return; // saida imediata da função
			}

			System.out.println("-> Ocorreu uma colisao na posicao " + pos);
			while (pos < M) {
				if (pos == M-1 ) pos = -1; // volta para o inicio da tabela
				pos++; // incremento mais um no indice
				if ( chaves[pos]==null) // se a posição estiver livre
					break; // sai do loop com o indice na posicao correta (pos sem colisão)
			}
		}
		    // FIM ROTINA TRATAMENTO DE COLISAO
		    chaves[pos] = chave;
			itens[pos] = item;
		    System.out.print("-> Inserido HASH[" + pos + "]");
	}

	/**
	 * Remove um objeto do Hash
	 * 
	 * @param chave
	 */
	@Override
	public void remove(K chave) {
		if (chave == null)
			throw new IllegalArgumentException("Argument to remove() cannot be null");

		if (!contains(chave))
			return;

		int i = hash(chave);
		while (!chave.equals(chaves[i]))
			i = (i + 1) % M;

		chaves[i] = null;
		itens[i] = null;
		i = (i + 1) % M;

		while (chaves[i] != null) {
			K chaveToRedo = chaves[i];
			V itemToRedo = itens[i];
			chaves[i] = null;
			itens[i] = null;
			N--;
			insert(chaveToRedo, itemToRedo);
			i = (i + 1) % M;
		}
		N--;
		if (N > 0 && N == M / 8)
			resize(M / 2);
	}

	/**
	 * Busca um objeto no Hash
	 * 
	 * @param chave
	 * @return Valor referente a chave buscada
	 */
	@Override
	public V get(K chave) {
		int pos = hash(chave);
		System.out.println("POSIÇÃO: "+pos);
		if (chaves[pos]!=null) {
			if (chaves[pos].equals(chave)) { // Se o campo esta ocupado e o nome e chave são iguais
				return itens[pos]; // saida imediata da função
			}
			// INICIO ROTINA TRATAMENTO DE COLISAO (se o item e chave nao sao iguais)
			else{
				int iniciobusca = pos;
				while (pos < M) { // percorre proximas posições do vetor
					if (pos == M - 1)
						pos = -1; // volta para o inicio da tabela
					pos++; // incremento mais um no indice
					if (chaves[pos]!=null && chaves[pos].equals(chave)) // se o campo esta ocupado e o item foi encontrado
						return itens[pos]; // saida imediata da função
					if (pos == iniciobusca)
						return null; // se percorreu tudo e nao encontrou
				}
			// FIM ROTINA TRATAMENTO DE COLISAO
			}
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void colisao(Item[] itens1) {
		HashTentativaLinear<K, V> htl = new HashTentativaLinear<>();
		for (int i = 0; i <= itens1.length - 1; i++) {
			K chave = (K) itens1[i].getChave();
			System.out.println("********************" + "\nChave: " + chave);
			htl.insert(chave, (V) itens1[i]);
		}
		System.out.println(htl);
		
		System.out.println(htl.get((K)"10"));
	}

	@Override
	public String toString() {
		return "HashTentativaLinear [N=" + N + ", M=" + M + ", chaves=" + Arrays.toString(chaves) + ", itens="
				+ Arrays.toString(itens) + "]";
	}

}
