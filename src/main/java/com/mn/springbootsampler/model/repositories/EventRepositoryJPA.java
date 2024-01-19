package com.mn.springbootsampler.model.repositories;

import com.mn.springbootsampler.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;


@SuppressWarnings("unused")
public interface EventRepositoryJPA extends JpaRepository<Event, Integer> {
}
