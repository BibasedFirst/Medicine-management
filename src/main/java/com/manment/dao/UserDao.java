package com.manment.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.manment.bean.User;
import com.manment.config.SqlSessionUtil;
import com.manment.mapper.DrugsMapper;
import com.manment.mapper.UsersMapper;

public class UserDao {
	public static Boolean insertDrugs(User u) throws Exception{
		SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		UsersMapper  user = session.getMapper(UsersMapper.class);
		user.insertUser(u);
		session.commit();
		session.close();
		return true;
	}
	
	public static List<User> selectUser() throws Exception{
		 List<User> list = new ArrayList<User>();
		 SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		 UsersMapper  user = session.getMapper(UsersMapper.class);
		 list = user.selectUser();	 
		 session.close();
		 return list; 
	}
	
	public static User selectUserByLogin(User u) throws Exception{
		 SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		 UsersMapper  usersMapper = session.getMapper(UsersMapper.class);
		 User user = usersMapper.selectUserByLogin(u);
		 session.close();
		 return user; 
	}
	
}
