package ftn.corner.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public abstract class CrudService<T> {

    protected abstract JpaRepository<T, Long> getEntityRepository();

    //.filter(User.class::isInstance).map(User.class::cast)
    public List<T> findAll() {
        return (List<T>) getEntityRepository().findAll();
    }

    public T findOne(Long id) {
        return getEntityRepository().findById(id).orElseThrow(() -> new RuntimeException("Cannot find entity with id: " + id));
    }

    public T save(T entity) {
        return getEntityRepository().save(entity);
    }

    public List<T> saveAll(Collection<T> entities) {
        return getEntityRepository().saveAll(entities);
    }

    public T update(T entity) {
        return save(entity);
    }

    public void delete(Long id) {
        getEntityRepository().delete(findOne(id));
    }

}
