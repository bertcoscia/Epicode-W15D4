package a.albertocoscia.entities;

import a.albertocoscia.enums.ConcertGenre;
import a.albertocoscia.enums.EventType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "concerti")
public class Concert extends Event {
    private ConcertGenre genere;
    private boolean in_streaming;

    public Concert() {
    }

    public Concert(String titolo, String descrizione, int maxPax, EventType tipo, Location location, ConcertGenre genere, boolean in_streaming) {
        super(titolo, descrizione, maxPax, tipo, location);
        this.genere = genere;
        this.in_streaming = in_streaming;
    }

    public ConcertGenre getGenere() {
        return genere;
    }

    public void setGenere(ConcertGenre genere) {
        this.genere = genere;
    }

    public boolean isIn_streaming() {
        return in_streaming;
    }

    public void setIn_streaming(boolean in_streaming) {
        this.in_streaming = in_streaming;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "eventDetails=" + super.toString() +
                ", genere=" + genere +
                ", in_streaming=" + in_streaming +
                '}';
    }
}
