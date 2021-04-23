package JPATutorial.UpdateEntity;

import JPATutorial.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateWithJPQL {

    public void deleteEntry(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA.Tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = entityManager.find(Student.class, id);
        entityManager.createQuery("UPDATE Student SET name = 'JPQLUpdatedName' WHERE id=:id")
                .executeUpdate();
    }


    public static void main(String args[]){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA.Tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student student = entityManager.find(Student.class, 1);
        entityManager.getTransaction().begin();
        entityManager.createQuery("UPDATE Student SET name = 'JPQLUpdatedName' WHERE id=1")
                .executeUpdate();
        entityManager.getTransaction().commit();
    }
}
