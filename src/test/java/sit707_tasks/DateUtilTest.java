package sit707_tasks;

import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "224114235";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Shreya";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testMaxJanuary31ShouldIncrementToFebruary1() {
        // January max boundary area: max+1
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("January31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void testMaxJanuary31ShouldDecrementToJanuary30() {
        // January max boundary area: max-1
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("January31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }

    @Test
    public void testMinJanuary1Should_IncrementToJanuary2() {
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("January1ShouldIncrementtToJanuary2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }

    @Test
    public void testMinJanuary1Should_DecrementToDecember31() {
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("January31ShouldDecrementToDecember31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }
    
    
    @Test
    public void testFebruaryLeapYear_28IncrementToFebruary29() {
        DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("February29ShouldIncrementtToMar1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testFebruaryLeapYear_29DecrementToFebruary28() {
        DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("February29ShouldDecrementToFebruary28 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }


    @Test
    public void testFebruary_NoLeapYear() {
        DateUtil date = new DateUtil(28, 2, 2023);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }
    

    @Test
    public void testMarch31IncrementToApril1() {
        DateUtil date = new DateUtil(31, 3, 2023);
        System.out.println("March31ShouldIncrementtToApril1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(4, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }
    
    @Test
    public void testMarch30DecrementToMarch29() {
        DateUtil date = new DateUtil(31, 3, 2023);
        System.out.println("March30ShouldDecrementtToMarch20 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }
    
    @Test
    public void testApril30DecrementToApril29() {
        DateUtil date = new DateUtil(30, 4, 2023);
        System.out.println("April30ShouldDecrementtToApril29 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(4, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }
    @Test
    public void testApril30IncrementToMay1() {
        DateUtil date = new DateUtil(30, 4, 2023);
        System.out.println("April30ShouldIncrementtToMay1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }
    
    @Test
    public void testMay31DecrementToMay30() {
        DateUtil date = new DateUtil(31, 5, 1990); 
        System.out.println("May31ShouldDecrementtToMay30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(1990, date.getYear());
    }
    @Test
    public void testMay31IncrementToJune1() {
        DateUtil date = new DateUtil(31, 5, 1990); 
        System.out.println("May31ShouldIncrementtToJune1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1990, date.getYear()); 
    }
    @Test
    public void testJune30IncrementToJuly1() {
        DateUtil date = new DateUtil(30, 6, 1990);
        System.out.println("June30ShouldIncrementtToJuly1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(1990, date.getYear());
    }
    @Test
    public void testJune30DecrementToJune29() {
        DateUtil date = new DateUtil(30, 6, 1990);
        System.out.println("June30ShouldDecrementtToJune29 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1990, date.getYear());
    }
    @Test
    public void testJuly31IncrementToAugust1() {
        DateUtil date = new DateUtil(31, 7, 2023);
        System.out.println("July31ShouldIncrementtToAugust1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(8, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }
    @Test
    public void testJuly31DecrementToJuly30() {
        DateUtil date = new DateUtil(31, 7, 2023);
        System.out.println("July31ShouldDecrementtToJuly30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }
    
    @Test
    public void testAugust31IncrementToSeptember1() {
        DateUtil date = new DateUtil(31, 8, 2024);
        System.out.println("August31ShouldIncrementtToSeptember1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(9, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }
    @Test
    public void testAugust31DecrementToAugust30() {
        DateUtil date = new DateUtil(31, 8, 2024);
        System.out.println("August31ShouldDecrementtToAugust30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(8, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }
    
    @Test
    public void testSeptember30IncrementToOctober1() {
        DateUtil date = new DateUtil(30, 9, 2022);
        System.out.println("Sept30ShouldIncrementtToOct1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(10, date.getMonth());
        Assert.assertEquals(2022, date.getYear());
    }
    
    @Test
    public void testSeptember30DecrementToSeptember29() {
        DateUtil date = new DateUtil(30, 9, 2022);
        System.out.println("September30ShouldDecrementtToSeptember29 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(9, date.getMonth());
        Assert.assertEquals(2022, date.getYear());
    }

    @Test
    public void testOctober31IncrementToNovember1() {
        DateUtil date = new DateUtil(31, 10, 2022);
        System.out.println("October1ShouldIncrementToNovember1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(2022, date.getYear());
    }
    
    @Test
    public void testOctober31DecrementToOctober30() {
        DateUtil date = new DateUtil(31, 10, 2022);
        System.out.println("October31ShouldDecrementtToOctober30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(10, date.getMonth());
        Assert.assertEquals(2022, date.getYear());
    }
    
    @Test
    public void testNovember30IncrementToDecember1() {
        DateUtil date = new DateUtil(30, 11, 2024);
        System.out.println("November301ShouldIncrementToDecember1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }
    
    @Test
    public void testNovember30DecrementToNovember29() {
        DateUtil date = new DateUtil(30, 11, 2024);
        System.out.println("November30ShouldDecrementToNovember29 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }
    
    @Test
    public void testDecember31IncrementToJanuary1() {
        DateUtil date = new DateUtil(31, 12, 2024);
        System.out.println("December31ShouldIncrementToJanuary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2025, date.getYear());
    }
    
    @Test
    public void testDecember31DecrementToDecember30() {
        DateUtil date = new DateUtil(31, 12, 2024);
        System.out.println("December31ShouldDecrementToDecember30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }
    
    @Test
    public void testDayEquivalenceClass1To9() {
        // Test from the equivalence class 1-9
        DateUtil date = new DateUtil(5, 6, 2023);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(6, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testDayEquivalenceClass10To20() {
        // Test from the equivalence class 10-20
        DateUtil date = new DateUtil(15, 7, 2023);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testDayEquivalenceClass21To28() {
        // Test from the equivalence class 21-28
        DateUtil date = new DateUtil(25, 8, 2023);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(26, date.getDay());
        Assert.assertEquals(8, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testDayEquivalenceClass29To31() {
        // Test from the equivalence class 29-31
        DateUtil date = new DateUtil(30, 9, 2023);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(9, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testEquivalenceClassMonthsWith30Days() {
        DateUtil date = new DateUtil(15, 4, 2023); // April 15, 2023 (Month with 30 days)
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(4, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testEquivalenceClassMonthsWith31Days() {
        DateUtil date = new DateUtil(20, 5, 2023); // May 20, 2023 (Month with 31 days)
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(19, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testMinimumValidYear() {
        DateUtil date = new DateUtil(1, 1, 1700); // January 1, 1700 (Minimum valid year)
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(1700, date.getYear());
    }

    @Test
    public void testMaximumValidYear() {
        DateUtil date = new DateUtil(31, 12, 2024); // December 31, 2024 (Maximum valid year)
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMinimumValidDate() {
        DateUtil date = new DateUtil(1, 1, 1700); // January 1, 1700 (Minimum valid date)
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(1699, date.getYear());
    }
   

    

}