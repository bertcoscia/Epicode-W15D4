package a.albertocoscia.dao;

import a.albertocoscia.entities.AthleticCompetition;
import a.albertocoscia.entities.Concert;
import a.albertocoscia.entities.Event;
import a.albertocoscia.entities.FootballMatch;
import a.albertocoscia.enums.ConcertGenre;
import a.albertocoscia.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EventDAO {
    private final EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("Evento " + event.getTitolo() + " salvato correttamente");
    }

    public Event getById(String eventId) {
        Event found = em.find(Event.class, UUID.fromString(eventId));
        if (found == null) throw new NotFoundException(eventId);
        return found;
    }

    public void getByIdAndDelete(String eventId) {
        Event found = getById(eventId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Evento " + found.getTitolo() + " eliminato correttamente");
    }

    public FootballMatch findFootballMatchById(String footballMatchId) {
        FootballMatch found = em.find(FootballMatch.class, UUID.fromString(footballMatchId));
        if (found == null) throw new NotFoundException(footballMatchId);
        return found;
    }

    public List<FootballMatch> findAllFootballMatches() {
        TypedQuery<FootballMatch> query = em.createQuery("SELECT fm FROM FootballMatch fm", FootballMatch.class);
        return query.getResultList();
    }

    public List<Concert> findAllConcertsInStreaming(boolean condition) {
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c WHERE c.inStreaming = :condition", Concert.class);
        query.setParameter("condition", condition);
        return query.getResultList();
    }

    public Map<ConcertGenre, List<Concert>> findConcertByGenre(ConcertGenre genre) {
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c WHERE c.genere = :genre", Concert.class);
        query.setParameter("genre", genre);
        List<Concert> resultList = query.getResultList();
        Map<ConcertGenre, List<Concert>> resultMap = new HashMap<ConcertGenre, List<Concert>>();
        resultMap.put(genre, resultList);
        return resultMap;
    }

    /*public List<Concert> findConcertByGenre(ConcertGenre genre) {
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c WHERE c.genre = :genre", Concert.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }*/

    public List<FootballMatch> getPartiteVinteInCasa() {
        TypedQuery<FootballMatch> query = em.createNamedQuery("getPartiteVinteInCasa", FootballMatch.class);
        return query.getResultList();
    }

    public List<FootballMatch> getPartiteVinteInTrasferta() {
        TypedQuery<FootballMatch> query = em.createNamedQuery("getPartiteVinteInTrasferta", FootballMatch.class);
        return query.getResultList();
    }

    public List<FootballMatch> getPartitePareggiate() {
        TypedQuery<FootballMatch> query = em.createNamedQuery("getPartitePareggiate", FootballMatch.class);
        return query.getResultList();
    }

    public AthleticCompetition findCompetitionById(String competitionId) {
        AthleticCompetition found = em.find(AthleticCompetition.class, UUID.fromString(competitionId));
        if (found == null) throw new NotFoundException(competitionId);
        return found;
    }
}
