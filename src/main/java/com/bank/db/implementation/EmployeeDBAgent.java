package com.bank.db.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.db.queries.EmployeeTableQuery;
import com.bank.enums.Status;
import com.bank.exceptions.PersistenceException;
import com.bank.interfaces.EmployeeAgent;
import com.bank.interfaces.UserAgent;
import com.bank.persistence.util.PersistenceObj;
import com.bank.pojo.Employee;

public class EmployeeDBAgent implements EmployeeAgent {
	
	private EmployeeDBAgent() {
	}
	
	private static class EmployeeDBAgentHolder{
		private final static EmployeeDBAgent accAgent = new EmployeeDBAgent(); 
	}
	
	public static EmployeeDBAgent getEmployeeDBAgent() {
		return EmployeeDBAgentHolder.accAgent;
	}
	
	UserAgent usAgent = PersistenceObj.getUserAgent();

	private Connection connect() throws SQLException {
		return DriverManager.getConnection(ConnectionHandler.getURL(), ConnectionHandler.getUser(),
				ConnectionHandler.getPassword());
	}

	@Override
	public long getBranchId(long userId) throws PersistenceException {
		try (Connection connection = connect();
				PreparedStatement st = connection.prepareStatement(EmployeeTableQuery.getBranchId)) {
			st.setLong(1, userId);
			try (ResultSet set = st.executeQuery()) {
				set.next();
				return set.getLong(1);
			}
		} catch (SQLException exception) {
			throw new PersistenceException("Couldn't fetch branchId type", exception);
		}
	}

	@Override
	public Employee getEmployee(long userId) throws PersistenceException {
		try (Connection connection = connect(); 
				PreparedStatement st = connection.prepareStatement(EmployeeTableQuery.getEmployeeProfile)){
			st.setLong(1, userId);
			try(ResultSet set = st.executeQuery()){
				set.next();
				Employee emp = new Employee();
				emp.setID(set.getLong(1));
				emp.setName(set.getString(2));
				emp.setDOB(set.getString(3));
				emp.setGender(set.getString(4));
				emp.setAddress(set.getString(5));
				emp.setMail(set.getString(6));
				emp.setPhone(set.getLong(7));
				emp.setStatus(Status.getStatusByState(set.getInt(8)));
				emp.setBranchID(set.getLong(9));
				emp.setAadharNum(set.getLong(10));
				return emp;
			}
		} catch (SQLException exception) {
			throw new PersistenceException("Couldn't fetch employee details",exception);
		}
	}
	
	@Override
	public boolean isEmployeePresent(long userId) throws PersistenceException{
		try (Connection connection = connect(); 
				PreparedStatement st = connection.prepareStatement(EmployeeTableQuery.isEmployeePresent)){
			st.setLong(1, userId);
			try(ResultSet set = st.executeQuery()){
				set.next();
				return set.getBoolean(1);
			}
		} catch (SQLException exception) {
			throw new PersistenceException("Couldn't check employee presence",exception);
		}
	}
}
