package com.npaw.responseservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npaw.responseservice.entities.TargetDevice;

public interface TargetRepository extends JpaRepository<TargetDevice, Long> {
}
