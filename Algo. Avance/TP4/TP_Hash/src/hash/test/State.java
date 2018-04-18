package hash.test;

import static org.junit.Assert.assertTrue;
import hash.AbstractHashTable;
import hash.Mapping;

import java.util.List;

public class State {

	public static <K, V> void check(AbstractHashTable<K, V> h) {
		List<Mapping<K, V>>[] tab = h.table;
		int n = 0;
		for (int i = 0; i < tab.length; i++) {
			for (Mapping<K, V> m : tab[i]) {
				int exp_i = m.getKey().hashCode() % tab.length;
				assertTrue("The entry " + m + " should be at index " + exp_i
						+ " but was found at index " + i, exp_i == i);
				n++;
			}
		}
		assertTrue("The hash table has size " + h.size + " but contained " + n
				+ " entries", h.size == n);
	}

	public static <K, V> int mappingsCount(AbstractHashTable<K, V> h) {
		int n = 0;
		for (List<Mapping<K, V>> l : h.table) {
			n += l.size();
		}
		return n;
	}

}
