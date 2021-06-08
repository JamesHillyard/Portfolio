package fish.payara.james.portfolio.jpatutorial.inserting;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class SimpleJPAUse {

    public static void main(String args[]){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA.Tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        SimpleStudent student = new SimpleStudent();
        student.setId(9);
        student.setName("James");
        student.setAge(19);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(student);
        transaction.commit();
    }


}
