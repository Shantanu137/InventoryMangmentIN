package com.IMS.GKK.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IMS.GKK.model.Income;
@Repository
public interface IncomeRepositery extends JpaRepository<Income,Long> {

	public Income findBypname(String pname);

}
