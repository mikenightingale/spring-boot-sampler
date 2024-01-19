package com.mn.springbootsampler.model.repositories;

import com.mn.springbootsampler.model.IdentifiedEntity;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T extends IdentifiedEntity, K> {
    T save(T in);

    Optional<T> findById(K id);

    List<T> findById();
}
