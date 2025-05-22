package com.shubham.braindump.repository;

import com.shubham.braindump.entity.Thought;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThoughtRepository extends JpaRepository<Thought, Long> {

    // Custom query methods can be defined here if needed
    // For example, to find thoughts by tag:
    // List<Thought> findByTag(Tag tag);
}
