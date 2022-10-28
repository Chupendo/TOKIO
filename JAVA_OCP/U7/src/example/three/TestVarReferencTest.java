package example.three;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestVarReferencTest {
	static ByTwos obj1;
	static ByThree obj2; 
	
	@BeforeAll
    static void initAll() {
		 obj1 = new ByTwos();
		 obj2 = new ByThree();
    }

    @BeforeEach
    void init() {
    }

	
	@Test
	@DisplayName("Test objGeneric equals to obj1")
	void test1() {
		Series objGeneric = obj1;
		
		assertEquals(obj1, objGeneric,"objGeneric = obj1");
		
		//objGeneric = obj2;
		//assertEquals(obj1, objGeneric,"objGeneric = obj1");
	}
	
	@Test
	@DisplayName("Test objGeneric equals to obj2")
	void test2() {
		Series objGeneric = obj2;
		
		assertNotEquals(obj1, objGeneric,"objGeneric = obj1");
		assertEquals(obj2, objGeneric,"objGeneric = obj2");
		assertEquals(2,objGeneric.getNext());
		assertTrue(objGeneric instanceof ByThree);
	}
	
	@AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
