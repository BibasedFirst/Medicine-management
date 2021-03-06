package com.manment.mapper;

import java.util.List;
import java.util.Map;

import com.manment.bean.User;

public interface UsersMapper {
		//添加用户
		public void insertUser(User user) throws Exception;
		
		//查询用户所有列表
		public List<User> selectUser() throws Exception;
		
		//更新用户
		public Boolean updateUserById() throws Exception;
		
		//用户登录
		public User selectUserByLogin(Map<String, Object> user) throws Exception;
			    
	    //删除用户
	    public int deleteByID(Integer id);
	       
	  
	    //根据用户id查询用户
	    public User selectById(Integer id);
	    
	    //根据用户的用户名来查询
	    public String findByName(String uName);
	    
	    //根据用户的帐号和答案来查询用户
	    public String findByNameAndAnswer(Map<String, Object> user);
	    
	    //更新用户 
	    public void updateByID(User user);
	    
	    //通过其它字段查找用户
	    public List<User> findByIsFreezing(Integer isFreezing);
	    
 
	    //按照字段查询用户
	    public List<User> findByOther(Map<String, Object> map);
	    
}
