package com.mac.Ciclo3.repositorios;

import com.mac.Ciclo3.repositorios.interfaces.InterfaceGenerica;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class RepositorioGenericoAbstracto<T, ID extends Serializable> implements InterfaceGenerica<T, ID> {

    public abstract CrudRepository<T, ID> getDao();

    @Override
    public List<T> obtenerTodos() {
        return (List<T>) getDao().findAll();
    }

    @Override
    public Optional<T> obtenerXId(ID id) {
        return getDao().findById(id);
    }

    @Override
    public T guardar(T objecto) {
        return getDao().save(objecto);
    }

    @Override
    public void eliminar(ID id) {
        getDao().deleteById(id);
    }
}
