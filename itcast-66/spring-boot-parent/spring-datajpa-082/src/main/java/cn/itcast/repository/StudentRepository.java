package cn.itcast.repository;

import cn.itcast.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//extends JpaRepository<Student,Integer>  继承使得该接口为JpaRepository接口
public interface StudentRepository extends JpaRepository<Student,Integer> {

    //自定义查询语法
    //findBy(关键字)+属性名称(属性名称的首字母大写)+查询条件(首字母大写)

    public List<Student> findByIdIn(List<Integer> idList);


}
