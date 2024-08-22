package a.albertocoscia.entities;

import a.albertocoscia.enums.ConcertGenre;
import a.albertocoscia.enums.EventType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "concerti")
public class Concert extends Event {
    @Enumerated(EnumType.STRING)
    private ConcertGenre genere;
    private boolean inStreaming;

    public Concert() {
    }

    public Concert(String titolo, String descrizione, int maxPax, EventType tipo, Location location, ConcertGenre genere, boolean inStreaming) {
        super(titolo, descrizione, maxPax, tipo, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public ConcertGenre getGenere() {
        return genere;
    }

    public void setGenere(ConcertGenre genere) {
        this.genere = genere;
    }

    public boolean isIn_streaming() {
        return inStreaming;
    }

    public void setIn_streaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "eventDetails=" + super.toString() +
                ", genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
