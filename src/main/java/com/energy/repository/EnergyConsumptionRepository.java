package com.energy.repository;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.energy.entity.EnergyDataEntity;

@Repository
public interface EnergyConsumptionRepository extends JpaRepository<EnergyDataEntity, Long>{

	@Query("select distinct(consumptionAmount) from ENERGY_DATA")
	List<String> findByLastUpdatedDate(@Param("date") Date date);
	
}
