package com.example.myapp.biz.type9.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.myapp.biz.type9.domain.User;

@Repository
public class JdbcUserDao implements UserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;
	
	private static final RowMapper<User> userRowMapper = (rs, i) -> {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setBirthday(rs.getDate("birth_date"));
		user.setPrefecture(rs.getString("prefecture"));
		user.setCreatedAt(rs.getTimestamp("created_at"));
		user.setUpdatedAt(rs.getTimestamp("updated_at"));
		return user;
	};
	
	@Override
	public List<User> findAll() {
		// SQL文
		String sql = "SELECT id, name, email, birth_date, prefecture, created_at, updated_at FROM user";
		List<User> users = jdbcTemplate.query(sql, userRowMapper);
		
		return users;
	}

	@Override
	public User findById(int id) {
		// SQL文
		String sql = "SELECT id, name, email, birth_date, prefecture, created_at, updated_at FROM user WHERE id = :id";
		// パラメータ設定
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		// 実行
		User user= namedParameterJdbcTemplate.queryForObject(sql, param, userRowMapper);

		return user;
	}

	@Override
	public int save(User user) {
		String sql = "INSERT INTO user(name, email, birth_date, prefecture) VALUES (:name, :email, :birthday, :prefecture)";
		// パラメータ設定
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		// 実行
		return namedParameterJdbcTemplate.update(sql, param);
	}

	@Override
	public User findByMail(String mail) {
		// SQL文
		String sql = "SELECT id, name, email, birth_date, prefecture, created_at, updated_at FROM user WHERE email = :mail";
		// パラメータ設定
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("mail", mail);
		// 実行
		User user = namedParameterJdbcTemplate.queryForObject(sql, param, userRowMapper);

		return user;
	}

	@Override
	public int update(User user) {
		String sql = "UPDATE user SET name=:name, email=:email, birth_date=:birthday, prefecture=:prefecture WHERE id=:id";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		return namedParameterJdbcTemplate.update(sql, param);
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM user WHERE id=:id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		// 実行
		return namedParameterJdbcTemplate.update(sql, param);
	}

}
