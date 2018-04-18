package hash.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import hash.AbstractHashTable;

import org.junit.Test;

public class PutSequence {

	public static <K, V> void put(AbstractHashTable<K, V> h, K key, V value,
			V exp_prev) {
		int size_bef = h.size;
		V prev = h.put(key, value);
		if (exp_prev == null) {
			assertNull("When adding a new entry, put should return null", prev);
			assertEquals(
					"When adding a new entry, the size should be increased by one",
					size_bef + 1, h.size);
		} else {
			assertEquals(
					"When updating an entry, put should return the old value",
					exp_prev, prev);
			assertEquals(
					"When updating an entry, the size should be unchanged",
					size_bef, h.size);
		}
		State.check(h);
	}

	@Test
	public void run() {
		AbstractHashTable<String, Integer> h = ClassUnderTest.newHashTable();
		put(h, "A", 1, null);
		put(h, "B", 2, null);
		put(h, "C", 1, null);
		put(h, "A", 4, 1);
		put(h, "A", 0, 4);
		put(h, "Hello", 9, null);
	}
}
