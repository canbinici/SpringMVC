package com.rcan.springmvc.customerhandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.rcan.springmvc.model.Customer;

public class CustomerHandler implements CustomerHandlerInterface{
	
	private JdbcTemplate jdbcTemplate;

	public CustomerHandler(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int save(Customer c) {
		String sql = "INSERT INTO Customer (name , surname, blood, phone, adress) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, c.getName(), c.getSurname(), c.getBlood(), c.getPhone(), c.getAddress());
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Customer WHERE contact_id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public int update(Customer c) {
		String sql = "UPDATE Customer SET name=?, surname=?, blood=?, phone=?, adress=? WHERE contact_id=?";
		return jdbcTemplate.update(sql, c.getName(), c.getSurname(), c.getBlood(), c.getPhone(), c.getAddress(),
				c.getId());

	}

	@Override
	public Customer get(Integer id) {
		String sql = "SELECT * FROM Customer WHERE contact_id=" + id;
		ResultSetExtractor<Customer> extractor = new ResultSetExtractor<Customer>() {

			@Override
			public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Integer id = rs.getInt("contact_id");
					String name = rs.getString("name");
					String surname = rs.getString("surname");
					String blood = rs.getString("blood");
					String phone = rs.getString("phone");
					String address = rs.getString("address");
					return new Customer(id, name, surname, blood, phone, address);
				}
				return null;
			}

		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public List<Customer> list() {
		String sql = "SELECT * FROM Customer ORDER BY contact_id";

		RowMapper<Customer> rowMapper = new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("contact_id");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String blood = rs.getString("blood");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				return new Customer(id, name, surname, blood, phone, address);
			}

		};
		return jdbcTemplate.query(sql, rowMapper);

	}

}
