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
		Drugs d = new Drugs("云南白药",155,15,new Date(),new Date(),15,17,98);
		insertDrugs(d);
		/*System.out.println(selectDrugsByPage(1));*/
	}
	
	public static Boolean insertDrugs(Drugs d) throws Exception{
		SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		DrugsMapper  drugs = session.getMapper(DrugsMapper.class);
		drugs.insertDrug(d);
		session.commit();
		session.close();
		return true;
	}
	
	//所有药品列表
	public static List<Drugs> selectDrug() throws Exception{
		 List<Drugs> list = new ArrayList<Drugs>();
		 SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		 DrugsMapper  drugs = session.getMapper(DrugsMapper.class);
		 list = drugs.selectDrug();	 
		 session.close();
		 return list; 
	}
	
	//更新药品信息 
	public static Boolean updateDrugById(Drugs d) throws Exception{
		 SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		 DrugsMapper  drugs = session.getMapper(DrugsMapper.class);
		 drugs.updateDrugById(d);
		 session.commit();
		 session.close();
		 return true; 
	}
	//根据id查询药品
	public static  Drugs selectDrugsById(int id)throws Exception{
		 SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		 DrugsMapper  drugs = session.getMapper(DrugsMapper.class);
		 Drugs d = (Drugs)drugs.selectDrugsById(id);	 
		 session.close();
		 return d;
	}
	
	//分页查询药品 page当前页 ，每页分20
	public static List<Drugs> selectDrugsByPage(int page) throws Exception{
		 List<Drugs> list = new ArrayList<Drugs>();
		 SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		 DrugsMapper  drugs = session.getMapper(DrugsMapper.class);
		 list = drugs.selectDrugsByPage((page-1)*20);	 
		 session.close();
		 return list; 
	}
	
	//根据id删除药品,,,shopping表外键关联
	public static Boolean deleteDrugsById(int id) throws Exception{
		 SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		 DrugsMapper  drugs = session.getMapper(DrugsMapper.class);
		 drugs.deleteDrugsById(id);	
		 session.commit();
		 session.close();
		 return true; 
	}
}

