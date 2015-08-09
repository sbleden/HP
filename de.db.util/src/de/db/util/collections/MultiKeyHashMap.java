package de.db.util.collections;

import java.util.HashMap;

public class MultiKeyHashMap<K1, K2, V> {

	private HashMap<Key<K1, K2>, V> map;

	public MultiKeyHashMap() {
		map = new HashMap<>();
	}

	public void put(K1 k1, K2 k2, V value) {
		map.put(new Key<K1, K2>(k1, k2), value);
	}

	public V get(K1 k1, K2 k2) {
		return map.get(new Key<K1, K2>(k1, k2));
	}

	public int size() {
		return map.size();
	}

}
