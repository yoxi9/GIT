package Daoimpl;

import dao.DBUtils;
import dao.StudentDao;
import entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao{
	@Override
    public int add(Student student) {
        int code=0;
        String sql="insert into student (id,grade,name,number) values(?,?,?,?)";
        code= DBUtils.update(sql,student.getId(),
                student.getGrade(),student.getName(),
                student.getNumber());
        return code;
    }

    @Override
    public int delete(Student student) {
        int code=0;
        String sql="delete from student where id=?";
        code=DBUtils.update(sql,student.getId());
        return code;
    }

    @Override
    public int delete(int studentid) {
        return 0;
    }

    @Override
    public List<Student> getByID(int number) {
        String sql="select*from student where number=?";
        List<Student> studentList=new ArrayList<Student>();

        List<Map<String,Object>> mapList=DBUtils.query(sql,new Integer(number));
        for (Map<String,Object>map:mapList){
            Student student=new Student();
            student.setId((Integer)(map.get("id")));
            student.setGrade((String) (map.get("grade")));
            student.setName((String) (map.get("name")));
            student.setNumber((Integer)(map.get("number")));

            studentList.add(student);
        }
        return studentList;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }

}
