package hash.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import hash.AbstractHashTable;

import org.junit.Before;
import org.junit.Test;

public class NewTest {

	AbstractHashTable<?, ?> h;

	@Before
	public void setup() {
		h = ClassUnderTest.newHashTable();
	}

	@Test
	public void initialSizeIsZero() {
		assertEquals("The size of the new " + h.getClass().getSimpleName()
				+ " is invalid.", 0, h.size);
	}

	@Test
	public void initialTableIsNotNull() {
		assertNotNull("The table of the new " + h.getClass().getSimpleName()
				+ " should not be null.", h.table);
	}

	@Test
	public void initialTableCapacityIsFour() {
		assertEquals("The capacity of the table is invalid.", 4, h.table.length);
	}

	@Test
	public void initialTableCellsAreNotNull() {
		for (int i = 0; i < h.table.length; i++) {
			assertNotNull("The list at index " + i
					+ " of the table should not be null.", h.table[i]);
		}
	}

	@Test
	public void initialTableCellsAreEmpty() {
		for (int i = 0; i < h.table.length; i++) {
			assertTrue("The list at index " + i
					+ " of the table should be empty.", h.table[i].isEmpty());
		}
	}
}
