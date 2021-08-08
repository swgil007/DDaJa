package com.bng.ddaja.temp.license;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.bng.ddaja.common.domain.License;

public interface TempLicensesRepository  extends JpaRepository< License, Long >{
    
    public License findById( long id );
    public List<License> findAll();

}
