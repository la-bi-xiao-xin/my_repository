package cn.itcast.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity //注解 标记为jpa实体类
@Table(name = "tb_student2") //注解 映射表名
public class Student {
    @Id //注解 标记为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //注解 标记为自动增长列
    private Integer id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex",length = 5)
    private String sex;

}
