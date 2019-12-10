package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepo extends JpaRepository<CustomEntity, Long> {
}
