package com.walshfernandes.spring.rest.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import com.walshfernandes.spring.rest.beans.User;

@Component
public class UserService {
	
	private final String INSERT_USER_QUERY = ""
			+ " INSERT INTO users values(?, ?) ";
	
	private final String GET_USERS_QUERY = ""
			+ "SELECT * FROM users";
	private final String WHERE_CLAUSE = " where ";
	private final String AND_CLAUSE = " AND ";
	private final String GET_USERS_WHERE_NAME = " name = ?";
	private final String GET_USERS_WHERE_AGE = " age = ? ";
	
	private final JdbcOperations jdbcOps;
	
	public UserService(DataSource datasource) {
		this.jdbcOps = new JdbcTemplate(datasource);
	}
	
	public void createUser(User user) {
		jdbcOps.update(INSERT_USER_QUERY, new Object[] {user.getName(), user.getAge()});
	}
	
	public List<User> getUsers(Optional<String> name, Optional<Integer> age) {
		String query = buildQueryString(name, age);
		final List<User> users = new ArrayList<User>();
		
		jdbcOps.query(query, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				users.add(new User(rs.getString(1), rs.getInt(2)));
			}
		});
		
		return users;
	}
	
	public String buildQueryString(Optional<String> name, Optional<Integer> age) {
		StringBuilder query = new StringBuilder(GET_USERS_QUERY);
		if (name.isEmpty() && age.isPresent()) {
			query.append(WHERE_CLAUSE);
		}
		if (name.isPresent()) {
			query.append(GET_USERS_WHERE_NAME);
		}
		if (name.isEmpty() && age.isPresent()) {
			query.append(AND_CLAUSE);
		}
		if (age.isPresent()) {
			query.append(GET_USERS_WHERE_AGE);
		}
		
		return query.toString();
	} 
}
