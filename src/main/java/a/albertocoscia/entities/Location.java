package a.albertocoscia.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String citta;

    @OneToMany(mappedBy = "location")
    private List<Event> listaEventi;

    public Location() {
    }

    public Location(String citta, String nome) {
        this.citta = citta;
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public List<Event> getListaEventi() {
        return listaEventi;
    }

    public void setListaEventi(List<Event> listaEventi) {
        this.listaEventi = listaEventi;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                ", listaEventi=" + listaEventi +
                '}';
    }
}
