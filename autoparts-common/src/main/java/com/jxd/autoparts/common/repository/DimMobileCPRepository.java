package com.jxd.autoparts.common.repository;

import com.jxd.autoparts.common.entity.DimMobileCPEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DimMobileCPRepository extends JpaRepository<DimMobileCPEntity,Long> {
	
	DimMobileCPEntity findByMobile(String mobile);
	
}
