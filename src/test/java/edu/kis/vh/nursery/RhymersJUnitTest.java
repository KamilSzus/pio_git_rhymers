package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RhymersJUnitTest {
	final int STACK_CAPACITY = 12;
	final int EMPTY_STACK_VALUE = -1;
	DefaultCountingOutRhymer rhymer;

	@Before
	public void init(){
		rhymer = new DefaultCountingOutRhymer();
	}

	@Test
	public void testCountIn() {
		int expectedValue = 4;
		rhymer.countIn(expectedValue);

		int result = rhymer.getLastNumber();
		Assert.assertEquals("Return value should be "+expectedValue+ " but is " + result
				,expectedValue,result);
	}

	@Test
	public void testCallCheck() {
		boolean result = rhymer.callCheck();
		Assert.assertTrue("Return value should be "+ true + " but is " + result
				,result);

		rhymer.countIn(888);

		result = rhymer.callCheck();
		Assert.assertFalse("Return value should be "+ false + " but is " + result
				,result);
	}

	@Test
	public void testIsFull() {
		for (int i = 0; i < STACK_CAPACITY; i++) {
			boolean result = rhymer.isFull();
			Assert.assertFalse("Return value should be "+ false + " but is " + result
					,result);
			rhymer.countIn(888);
		}

		boolean result = rhymer.isFull();
		Assert.assertTrue("Return value should be "+ true + " but is " + result
				,result);
	}

	@Test
	public void testPeekaboo() {
		int result = rhymer.getLastNumber();
		Assert.assertEquals("Result should be " + EMPTY_STACK_VALUE + " But is " + result
				,EMPTY_STACK_VALUE, result);

		int testValue = 4;
		rhymer.countIn(testValue);

		result = rhymer.getLastNumber();
		Assert.assertEquals("Result should be " + testValue + " But is " + result
				,testValue, result);
	}

	@Test
	public void testCountOut() {
		int result = rhymer.countOut();
		Assert.assertEquals("Result should be " + EMPTY_STACK_VALUE + " But is " + result
				,EMPTY_STACK_VALUE, result);

		int testValue = 4;
		rhymer.countIn(testValue);

		result = rhymer.countOut();
		Assert.assertEquals("Result should be " + testValue + " But is " + result
				,testValue, result);

		result = rhymer.countOut();
		Assert.assertEquals("Result should be " + EMPTY_STACK_VALUE + " But is " + result
				,EMPTY_STACK_VALUE, result);
	}

	@Test
	public void testReportRejected(){
		HanoiRhymer hanoiRhymer = new HanoiRhymer();
		for(int i = 0; i<STACK_CAPACITY;i++){
			hanoiRhymer.countIn(i);
		}

		int result = hanoiRhymer.reportRejected();

		Assert.assertEquals("Result should be " + 3 + " But is " + result
				,STACK_CAPACITY-1, result);
	}

	@Test
	public void testGetLastNumber(){
		int expectedValue = 2;
		rhymer.countIn(4);
		rhymer.countIn(3);
		rhymer.countIn(expectedValue);

		int result = rhymer.getLastNumber();

		Assert.assertEquals("Result should be " + expectedValue + " But is " + result
				,expectedValue,result);
	}

}
