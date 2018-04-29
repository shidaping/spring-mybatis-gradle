package com.sdp.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import com.sdp.mybatis.dao.UserDao.SqlBuilder;
import com.sdp.mybatis.model.Game;
import com.sdp.mybatis.model.UserGame;
import com.sdp.util.RegUtil;
import com.sdp.web.jsoncontroller.game.ListReq;

import lombok.extern.slf4j.Slf4j;

public interface GameDao {
	class SqlBuilder{
		public String listBase(SQL sql, ListReq listReq, boolean limit) {
			sql.FROM("game");
			if(listReq.getName() != null && !listReq.getName().isEmpty()) {
				sql.WHERE("name like CONCAT('%',#{name},'%')");
			}
			if(listReq.getCompany() > 0) {
				sql.WHERE("company = #{company}");
			}
			if(listReq.getEngine() > 0) {
				sql.WHERE("engine = #{engine}");
			}
			if(listReq.getMethod() > 0) {
				sql.WHERE("method = #{method}");
			}
			if(listReq.getTheme() > 0) {
				sql.WHERE("theme = #{theme}");
			}
			if(listReq.getDimension() > 0) {
				sql.WHERE("dimension = #{dimension}");
			}
			if(limit) {
				int page = 1;
				if(listReq.getPage() > 1) {
					page = listReq.getPage();
				}
				int pageSize = listReq.getPageSize() > 0 ? listReq.getPageSize() : 10;
				return sql.toString() + " limit " + pageSize * (page -1) + "," + pageSize;
			}
			System.out.println(sql.toString());
			return sql.toString();

		}
		public String list(ListReq listReq) {
			SQL sql = new SQL();
			sql.SELECT("*");
			return this.listBase(sql, listReq, true);
		}
		public String listCount(ListReq listReq) {
			SQL sql = new SQL();
			sql.SELECT("count(id)");
			return this.listBase(sql, listReq, false);
		}
	}
	@SelectProvider(type = SqlBuilder.class, method="list")
	public List<Game> list(ListReq listReq);
	@SelectProvider(type = SqlBuilder.class, method="listCount")
	public int listCount(ListReq listReq);
	@Insert("insert into user_game(user_id, game_id) values(#{userId}, #{gameId})")  
	public boolean addFavorite(long userId, long gameId);
	@Select("select * from game where id=#{id}")  
	public Game getGameById(@Param("id") long id);
	@Select("select * from user_game where user_id=#{userId} and game_id=#{gameId}")  
	public UserGame getUserGame(long userId, long gameId);
	@Delete("delete from user_game where user_id=#{userId} and game_id=#{gameId}")  
	public boolean removeFavorite(long userId, long gameId);
}
