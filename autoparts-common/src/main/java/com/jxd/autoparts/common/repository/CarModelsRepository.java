package com.jxd.autoparts.common.repository;

import com.jxd.autoparts.common.entity.CarModelsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelsRepository extends JpaRepository<CarModelsEntity,Long> {
}
