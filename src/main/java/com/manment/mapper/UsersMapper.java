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
		
		//通过 ID修改用户信息
	    public int updateByPrimaryKey(User record);
	    
	    //删除用户
	    public int deleteById(int id);
	    
	    //根据用户id查询用户
	    public User selectById(int id);
	    
	    //更新用户 
	    public void updateByPrimaryKeySelective(User user);
	    
}
