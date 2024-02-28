package com.utpal.ReactAssignment.Repository;

import com.utpal.ReactAssignment.Entity.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosRepository extends JpaRepository<Todos, Long> {
}
