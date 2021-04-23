package JPATutorial.Queries;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@SuppressWarnings("unused")
public class JPQLQuery {

    EntityManagerFactory emf;

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * JPA can't deduce what the Query result type will be so we have to cast it.
     */
    public UserEntity getUserByIdWithPlainQuery(int id){
        Query jpqlQuery = getEntityManager().createQuery("SELECT u FROM UserEntity u WHERE u.id=:id");
        jpqlQuery.setParameter("id", id);
        return (UserEntity) jpqlQuery.getSingleResult();

    }

    /**
     *  JPA provides a special Query sub-type known as a TypedQuery. This is always preferred if we know our Query
     *  result type beforehand. Additionally, it makes our code much more reliable and easier to test.
     */
    public UserEntity getUserByIdWithTypedQuery(int id){
        TypedQuery<UserEntity> typedQuery = getEntityManager().createQuery("SELECT u FROM UserEntity u WHERE u.id=:id", UserEntity.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    /**
     * JPA also allows for general queries to be centralised by making a named query on the object itself.
     */
    public UserEntity getUserByIdWithNamedQuery(int id){
        Query namedQuery = getEntityManager().createNamedQuery("UserEntity.findByUserId");
        namedQuery.setParameter("userId", id);
        return (UserEntity) namedQuery.getSingleResult();
    }

    /**
     * A NativeQuery is simply an SQL query. This removes limitations from JPQL syntax
     * but does comes at a cost. We lose database portability of our application with NativeQuery because our JPA provider can't abstract specific details from the database implementation or vendor anymore.
     */

    public UserEntity getUserByIdWithNativeQuery(int id){
        Query nativeQuery = getEntityManager().createNativeQuery("SELECT * FROM users WHERE id=:userId", UserEntity.class);
        nativeQuery.setParameter("userId", id);
        return (UserEntity) nativeQuery.getSingleResult();
    }

    /**
     * Criteria queries are programmatically built, type-safe queries. Allowing you to make dynamic queries
     */
    public UserEntity getUserByIdWithCriteriaQuery(int id) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> userRoot = criteriaQuery.from(UserEntity.class);
        UserEntity queryResult = getEntityManager().createQuery(criteriaQuery.select(userRoot)
                .where(criteriaBuilder.equal(userRoot.get("id"), id)))
                .getSingleResult();
        return queryResult;
    }
}
