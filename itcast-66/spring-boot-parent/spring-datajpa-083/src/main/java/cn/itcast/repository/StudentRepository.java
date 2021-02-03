package cn.itcast.repository;

import cn.itcast.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    public List<Student> findByIdIn(List<Integer> idList);
}