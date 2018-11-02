package com.test.mymall.commons;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBHelper {
	//데이터베이스 연결을 위한 공통사용 코드 메서드화
	public static SqlSession getSqlSession() throws Exception {
		InputStream inputStream = null;
		  try {
		   String resource = "mybatis-config.xml";
		   inputStream = Resources.getResourceAsStream(resource);
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  
		  SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream); 
		  SqlSession sqlSession = sqlSessionFactory.openSession();
		  return sqlSession;
	}


	//객체 종료를 위한 공통사용 코드 메서드화
	public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        if(resultSet != null) {
            try {resultSet.close();} catch(Exception exception) {exception.printStackTrace();}
        }
        if(preparedStatement != null) {
            try {preparedStatement.close();} catch(Exception exception) {exception.printStackTrace();}
        }
        if(connection != null) {
            try {connection.close();} catch(Exception exception) {exception.printStackTrace();}
        }
	}
}
