package com.mn.springbootsampler.infrastructure.repository;

import com.mn.springbootsampler.model.Event;
import com.mn.springbootsampler.model.repositories.GenericRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Repository
public class EventRepository implements GenericRepository<Event, Integer> {
    private final JpaRepository<Event, Integer> innerRepos;

    @Override
    public Event save(Event in) {
        return innerRepos.save(in);
    }

    @Override
    public Optional<Event> findById(Integer id) {
        return innerRepos.findById(id);
    }

    @Override
    public List<Event> findById() {
        return innerRepos.findAll();
    }
}