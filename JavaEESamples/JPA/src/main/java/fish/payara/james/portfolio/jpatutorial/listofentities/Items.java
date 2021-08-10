package fish.payara.james.portfolio.jpatutorial.listofentities;

import javax.persistence.*;

@Entity
@Table(name = "Items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "Cartid")
    private Cart cart;

    public Items(Cart c){
        this.cart = c;
    }

    /**
     * Hibernate needs a no args constructor
     */
    public Items() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
