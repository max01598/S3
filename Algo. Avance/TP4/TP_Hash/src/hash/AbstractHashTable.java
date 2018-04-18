package hash;

import java.util.List;

public abstract class AbstractHashTable<K,V> {
	
	public List<Mapping<K,V>>[] table;
	
	public int size;
	
	
	
	/**
	 * Associates the specified value with the specified key in this map.
	 * If the map previously contained a mapping for the key, the old
	 * value is replaced.
	 *
	 * @param key key with which the specified value is to be associated
	 * @param value value to be associated with the specified key
	 * @return the previous value associated with <tt>key</tt>, or
	 *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
	 * @throws NullPointerException if the key or the value is <tt>null</tt>
	 */
	public abstract V put(K key, V value);
	
	/**
	 * Returns the value to which the specified key is mapped,
	 * or {@code null} if this map contains no mapping for the key.
	 *
	 * @see #put(Object, Object)
	 */
	public abstract V get(Object key);
}
