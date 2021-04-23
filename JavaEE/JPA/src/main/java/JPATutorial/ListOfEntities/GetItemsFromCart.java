package JPATutorial.ListOfEntities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Set;

public class GetItemsFromCart {

    public static void main(String args[]){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA.Tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Cart cart = entityManager.find(Cart.class, 302);
        Set<Items> cartContents = cart.getItems();
        cartContents.stream().forEach(s -> System.out.println(s.getName()));
    }
}
