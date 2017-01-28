package progettoelle.registrazionevoti.domain;

import java.util.Calendar;

public class Exam extends BaseEntity {
    
    private Course course;
    private Calendar date;
    private String room;
    private String description;
    private boolean bookingOpen;
    
    public Exam() {
        
    }

    public Exam(Course course, Calendar date, String room, String description) {
        this.course = course;
        this.date = date;
        this.room = room;
        this.description = description;
        bookingOpen = false;
    }
    
    public void open() {
        bookingOpen = true;
    }
    
    public void close() {
        bookingOpen = false;
    }

    public Calendar getDate() {
        return date;
    }

    public String getRoom() {
        return room;
    }

    public String getDescription() {
        return description;
    }

    public boolean isBookingOpen() {
        return bookingOpen;
    }
    
    public Course getCourse() {
        return course;
    }
    
    @Override
    public String toString() {
        return course + " " + date.getTime() + " " + room + " " + description; 
    }

}
