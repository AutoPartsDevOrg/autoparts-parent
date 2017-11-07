package com.jxd.autoparts.common.repository;

import com.jxd.autoparts.common.entity.PackageInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageInfoRepository  extends JpaRepository<PackageInfoEntity,Long> {
}
