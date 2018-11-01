package com.test.mymall.commons;

import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

public class DBHelper {
	//데이터베이스 연결을 위한 공통사용 코드 메서드화
	public static Connection getConnection() throws Exception {
    	Connection connection = null;
		Context initContext = new InitialContext();
		DataSource dataSource = (DataSource)initContext.lookup("java:comp/env/jdbc/mall");
		connection = dataSource.getConnection();
		return connection;
	}
	//객체 종료를 위한 공통사용 코드 메서드화
	public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if(resultSet != null) {
            try {resultSet.close();} catch(Exception exception) {exception.printStackTrace();}
        }
        if(statement != null) {
            try {statement.close();} catch(Exception exception) {exception.printStackTrace();}
        }
        if(connection != null) {
            try {connection.close();} catch(Exception exception) {exception.printStackTrace();}
        }
	}
}
