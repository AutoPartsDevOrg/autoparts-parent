package com.jxd.autoparts.common.repository;

import com.jxd.autoparts.common.entity.CarBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarBrandRepository extends JpaRepository<CarBrandEntity,Long> {
}
