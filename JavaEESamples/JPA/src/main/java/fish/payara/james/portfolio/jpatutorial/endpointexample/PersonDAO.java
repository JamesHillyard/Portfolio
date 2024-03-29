package fish.payara.james.portfolio.jpatutorial.endpointexample;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getAll() {
        return entityManager.createNamedQuery("Person.getAll", Person.class).getResultList();
    }

    public Person find(Long id) {
        return entityManager.createNamedQuery("Person.findOne", Person.class).setParameter("id", id).getSingleResult();
    }

    public void save(Person person) {
        entityManager.persist(person);
    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public void delete(Person person) {
        entityManager.remove(person);
    }


}
