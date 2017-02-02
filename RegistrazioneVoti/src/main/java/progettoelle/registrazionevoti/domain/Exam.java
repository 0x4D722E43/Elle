package progettoelle.registrazionevoti.domain;

import java.util.Calendar;

/**
 * Exam è caratterizzato da data, aula e descrizione
 * può essere aperto alle iscrizioni o meno
 * è  legato a uno e un solo corso
 * 
 * @author mrc
 */
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
    
    public void openBookings() {
        bookingOpen = true;
    }
    
    public void closeBookings() {
        bookingOpen = false;
    }
    
    public Course getCourse() {
        return course;
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
    
    @Override
    public String toString() {
        return "Exam { " + getId() + " } ";
    }
    
}
