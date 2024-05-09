package com.example.demo.repos;

import com.example.demo.model.Runner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RunnerRepository extends JpaRepository<Runner, Integer> {
    boolean existsByEmail(String email);
    @Override
    boolean existsById(Integer integer);
    List<Runner> findRunnersById(Integer integer);
    List<Runner> findByEmail(String email);
    List<Runner> findByName(String name);
    @Query("select max(r.id) from Runner r")
    Integer findMaxId();
}
