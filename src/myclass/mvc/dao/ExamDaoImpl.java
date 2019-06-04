package myclass.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import myclass.mvc.dao.ExamDao;
import myclass.mvc.us.Exam;

public class ExamDaoImpl implements ExamDao{
	private Connection c = null;
	private PreparedStatement p = null;
	
	public ExamDaoImpl(Connection c) {
		this.c = c;
	}
	
	public List<List<String>> trytest(Exam exam) throws Exception{
		
		
		List<List<String>> testlist = null;
		String sql = "select question, chooseA, chooseB, chooseC, chooseD from exam where examid=?";
		
		
		return testlist;
	}
	
}
