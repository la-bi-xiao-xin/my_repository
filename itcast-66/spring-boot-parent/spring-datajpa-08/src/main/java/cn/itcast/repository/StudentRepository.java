package cn.itcast.repository;

import cn.itcast.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
// findBy(关键字)+属性名称(属性名称的首字母大写)+查询条件(首字母大写)
    // 需求1: 根据姓名和性别查询用户信息
    public List<Student> findByNameAndSex(String name,String sex);
    // 需求2: 根据姓名或性别查询用户信息
    public List<Student> findByNameOrSex(String name,String sex);
    // 需求3: 查询姓张的学生
    public List<Student> findByNameLike(String like);

    // 需求4: 根据多个id查询用户信息
    public List<Student> findByIdIn(List<Integer> idlist);
}