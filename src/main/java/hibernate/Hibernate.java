package hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class Hibernate {
    private static Hibernate instance;
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static EntityTransaction transaction;

    private Hibernate() {}

    private static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        Hibernate.entityManagerFactory = entityManagerFactory;
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null)
            entityManagerFactory = Persistence.createEntityManagerFactory("default");
        return entityManagerFactory;
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen())
            entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    public EntityTransaction getTransaction() {
        if (transaction == null || !transaction.isActive())
            transaction = entityManager.getTransaction();
        return transaction;
    }

    public static Hibernate getInstance(){
        if (instance == null){
            instance = new Hibernate();
            instance.setEntityManagerFactory(Persistence.createEntityManagerFactory("default"));
        }
        return  instance;
    }
}
