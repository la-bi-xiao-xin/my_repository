package cn.itcast.pojo;

import lombok.Data;

import javax.persistence.*;

@Data  //注解  用于自动创建实体类通用方法
@Entity  //注解 标记为一个jpa实体类
@Table(name = "tb_student2") //指定表名
public class Student {
    @Id  //注解  标记为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //注解 标记为自动增长列
    private Integer id;

    @Column(name = "name",length = 30) //注解 列名与变量名映射 设置字段名长度
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex",length = 5)
    private String sex;
}
