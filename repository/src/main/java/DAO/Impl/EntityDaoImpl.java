package DAO.Impl;

import DAO.interf.EntityDao;
import Utils.EntityFactoryManager;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.util.List;


public class EntityDaoImpl<T> implements EntityDao<T> {

    private EntityManager em;

    private Class<T> tClass;

    public EntityDaoImpl(Class<T> tClass) {
        this.tClass = tClass;
    }

    public void save(T t) {
        em = EntityFactoryManager.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(t);
            em.getTransaction().commit();
        } catch (HibernateException e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public T findId(int id) {
        em = EntityFactoryManager.getEntityManager();
        T entity = null;
        try {
            entity = em.find(tClass, id);
        } catch (HibernateException e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return entity;
    }

    public void update(T t) {
        em = EntityFactoryManager.getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(t);
            em.getTransaction().commit();
        } catch (HibernateException e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        em = EntityFactoryManager.getEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(em.find(tClass, id));
            em.getTransaction().commit();
        } catch (HibernateException e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<T> findAll() {
        em = EntityFactoryManager.getEntityManager();
        List<T> resultList = em.createQuery("from " + tClass.getName()).getResultList();
        return resultList;
    }

}
