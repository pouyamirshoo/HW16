package base.repository;

import base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Optional;

public interface BaseRepository <T extends BaseEntity<ID>,ID extends Serializable> {

    T saveOrUpdate(T entity);
    Optional<T> findById(ID id);
    void delete(T entity);
    Optional<T> findByUsername(String username);
    Optional<T> findByUsernameAndPassword(String username,String password);
}
