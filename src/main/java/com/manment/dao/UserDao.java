package com.manment.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.manment.bean.User;
import com.manment.config.SqlSessionUtil;
import com.manment.mapper.DrugsMapper;
import com.manment.mapper.UsersMapper;

public class UserDao {

	
	//查看所有用户
	public static List<User> selectUser() throws Exception{
		 List<User> list = new ArrayList<User>();
		 SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		 UsersMapper  user = session.getMapper(UsersMapper.class);
		 list = user.selectUser();	 
		 session.close();
		 return list; 
	}
	
	//通过帐号密码来查找用户
	public static User selectUserByLogin(User u) throws Exception{
		 SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		 UsersMapper  usersMapper = session.getMapper(UsersMapper.class);
		 Map<String, Object> val = new HashMap<String, Object>();
		 val.put("uName", u.getuName());
		 val.put("uPwd", u.getuPwd());
		 System.out.println(val.get("uPwd"));
		 User user = usersMapper.selectUserByLogin(val);
		 session.close();
		 return user; 
	}
	
	//保存用户
	public static boolean insert(User user) throws Exception{
		 SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		 UsersMapper  usersMapper = session.getMapper(UsersMapper.class);
		 try {
			usersMapper.insertUser(user);
			session.commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public static boolean deleteByExample(int id) throws IOException{
		 SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		 UsersMapper  usersMapper = session.getMapper(UsersMapper.class);
		 try {
			usersMapper.deleteByID(id);
			session.commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	public static User selectById(int uID) throws IOException{
		User u= null;
		SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
		 UsersMapper  usersMapper = session.getMapper(UsersMapper.class);
		 try {
			u = usersMapper.selectById(uID);
			session.commit();
			session.close();
		} catch (Exception e) {
		 
		}
		return u;
	}
	
}
