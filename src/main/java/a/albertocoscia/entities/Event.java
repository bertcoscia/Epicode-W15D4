package a.albertocoscia.entities;

import a.albertocoscia.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
//@Table(name = "events")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Event {
    @Id
    @GeneratedValue
    private UUID id;
    private String titolo;
    private LocalDate data;
    private String descrizione;
    private int maxPax;
    @Enumerated(EnumType.STRING)
    private EventType tipo;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public Event() {
    }

    public Event(String titolo, String descrizione, int maxPax, EventType tipo, Location location) {
        this.titolo = titolo;
        this.data = LocalDate.now();
        this.descrizione = descrizione;
        this.maxPax = maxPax;
        this.tipo = tipo;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getMaxPax() {
        return maxPax;
    }

    public void setMaxPax(int maxPax) {
        this.maxPax = maxPax;
    }

    public EventType getTipo() {
        return tipo;
    }

    public void setTipo(EventType tipo) {
        this.tipo = tipo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data=" + data +
                ", descrizione='" + descrizione + '\'' +
                ", maxPax=" + maxPax +
                ", tipo=" + tipo +
                //", location=" + location +
                '}';
    }
}
