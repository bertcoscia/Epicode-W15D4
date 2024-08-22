package a.albertocoscia.entities;

import a.albertocoscia.enums.EventType;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gare_di_atletica")
public class AthleticCompetition extends Event {

    @ManyToOne
    @JoinColumn(name = "vincitore_id", nullable = false)
    private Person vincitore;

    @OneToMany(mappedBy = "athleticCompetition")
    private Set<Person> setAtleti = new HashSet<>();

    public AthleticCompetition() {
    }

    public AthleticCompetition(String titolo, String descrizione, int maxPax, EventType tipo, Location location, Person vincitore) {
        super(titolo, descrizione, maxPax, tipo, location);
        this.vincitore = vincitore;
        this.setAtleti = new HashSet<>();
    }

    public Person getVincitore() {
        return vincitore;
    }

    public void setVincitore(Person vincitore) {
        this.vincitore = vincitore;
    }

    public Set<Person> getSetAtleti() {
        return setAtleti;
    }

    public void setSetAtleti(Set<Person> setAtleti) {
        this.setAtleti = setAtleti;
    }

    public void addAtleta(Person atleta) {
        this.setAtleti.add(atleta);
    }

    public void addAtleti(Set<Person> atleti) {
        this.setAtleti.addAll(atleti);
    }

    public void removeAtleta(Person atleta) {
        this.setAtleti.remove(atleta);
    }

    @Override
    public String toString() {
        return "AthleticCompetition{" +
                "eventDetails=" + super.toString() +
                ", vincitore=" + vincitore +
                ", setAtleti=" + setAtleti +
                '}';
    }
}
