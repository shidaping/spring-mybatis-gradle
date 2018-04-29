package com.sdp.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import com.sdp.mybatis.model.User;
import com.sdp.util.RegUtil;

public interface UserDao {
	class SqlBuilder{
		public String getUser(String username) {
			SQL sql = new SQL();
			sql.SELECT("*");
			sql.FROM("user as user");
			if(RegUtil.match(RegUtil.REGEX_MOBILE, username)) {
				sql.WHERE("user.mobile=#{username}");
			} else if(RegUtil.match(RegUtil.REGEX_EMAIL, username)) {
				sql.WHERE("user.email=#{username}");
			} else {
				sql.WHERE("user.username=#{username}");
			}			
			System.out.println(sql.toString());
			return sql.toString();
		}
//		public String searchList(SearchReq searchReq) {
//			SQL sql = new SQL();
//			sql.SELECT("product.id,product.name,product.title,product.price,product.old_price,product.description, stock.stock as stock");
//			return this.searchBase(sql, searchReq);
//		}
//		public String searchCount(SearchReq searchReq) {
//			SQL sql = new SQL();
//			sql.SELECT("count(id)");
//			return this.searchBase(sql, searchReq);
//		}
	}
	
	@Select("select * from user where id=#{id}")
	public User getUserById(long id);
	@SelectProvider(type = SqlBuilder.class, method="getUser")
	public User getUserByUsername(@Param("username") String username);
}
