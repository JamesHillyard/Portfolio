package fish.payara.james.portfolio.jpatutorial.deleteentity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeletingWithJPQL {

    public void deleteEntry(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA.Tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.createQuery("DELETE FROM Student WHERE id=:id")
                .setParameter("id", 1)
                .executeUpdate();
    }


    public static void main(String args[]){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA.Tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.createQuery("DELETE FROM Student WHERE id=:id")
                .setParameter("id", 102)
                .executeUpdate();
        transaction.commit();
    }
}
