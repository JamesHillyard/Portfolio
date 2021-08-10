package fish.payara.james.portfolio.jpatutorial.inserting;

import fish.payara.james.portfolio.jpatutorial.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JPAUse {

    public static void main(String args[]){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA.Tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student student = new Student();
        student.setName("James");
        student.setAge(19);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(student);
        transaction.commit();
    }


}
