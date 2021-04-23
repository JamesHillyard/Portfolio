package JPATutorial.ListOfEntities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Cartid;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private Set<Items> items;

    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }

    public int getCartid() {
        return Cartid;
    }

    public void setCartid(int cartid) {
        Cartid = cartid;
    }
}
