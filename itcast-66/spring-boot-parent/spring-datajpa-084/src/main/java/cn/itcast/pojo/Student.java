package cn.itcast.pojo;

import lombok.Data;

import javax.persistence.*;

// 简化生成get set toString等方法
@Data
// 建立和springdatajpa的关系
@Entity // 通知springdatajpa 当前类是 一个实体类, 通知jpa依据当前类创建表
@Table(name = "tb_student") // 指定表名, name属性可以省略不写, 如果不写, 表名就是当前类名, 且 第一个字母小写
public class Student {

    @Id // 指定当前表的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 当你新增数据时, 返回生成的主键
    private Integer id;

    // 指定属性对应的列名和长度
    @Column(name = "name", length = 32)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name="sex", length = 4)
    private String sex;
}