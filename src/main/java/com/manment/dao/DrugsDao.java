package com.manment.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.manment.bean.Drugs;
import com.manment.config.SqlSessionUtil;
import com.manment.mapper.DrugsMapper;

public class DrugsDao {

	
	public static void main(String[] args) throws Exception {
		/*Drugs d = new Drugs("云南白药",155,15,new Date(),new Date(),15,17,98);
		insertDrugs(d);*/
		System.out.println(selectDrug());
	}
	
	public static Boolean insertDrugs(Drugs d) throws Exception{
		SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		DrugsMapper  drugs = session.getMapper(DrugsMapper.class);
		drugs.insertDrug(d);
		session.commit();
		session.close();
		return true;
	}
	
	public static List<Drugs> selectDrug() throws Exception{
		 List<Drugs> list = new ArrayList<Drugs>();
		 SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		 DrugsMapper  drugs = session.getMapper(DrugsMapper.class);
		 list = drugs.selectDrug();	 
		 session.close();
		 return list; 
	}
	
}

