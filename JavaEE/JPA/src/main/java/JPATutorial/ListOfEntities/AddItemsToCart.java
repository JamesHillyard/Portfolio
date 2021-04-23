package JPATutorial.ListOfEntities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AddItemsToCart {

    public static void main(String args[]) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA.Tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Cart cart = new Cart();
        Items item = new Items(cart);
        Items item2 = new Items(cart);


        entityManager.getTransaction().begin();
        entityManager.persist(cart);
        entityManager.persist(item);
        entityManager.persist(item2);
        System.out.println(cart.getCartid());
        System.out.println(item.getId());
        System.out.println(item.getCart().getCartid());
        System.out.println(item2.getId());
        System.out.println(item2.getCart().getCartid());

        List<Items> results = entityManager.createQuery("SELECT Items FROM Cart", Items.class).getResultList();
        System.out.println(results);
        entityManager.getTransaction().commit();

    }
}
