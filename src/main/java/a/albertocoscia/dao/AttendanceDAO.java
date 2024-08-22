package a.albertocoscia.dao;

import a.albertocoscia.entities.Attendance;
import a.albertocoscia.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class AttendanceDAO {
    private final EntityManager em;

    public AttendanceDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Attendance attendance) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(attendance);
        transaction.commit();
        System.out.println("Partecipazione " + attendance.getId() + " salvata correttamente");
    }

    public Attendance getById(String attendanceId) {
        Attendance found = em.find(Attendance.class, UUID.fromString(attendanceId));
        if (found == null) throw new NotFoundException(attendanceId);
        return found;
    }

    public void getByIdAndDelete(String attendanceId) {
        Attendance found = getById(attendanceId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Partecipazione " + found.getId() + " eliminata correttamente");
    }
}
