package a.albertocoscia.dao;

import a.albertocoscia.entities.Location;
import a.albertocoscia.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("Location " + location.getNome() + " correttamente salvata");
    }

    public Location getById(String locationId) {
        Location found = em.find(Location.class, UUID.fromString(locationId));
        if (found == null) throw new NotFoundException(locationId);
        return found;
    }

    public void getByIdAndDelete(String locationId) {
        Location found = getById(locationId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Location " + found.getNome() + " rimossa correttamente");
    }
}
