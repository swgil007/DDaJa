package com.bng.ddaja.licenses.repository;

import java.util.List;

import com.bng.ddaja.common.domain.License;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LicensesRepository extends JpaRepository<License, Long>{
    public List<License> findAll();
}
