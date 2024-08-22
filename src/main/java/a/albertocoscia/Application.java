package a.albertocoscia;

import a.albertocoscia.dao.EventDAO;
import a.albertocoscia.dao.LocationDAO;
import a.albertocoscia.entities.AthleticCompetition;
import a.albertocoscia.entities.Concert;
import a.albertocoscia.entities.Location;
import a.albertocoscia.entities.Person;
import a.albertocoscia.enums.ConcertGenre;
import a.albertocoscia.enums.EventType;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Epicode-W15D4");

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Faker faker = new Faker();

        EntityManager em = emf.createEntityManager();
        EventDAO ed = new EventDAO(em);
        LocationDAO ld = new LocationDAO(em);

        Location stadioOlimpico = new Location("Roma", "Stadio Olimpico");
        Location rockEnSeine = new Location("Paris", "Rock en Seine");
        Location teatroBolshoi = new Location("Moscow", "Teatro Bol'šoj");
        Location stadioDAM = new Location("Napoli", "Stadio Diego Armando Maradona");
        Location stadioOlimpicoFromDb = ld.getById("ed81bdf2-ba78-4da7-a500-b98ab10c5799");
        Location rockEnSeineFromDb = ld.getById("6f7b2bf1-7cf0-4908-8589-9a765917ce0c");
        Location teatroBolshoiFromDb = ld.getById("dab7a78a-22b0-4b91-afc3-81b1f101dc23");
        Location stadioDAMFromDb = ld.getById("7551f0ef-b934-45b8-9775-cbe95609bc91");

        /*FootballMatch partita1 = new FootballMatch("Roma-Napoli", "Partita di Serie A", 50000, EventType.PUBBLICO, stadioOlimpicoFromDb, "Roma", "Napoli", 1, 3);
        partita1.setVincitore("Napoli");
        FootballMatch partita2 = new FootballMatch("Napoli - Juventus", "Partita di Serie A", 45000, EventType.PUBBLICO, stadioDAMFromDb, "Napoli", "Juventus", 1, 0);
        partita2.setVincitore("Napoli");
        FootballMatch partita3 = new FootballMatch("Lazio-Roma", "Partita di Serie A", 50000, EventType.PUBBLICO, stadioOlimpicoFromDb, "Lazio", "Roma", 2, 2);*/
        //ed.save(partita1);
        //ed.save(partita2);
        //ed.save(partita3);

        Concert concerto1 = new Concert("Concerto Fred Again..", "Musica bella", 15000, EventType.PUBBLICO, rockEnSeineFromDb, ConcertGenre.POP, false);
        Concert concerto2 = new Concert("Concerto U2", "Musica molto, molto bella", 65000, EventType.PUBBLICO, stadioOlimpicoFromDb, ConcertGenre.ROCK, true);
        Concert concerto3 = new Concert("Concerto Orchestra Imperiale", "Musica wow", 100, EventType.PRIVATO, teatroBolshoiFromDb, ConcertGenre.CLASSICO, false);
        //ed.save(concerto1);
        //ed.save(concerto2);
        //ed.save(concerto3);

        Person sergioMattare
    }
}
