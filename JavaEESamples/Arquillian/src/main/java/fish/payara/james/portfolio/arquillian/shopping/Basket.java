package fish.payara.james.portfolio.arquillian.shopping;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import java.util.HashMap;
import java.util.Map;

@Dependent
public class Basket {
    Map<Product, Integer> basket;

    @PostConstruct
    public void init(){
        basket = new HashMap<>();
    }

    public void addItem(Product product, Integer quantity){
        basket.put(product, quantity);
    }

    public Map<Product, Integer> getBasket() {
        return basket;
    }

    public int getBasketSize(){
        return basket.size();
    }

    public double getTotal(){
        return basket.keySet().stream().mapToDouble(product -> (product.price * basket.get(product))).sum();
    }
}
