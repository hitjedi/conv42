package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.app.model.Currency;

public class JdbcCurrencyDAO implements CurrencyDAO {
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
	
	}
	
	@Override
	public void insert(Currency currency) {
		
		String sql = "INSERT INTO CURRENCY " +
				"(IDCURRRENCY, CURRENCYBUYRATE, CURRENCYSELRATE, CURRENCYNAME) VALUES (?, ?, ?, ?)";
		
		Connection conn = null;
		
		try {
			
			conn = dataSource.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, currency.getId());
			
			ps.setDouble(2, currency.getBuyRate());
			
			ps.setDouble(3, currency.getSellRate());
			
			ps.setString(4, currency.getName());
			
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		} finally {
			
			if (conn != null) {
			
				try {
				
					conn.close();
				
				} catch (SQLException e) {
					
					e.printStackTrace();
					
				}
			}
		}
	}

	@Override
	public Currency findCurrencyByName(String name) {

		String sql = "SELECT * FROM CURRENCY WHERE CURRENCYNAME = ?";

		Connection conn = null;
		
		try {
			
			conn = dataSource.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			
			Currency currency = null;
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
			
				currency = new Currency(
						
						rs.getInt(1),
						
						rs.getDouble(2),
						
						rs.getDouble(3),
						
						rs.getString(4)
			
				);
			
			}
			
			rs.close();
			
			ps.close();
			
			return currency;
		
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
		
		} finally {
		
			if (conn != null) {
			
				try {
				
					conn.close();
				
				} catch (SQLException e) {
					
					e.printStackTrace();
					
				}
			
			}
		
		}
	
	}
	
}
