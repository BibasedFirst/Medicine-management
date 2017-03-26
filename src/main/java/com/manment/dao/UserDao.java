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
	//通过ID删除用户
	public static boolean deleteByExample(Integer id) throws IOException{
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
	
	//通过id查询用户
		public static User selectById(Integer uID) throws IOException{
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
		  //根据用户的用户名来查询该用户的问题
	    public static String findByName(String uName) throws IOException{
	    	String question = null;
	    	SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
			 UsersMapper  usersMapper = session.getMapper(UsersMapper.class);
			 try {
				question = usersMapper.findByName(uName);
				session.commit();
				session.close();
			} catch (Exception e) {
				question = null;
				e.printStackTrace();
			}
	    	return question;
	    }
	    
	  //更新用户 
	    public static void updateByID(User user) throws IOException{
	    	SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
			 UsersMapper  usersMapper = session.getMapper(UsersMapper.class);
			 try {
			    usersMapper.updateByID(user);
				session.commit();
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    
	    //根据用户的帐号和答案来查询用户
	    public static String findByNameAndAnswer(User u) throws IOException{
	    	String password = null;
	    	SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
			 UsersMapper  usersMapper = session.getMapper(UsersMapper.class);
			 try {
				 Map<String, Object> value = new HashMap<String, Object>();
				 value.put("uName", u.getuName());
				 value.put("answer", u.getAnswer());
				 password = usersMapper.findByNameAndAnswer(value);
				session.commit();
				session.close();
			} catch (Exception e) {
			 
			}
	    	return password;
	    }
	    
	   	    
	  //通过是否冻结查询用户
	    public static List<User> findByIsFreezing(Integer isFreezing) throws IOException{
	    	List<User> users = new ArrayList<User>();
	    	SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
			UsersMapper  usersMapper = session.getMapper(UsersMapper.class);
			try{
				users = usersMapper.findByIsFreezing(isFreezing);
				session.commit();
				session.close();
				return users;
			}catch (Exception e) {
				// TODO: handle exception
				return null;
			}
	    }
	    
	    //通过其它字段查询用户
	    public static List<User> findByOther(User u) throws IOException{
	    	List<User> users = new ArrayList<User>();
	    	SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
			UsersMapper  usersMapper = session.getMapper(UsersMapper.class);
			Map<String, Object> userMap = new HashMap<String, Object>();
			try{
				if(u.getAnswer() != null)
					userMap.put("answer", u.getAnswer());
				if(u.getFreezingTime() != null)
					userMap.put("freezingTime", u.getFreezingTime());
				if(u.getIsFreezing() != null)
					userMap.put("isFreezing",u.getIsFreezing());
				if(u.getNickName() != null)
					userMap.put("nickName",u.getNickName());
				if(u.getQuestion() != null)
					userMap.put("question",u.getQuestion());
				if(u.getuID() != null)
					userMap.put("uID",u.getuID());
				if(u.getuName() != null)
					userMap.put("uName",u.getuName());
				if(u.getuPhone() != null)
					userMap.put("uPhone",u.getuPhone());
				if(u.getuPwd() != null)
					userMap.put("uPwd",u.getuPwd());
				if(u.getuType() != null)
					userMap.put("uType",u.getuType());
				users = usersMapper.findByOther(userMap);
				session.commit();
				session.close();
				return users;
			}catch (Exception e) {
				// TODO: handle exception
				return null;
			}
	    }
	    
		
}
