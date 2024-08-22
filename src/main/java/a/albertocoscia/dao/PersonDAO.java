package a.albertocoscia.dao;

import a.albertocoscia.entities.Person;
import a.albertocoscia.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonDAO {
    private final EntityManager em;

    public PersonDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Person person) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(person);
        transaction.commit();
        System.out.println("Persona " + person.getNome() + person.getCognome() + " correttamente salvata");
    }

    public Person getById(String personId) {
        Person found = em.find(Person.class, UUID.fromString(personId));
        if (found == null) throw new NotFoundException(personId);
        return found;
    }

    public void getByIdAndDelete(String personId) {
        Person found = getById(personId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println(found.getNome() + found.getCognome() + " correttamente rimosso");
    }
}
