package com.mn.springbootsampler.infrastructure.repository;

import com.mn.springbootsampler.model.Event;
import com.mn.springbootsampler.model.repositories.GenericRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class EventRepository implements GenericRepository<Event, Integer> {
    private final JpaRepository<Event, Integer> innerRepos;

    @Override
    public JpaRepository<Event, Integer> provide() {
        return innerRepos;
    }
}


