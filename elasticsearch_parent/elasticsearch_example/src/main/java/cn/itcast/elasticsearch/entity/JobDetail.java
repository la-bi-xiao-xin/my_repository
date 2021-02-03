package cn.itcast.elasticsearch.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class JobDetail {
    //为id添加注解,id字段在进行json转换时不做转换
    @JSONField(serialize = false)
    private long id;            // 唯一标识
    private String area;        // 职位所在区域
    private String exp;         // 岗位要求的工作经验
    private String edu;         // 学历要求
    private String salary;      // 薪资范围
    private String job_type;    // 职位类型（全职/兼职）
    private String cmp;         // 公司名
    private String pv;          // 浏览量
    private String title;       // 岗位名称
    private String jd;          // 职位描述

    //设置set和get方法


    public JobDetail() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getCmp() {
        return cmp;
    }

    public void setCmp(String cmp) {
        this.cmp = cmp;
    }

    public String getPv() {
        return pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    //构建toString方法
    @Override
    public String toString() {
        return "JobDetail{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", exp='" + exp + '\'' +
                ", edu='" + edu + '\'' +
                ", salary='" + salary + '\'' +
                ", job_type='" + job_type + '\'' +
                ", cmp='" + cmp + '\'' +
                ", pv='" + pv + '\'' +
                ", title='" + title + '\'' +
                ", jd='" + jd + '\'' +
                '}';
    }
}
