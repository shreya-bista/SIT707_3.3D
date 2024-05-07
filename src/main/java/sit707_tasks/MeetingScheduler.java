package sit707_tasks;

import java.util.ArrayList;
import java.util.List;

public class MeetingScheduler {

    private List<Meeting> meetings;

    public MeetingScheduler() {
        this.meetings = new ArrayList<>();
    }

    public void scheduleMeeting(DateUtil date, String description) {
        Meeting meeting = new Meeting(date, description);
        if (isAvailable(date)) {
            meetings.add(meeting);
        } else {
            throw new IllegalArgumentException("Conflict: Another meeting already scheduled for " + date);
        }
    }

    public void postponeMeeting(DateUtil originalDate, DateUtil newDate) {
        // Check if the original date is scheduled for a meeting
        boolean found = false;
        for (Meeting meeting : meetings) {
            if (meeting.getDate().equals(originalDate)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("No meeting found on the original date: " + originalDate);
        }

        // Check if the new date is available
        if (!isAvailable(newDate)) {
            throw new IllegalArgumentException("Conflict: Another meeting already scheduled for " + newDate);
        }

        // Update the meeting date
        for (Meeting meeting : meetings) {
            if (meeting.getDate().equals(originalDate)) {
                meeting.setDate(newDate);
                break;
            }
        }
    }

    public boolean isAvailable(DateUtil date) {
        for (Meeting meeting : meetings) {
            System.out.println(meeting.getDate().toString());
            System.out.println(date.toString());
            if (meeting.getDate().toString().equals(date.toString())) {
                return false;
            }
        }
        return true;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public static class Meeting {
        private DateUtil date;
        private String description;

        public Meeting(DateUtil date, String description) {
            this.date = date;
            this.description = description;
        }

        public DateUtil getDate() {
            return date;
        }

        public String getDescription() {
            return description;
        }

        public void setDate(DateUtil date) {
            this.date = date;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        
    }
}
