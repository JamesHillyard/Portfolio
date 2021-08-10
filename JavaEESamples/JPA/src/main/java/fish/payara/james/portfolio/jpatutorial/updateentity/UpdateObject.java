package fish.payara.james.portfolio.jpatutorial.updateentity;

import fish.payara.james.portfolio.jpatutorial.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateObject {

    public void updateObject(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA.Tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = entityManager.find(Student.class, id);

        entityManager.getTransaction().begin();
        student.setName("UpdatedObject");
        entityManager.getTransaction().commit();
    }

    /**
     * This works by getting the object from the database and modifying it as an object, then committing it again.
     */
    public static void main(String args[]){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA.Tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = entityManager.find(Student.class, 3);

        entityManager.getTransaction().begin();
        student.setName("UpdatedObject");
        entityManager.getTransaction().commit();
    }
}
