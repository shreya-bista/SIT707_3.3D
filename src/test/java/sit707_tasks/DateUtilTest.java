package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "224114235";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "shreya";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(01, 1, 2024);
		System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(02, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(01, 1, 2024);
		System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	// Test Cases for Day:
	// D1: 1, M30, Non-Leap Year

	@Test
	public void testD1M30NonLeapYearDecrement() {
		DateUtil date = new DateUtil(1, 04, 2023);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(03, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testD1M30NonLeapYearIncrement() {
		DateUtil date = new DateUtil(1, 04, 2023);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(02, date.getDay());
		Assert.assertEquals(04, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	// D2: 29, Feb, Leap Year
	@Test
	public void testD2FebLeapYearDecrement() {
		DateUtil date = new DateUtil(29, 02, 2024);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(28, date.getDay());
		Assert.assertEquals(02, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testD2FebLeapYearIncrement() {
		DateUtil date = new DateUtil(29, 02, 2024);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(01, date.getDay());
		Assert.assertEquals(03, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	// D3: 30, M30, Non-Leap Year
	@Test
	public void testD3M30NonLeapYearDecrement() {
		DateUtil date = new DateUtil(30, 06, 2023);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(06, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testD3M30NonLeapYearIncrement() {
		DateUtil date = new DateUtil(30, 06, 2023);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(01, date.getDay());
		Assert.assertEquals(07, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}
	// D4: 31, M31, Leap Year
	@Test
	public void testD4M31LeapYearDecrement() {
		DateUtil date = new DateUtil(31, 01, 2024);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(01, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testD4M31LeapYearIncrement() {
		DateUtil date = new DateUtil(31, 01, 2024);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(01, date.getDay());
		Assert.assertEquals(02, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	// Test Cases for Month:
	// M30: 30, D1, Non-Leap Year
	@Test
    public void testM30D1NonLeapYearIncrement() {
        DateUtil date = new DateUtil(30, 4, 2023); // April 30, 2023 (Non-Leap Year)
        date.increment(); // Increment to next day
		System.out.println(date);
		Assert.assertEquals(01, date.getDay());
		Assert.assertEquals(05, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
    }

	
    @Test
    public void testM30D1NonLeapYearDecrement() {
        DateUtil date = new DateUtil(1, 5, 2023); // May 1, 2023 (Non-Leap Year)
        date.decrement(); // Decrement to previous day
		System.out.println(date);
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(04, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
    }

	// M31: 31, D4, Leap Year

    @Test
    public void testM31D4LeapYearIncrement() {
        DateUtil date = new DateUtil(31, 12, 2024); // December 31, 2024 (Leap Year)
        date.increment(); // Increment to next day
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(01, date.getMonth());
		Assert.assertEquals(2025, date.getYear());
    }

    @Test
    public void testM31D4LeapYearDecrement() {
        DateUtil date = new DateUtil(1, 1, 2021); // January 1, 2025 (Leap Year)
        date.decrement(); // Decrement to previous day
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2020, date.getYear());
    }

	// Feb: 28, D1, Non-Leap Year; 
	@Test
    public void testFeb28NonLeapYearIncrement() {
        DateUtil date = new DateUtil(28, 2, 2023); // February 28, 2023 (Non-Leap Year)
        date.increment(); // Increment to next day
		System.out.println(date);
		Assert.assertEquals(01, date.getDay());
		Assert.assertEquals(03, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
    }

	@Test
    public void testFeb28NonLeapYearDecrement() {
        DateUtil date = new DateUtil(1, 3, 2023); // March 1, 2023 (Non-Leap Year)
        date.decrement(); // Decrement to previous day
		System.out.println(date);
		Assert.assertEquals(28, date.getDay());
		Assert.assertEquals(02, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
    }

   
	// 29, D2, Leap Year

    @Test
    public void testFeb29LeapYearIncrement() {
        DateUtil date = new DateUtil(29, 2, 2024); // February 29, 2024 (Leap Year)
        date.increment(); // Increment to next day
		System.out.println(date);
		Assert.assertEquals(01, date.getDay());
		Assert.assertEquals(03, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
    }

	@Test
    public void testFeb29LeapYearDecrement() {
        DateUtil date = new DateUtil(1, 3, 2024); // March 1, 2024 (Leap Year)
        date.decrement(); // Decrement to previous day
        Assert.assertEquals("Expected date after decrement", "29 February 2024", date.toString());
		System.out.println(date);
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(02, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
    }


	// Boundary Test Cases:
	// Day 1, Month 1, Year 1700 (Minimum valid input)
	// Day 31, Month 12, Year 2024 (Maximum valid input)

	@Test
    public void testMinimumValidInputIncrement() {
        DateUtil date = new DateUtil(1, 1, 1700); // January 1, 1700
        date.increment(); // Increment to next day
		System.out.println(date);
		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(01, date.getMonth());
		Assert.assertEquals(1700, date.getYear());
    }

    @Test
    public void testMaximumValidInputIncrement() {
        DateUtil date = new DateUtil(31, 12, 2024); // December 31, 2024
        date.increment(); // Increment to next day
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(01, date.getMonth());
		Assert.assertEquals(2025, date.getYear());
    }

    // Boundary Test Cases for Decrement

    @Test
    public void testMinimumValidInputDecrement() {
        DateUtil date = new DateUtil(1, 1, 1700); // January 1, 1700
        date.decrement(); // Decrement to previous day
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(1699, date.getYear());
    }

    @Test
    public void testMaximumValidInputDecrement() {
        DateUtil date = new DateUtil(31, 12, 2024); // December 31, 2024
        date.decrement(); // Decrement to previous day
		System.out.println(date);
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
    }
}

