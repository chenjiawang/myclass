package myclass.mvc.dao;

import myclass.mvc.us.Exam;

import java.util.ArrayList;
import java.util.List;

public interface ExamDao {
	public List<List<String>> trytest(Exam exam) throws Exception;
}
