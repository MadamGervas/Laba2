package map;

import hibernate.Hibernate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public abstract class BaseOperationMap<T> {
    public List<T> findAll() {
        Hibernate hibernate = Hibernate.getInstance();
        EntityManager entityManager = hibernate.getEntityManager();
        TypedQuery<T> typedQuery = entityManager.createNamedQuery(getTableName()+".all", getType());
        List<T> list = typedQuery.getResultList();
        entityManager.close();
        return list;
    }

    public void save(T entity) {
        Hibernate hibernate = Hibernate.getInstance();
        EntityManager entityManager = hibernate.getEntityManager();
        EntityTransaction transaction = hibernate.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
        }
    }

    public void edit(T entity) {
        Hibernate hibernate = Hibernate.getInstance();
        EntityManager entityManager = hibernate.getEntityManager();
        EntityTransaction transaction = hibernate.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
        }
    }

    public void delete(T entity) {
        Hibernate hibernate = Hibernate.getInstance();
        EntityManager entityManager = hibernate.getEntityManager();
        EntityTransaction transaction = hibernate.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
        }
    }

    protected List<T> findByField(String parameter, Object field){
        Hibernate hibernate = Hibernate.getInstance();
        EntityManager entityManager = hibernate.getEntityManager();
        TypedQuery <T> typedQuery = entityManager.createNamedQuery(getTableName()+parameter, getType());
        typedQuery.setParameter(1, field);
        List<T> list = typedQuery.getResultList();
        entityManager.close();
        return list;
    }

    protected abstract Class<T> getType();

    protected abstract String getTableName();
}
