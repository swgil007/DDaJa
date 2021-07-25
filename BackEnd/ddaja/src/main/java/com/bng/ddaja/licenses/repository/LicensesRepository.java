package com.bng.ddaja.licenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bng.ddaja.common.domain.License;

public interface LicensesRepository  extends JpaRepository< License, Long >{
    public License findById( long lid );
}
