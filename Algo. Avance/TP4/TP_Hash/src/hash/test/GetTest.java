package hash.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import hash.AbstractHashTable;

import org.junit.Before;
import org.junit.Test;

public class GetTest {

	AbstractHashTable<String, String> h;

	@Before
	public void setup() {
		h = ClassUnderTest.newHashTable();
	}

	@Test
	public void emptyTableGivesNull() {
		assertNull("Getting a key from an empty table should return null",
				h.get("Hello"));
	}

	@Test
	public void absentKeyGivesNull() {
		h.put("Hello", "World");
		assertNull("Getting an absent key should return null", h.get("World"));
	}

	@Test
	public void identicalKeyGivesTheValue() {
		String k = "Here";
		String v = "we are!";
		h.put(k, v);
		assertEquals(h.get(k), v);
	}

	@Test
	public void equalKeyGivesTheValue() {
		String k1 = "Why";
		String k2 = new String(k1);
		String v = "not";
		assertFalse(k1 == k2);
		assertTrue(k1.equals(k2));
		h.put(k1, v);
		assertEquals(h.get(k2), v);
	}

}
