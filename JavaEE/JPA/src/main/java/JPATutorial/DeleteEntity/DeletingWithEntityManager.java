package JPATutorial.DeleteEntity;

import JPATutorial.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeletingWithEntityManager {

    public void deleteEntry(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA.Tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    public static void main(String args[]){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA.Tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student student = entityManager.find(Student.class, 52);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(student);
        transaction.commit();
    }
}
