package com.bng.ddaja.licenses.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

import com.bng.ddaja.common.domain.License;

public interface LicensesRepository  extends JpaRepository< License, Long >, JpaSpecificationExecutor< License >{  
    public License findById( long id );
}
