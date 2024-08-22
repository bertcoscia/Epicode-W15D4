package a.albertocoscia;

import a.albertocoscia.dao.EventDAO;
import a.albertocoscia.dao.LocationDAO;
import a.albertocoscia.entities.FootballMatch;
import a.albertocoscia.entities.Location;
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
        Location stadioOlimpicoFromDb = ld.getById("9d7b0dc7-ecf3-4ac3-bd3e-29bf0b7e5015");

        FootballMatch partita1 = new FootballMatch("Roma-Napoli", "Partita di Serie A", 50000, EventType.PUBBLICO, stadioOlimpicoFromDb, "Roma", "Napoli", 1, 3);
        FootballMatch partita1FromDb = ed.findFootballMatchById("b261212b-3a02-4d69-bc52-541401a86c0d");
        partita1FromDb.setVincitore("Napoli");

    }
}
