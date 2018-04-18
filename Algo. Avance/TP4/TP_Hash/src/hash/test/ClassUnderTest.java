package hash.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import hash.AbstractHashTable;
import hash.MDHashTable;

import org.junit.Test;

public class ClassUnderTest {

	public static <K, V> AbstractHashTable<K, V> newHashTable() {
		// TODO: return a new instance of the hash table under test
		return new MDHashTable<K, V>();
	}

	@Test
	public void validObject() {
		try {
			AbstractHashTable<?, ?> h = ClassUnderTest.newHashTable();
			assertNotNull(
					"The result of ClassUnderTest.newHashTable() should not be null",
					h);
		} catch (Throwable e) {
			fail("The method ClassUnderTest.newHashTable() failed with " + e);
		}
	}

	@Test
	public void distinctInstances() {
		AbstractHashTable<?, ?> h1 = ClassUnderTest.newHashTable();
		AbstractHashTable<?, ?> h2 = ClassUnderTest.newHashTable();
		assertTrue(
				"Every call to ClassUnderTest.newHashTable() must return distinct instances.",
				h1 != h2);
	}

}
