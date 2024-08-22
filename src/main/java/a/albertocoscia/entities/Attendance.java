package a.albertocoscia.entities;

import a.albertocoscia.enums.AttendanceState;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazioni")

public class Attendance {
    @Id
    @GeneratedValue
    private UUID id;
    @Enumerated(EnumType.STRING)
    private AttendanceState stato;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    public Attendance() {
    }

    public Attendance(AttendanceState stato, Person person, Event event) {
        this.stato = stato;
        this.person = person;
        this.event = event;
    }

    public UUID getId() {
        return id;
    }

    public AttendanceState getStato() {
        return stato;
    }

    public void setStato(AttendanceState stato) {
        this.stato = stato;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", stato=" + stato +
                ", person=" + person +
                ", event=" + event +
                '}';
    }
}
