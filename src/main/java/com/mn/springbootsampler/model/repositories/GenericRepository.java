package com.mn.springbootsampler.model.repositories;

import com.mn.springbootsampler.model.IdentifiedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T extends IdentifiedEntity, K> {

    JpaRepository<T,K> provide();

    default T save(T in){
        return provide().save(in);
    }

    default Optional<T> findById(K id){
        return provide().findById(id);
    }

    default List<T> findAll(){
        return provide().findAll();
    }


}
