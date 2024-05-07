package sit707_tasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MeetingSchedulerTest {

    @Test
    public void testScheduleMeeting() {
        MeetingScheduler scheduler = new MeetingScheduler();
        DateUtil date1 = new DateUtil(15, 5, 2024);
        DateUtil date2 = new DateUtil(15, 5, 2024);
        scheduler.scheduleMeeting(date1, "Meeting 1");
        assertThrows(IllegalArgumentException.class, () -> scheduler.scheduleMeeting(date2, "Meeting 2"));
    }

    @Test
    public void testIsAvailable() {
        MeetingScheduler scheduler = new MeetingScheduler();
        DateUtil date1 = new DateUtil(15, 5, 2024);
        DateUtil date2 = new DateUtil(16, 5, 2024);
        scheduler.scheduleMeeting(date1, "Meeting 1");
        assertTrue(scheduler.isAvailable(date2));
        assertFalse(scheduler.isAvailable(date1));
    }

    @Test
    public void testGetMeetings() {
        MeetingScheduler scheduler = new MeetingScheduler();
        DateUtil date1 = new DateUtil(15, 5, 2024);
        DateUtil date2 = new DateUtil(16, 5, 2024);
        scheduler.scheduleMeeting(date1, "Meeting 1");
        scheduler.scheduleMeeting(date2, "Meeting 2");
        assertEquals(2, scheduler.getMeetings().size());
    }

    @Test
    public void testConflictForBoundaryValue() {
        MeetingScheduler scheduler = new MeetingScheduler();
        DateUtil date1 = new DateUtil(1, 1, 2024); // Boundary: 1st Jan 2024
        DateUtil date2 = new DateUtil(1, 1, 2024); // Boundary: 1st Jan 2024
        scheduler.scheduleMeeting(date1, "Meeting 1");
        assertThrows(IllegalArgumentException.class, () -> scheduler.scheduleMeeting(date2, "Meeting 2"));
    }

    @Test
    public void testConflictForEquivalenceClass() {
        MeetingScheduler scheduler = new MeetingScheduler();
        DateUtil date1 = new DateUtil(15, 5, 2024); // Valid date
        DateUtil date2 = new DateUtil(15, 5, 2024); // Valid date
        scheduler.scheduleMeeting(date1, "Meeting 1");
        assertThrows(IllegalArgumentException.class, () -> scheduler.scheduleMeeting(date2, "Meeting 2"));
    }

    @Test
    public void testConflictForLeapYear() {
        MeetingScheduler scheduler = new MeetingScheduler();
        DateUtil date1 = new DateUtil(29, 2, 2024); // Leap year
        DateUtil date2 = new DateUtil(29, 2, 2024); // Leap year
        scheduler.scheduleMeeting(date1, "Meeting 1");
        assertThrows(IllegalArgumentException.class, () -> scheduler.scheduleMeeting(date2, "Meeting 2"));
    }

    @Test
    public void testPostponeMeeting() {
        MeetingScheduler scheduler = new MeetingScheduler();
        DateUtil date1 = new DateUtil(15, 5, 2024);
        scheduler.scheduleMeeting(date1, "Meeting 1");
        DateUtil originalDate = scheduler.getMeetings().get(0).getDate();
        DateUtil newDate = new DateUtil(16, 5, 2024);
        scheduler.postponeMeeting(originalDate, newDate);
        assertEquals(newDate, scheduler.getMeetings().get(0).getDate());
    }

    @Test
    public void testPostponeLeapYearForward() {
        MeetingScheduler scheduler = new MeetingScheduler();
        DateUtil date1 = new DateUtil(29, 2, 2024); // Leap year
        scheduler.scheduleMeeting(date1, "Meeting 1");
        DateUtil originalDate = scheduler.getMeetings().get(0).getDate();
        DateUtil newDate = new DateUtil(1, 3, 2024); // Leap year
        scheduler.postponeMeeting(originalDate, newDate);
        assertEquals(newDate, scheduler.getMeetings().get(0).getDate());
    }

    @Test
    public void testPostponeLeapYearBackward() {
        MeetingScheduler scheduler = new MeetingScheduler();
        DateUtil date1 = new DateUtil(1, 3, 2024); // Leap year
        scheduler.scheduleMeeting(date1, "Meeting 1");
        DateUtil originalDate = scheduler.getMeetings().get(0).getDate();
        DateUtil newDate = new DateUtil(29, 2, 2024); // Leap year
        scheduler.postponeMeeting(originalDate, newDate);
        assertEquals(newDate, scheduler.getMeetings().get(0).getDate());
    }

    @Test
    public void testPostponeNewYearForward() {
        MeetingScheduler scheduler = new MeetingScheduler();
        DateUtil date1 = new DateUtil(31, 12, 2023); // Before new year
        scheduler.scheduleMeeting(date1, "Meeting 1");
        DateUtil originalDate = scheduler.getMeetings().get(0).getDate();
        DateUtil newDate = new DateUtil(1, 1, 2024); // New year
        scheduler.postponeMeeting(originalDate, newDate);
        assertEquals(newDate, scheduler.getMeetings().get(0).getDate());
    }

    @Test
    public void testPostponeNewYearBackward() {
        MeetingScheduler scheduler = new MeetingScheduler();
        DateUtil date1 = new DateUtil(1, 1, 2024); // New year
        scheduler.scheduleMeeting(date1, "Meeting 1");
        DateUtil originalDate = scheduler.getMeetings().get(0).getDate();
        DateUtil newDate = new DateUtil(31, 12, 2023); // Before new year
        scheduler.postponeMeeting(originalDate, newDate);
        assertEquals(newDate, scheduler.getMeetings().get(0).getDate());
    }

}
