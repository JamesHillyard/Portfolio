package fish.payara.james.portfolio.arquillian.shopping;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class ShoppingIT {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(Basket.class, Product.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    public Product milk;
    public Product coffee;

    @Before
    public void setUp() {
      milk = new Product("Milk", 1.99);
      coffee = new Product("Coffee", 1.59);
    }

    @Inject
    Basket basket;

    @Test
    public void basketInjectTest(){
        assertNotNull(basket);
        assertEquals(0, basket.getBasketSize());
    }

    @Test
    public void addToBasketTest(){
        basket.addItem(milk, 2);
        basket.addItem(coffee, 3);
        assertEquals(2, basket.getBasketSize());
        assertEquals(Integer.getInteger("2"), basket.getBasket().get("Milk"));
        assertEquals(8.75, basket.getTotal(), 0);
    }
}
