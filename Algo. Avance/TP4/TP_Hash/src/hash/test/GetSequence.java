package hash.test;

import static org.junit.Assert.assertEquals;
import hash.AbstractHashTable;

import org.junit.Test;

public class GetSequence {

	@Test
	public void run() {
		AbstractHashTable<String, String> h = ClassUnderTest.newHashTable();
		assertEquals(null, h.get("Y"));
		h.put("M", "m");
		assertEquals(null, h.get("Y"));
		assertEquals("m", h.get("M"));
		h.put("C", "c");
		assertEquals(null, h.get("Y"));
		assertEquals("m", h.get("M"));
		assertEquals("c", h.get("C"));
		h.put("M", "n");
		assertEquals(null, h.get("Y"));
		assertEquals("n", h.get("M"));
		assertEquals("c", h.get("C"));
	}

}
