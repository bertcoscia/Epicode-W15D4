package a.albertocoscia.entities;

import a.albertocoscia.enums.EventType;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "partita_di_calcio")

@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT fm FROM FootballMatch fm WHERE fm.vincitore = fm.squadra_casa")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT fm FROM FootballMatch fm WHERE fm.vincitore = fm.squadra_ospite")

public class FootballMatch extends Event {
    private String squadra_casa;
    private String squadra_ospite;
    private String vincitore;
    private int gol_casa;
    private int gol_ospite;

    public FootballMatch() {
    }

    public FootballMatch(String titolo, String descrizione, int maxPax, EventType tipo, Location location, String squadra_casa, String squadra_ospite, int gol_casa, int gol_ospite) {
        super(titolo, descrizione, maxPax, tipo, location);
        this.squadra_casa = squadra_casa;
        this.squadra_ospite = squadra_ospite;
        this.vincitore = null;
        this.gol_casa = gol_casa;
        this.gol_ospite = gol_ospite;
    }

    public String getSquadra_casa() {
        return squadra_casa;
    }

    public void setSquadra_casa(String squadra_casa) {
        this.squadra_casa = squadra_casa;
    }

    public String getSquadra_ospite() {
        return squadra_ospite;
    }

    public void setSquadra_ospite(String squadra_ospite) {
        this.squadra_ospite = squadra_ospite;
    }

    public String getVincitore() {
        return vincitore;
    }

    public void setVincitore(String vincitore) {
        this.vincitore = vincitore;
    }

    public int getGol_casa() {
        return gol_casa;
    }

    public void setGol_casa(int gol_casa) {
        this.gol_casa = gol_casa;
    }

    public int getGol_ospite() {
        return gol_ospite;
    }

    public void setGol_ospite(int gol_ospite) {
        this.gol_ospite = gol_ospite;
    }

    @Override
    public String toString() {
        return "FootballMatch{" +
                "eventDetails=" + super.toString() +
                ", squadra_casa='" + squadra_casa + '\'' +
                ", squadra_ospite='" + squadra_ospite + '\'' +
                ", vincitore='" + vincitore + '\'' +
                ", gol_casa=" + gol_casa +
                ", gol_ospite=" + gol_ospite +
                '}';
    }
}
