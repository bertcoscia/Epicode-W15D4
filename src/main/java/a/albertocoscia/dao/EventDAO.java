package a.albertocoscia.dao;

import a.albertocoscia.entities.Concert;
import a.albertocoscia.entities.Event;
import a.albertocoscia.entities.FootballMatch;
import a.albertocoscia.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
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
}
