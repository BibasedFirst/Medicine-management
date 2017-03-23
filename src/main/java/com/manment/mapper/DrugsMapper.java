package com.manment.mapper;


import java.util.List;

import com.manment.bean.Drugs;

public interface DrugsMapper {
  
	//添加药品
	public void insertDrug(Drugs drugs) throws Exception;
	
	//查询药品所有列表
	public List<Drugs> selectDrug() throws Exception;
	
	//更新药品
	public Boolean updateDrugById() throws Exception;
	
	
}

