package DAO.interf;

import java.util.List;

public interface EntityDao<T> {
    void save(T t);

    T findId(int id);

    void update(T t);

    void delete(int id);

    List<T> findAll();

}
