package cn.itcast.elasticsearch.service.impl;

import cn.itcast.elasticsearch.entity.JobDetail;
import cn.itcast.elasticsearch.service.JobFullTextService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class JobFullTextServiceImplTest {
    private JobFullTextService jobFullTextService;
//创建连接es类对象
    @BeforeTest
    public void beforeTest() {
        jobFullTextService = new JobFullTextServiceImpl();
    }

    @Test
    public void testAdd() throws IOException {
        //创建JobDetail对象
        JobDetail jobDetail = new JobDetail();
        //设置JobDetail的变量值
        jobDetail.setId(1);
        jobDetail.setArea("江苏省-南京市");
        jobDetail.setCmp("Elasticsearch大学");
        jobDetail.setEdu("本科及以上");
        jobDetail.setExp("一年工作经验");
        jobDetail.setTitle("大数据工程师");
        jobDetail.setJob_type("全职");
        jobDetail.setPv("1700次浏览");
        jobDetail.setJd("会Hadoop就行");
        jobDetail.setSalary("5-9千/月");
        jobFullTextService.add(jobDetail);


    }

    @Test
    public void testFindById() throws IOException {
        JobDetail jobDetail= jobFullTextService.findById(1);
        System.out.println(jobDetail);

    }

    @Test
    public void testUpdate() throws IOException {
        //调用写好的jobFullTextService.findById方法获取一个jobDetail对象
        JobDetail jobDetail= jobFullTextService.findById(1);
        //修改jobDetail的成员变量值
        jobDetail.setTitle("大数据开发工程师很厉害的那种");
        //调用update方法
        jobFullTextService.update(jobDetail);
        System.out.println("更新成功");


    }

    @Test
    public void testDeleteById() throws IOException {
        jobFullTextService.deleteById(1);
        System.out.println("删除成功");
    }

    @Test
    public void testSearchByKeywords() throws IOException {
        List<JobDetail> list = jobFullTextService.searchByKeywords("java");
        for (JobDetail jobDetail : list) {
            System.out.println(jobDetail);
        }
    }

    @Test
    public void testSearchByPage() throws IOException {
        Map<String, Object> resultMap = jobFullTextService.searchByPage("销售", 1, 10);
        System.out.println("总共:" + resultMap.get("total"));
        List<JobDetail> jobDetailList = (List<JobDetail>)resultMap.get("content");

        for (JobDetail jobDetail : jobDetailList) {
            System.out.println(jobDetail);
        }
    }

    @Test
    public void testSearchByScrollPage() throws IOException {

        Map<String, Object> result = jobFullTextService.searchByScrollPage("销售", null, 10);
        System.out.println("*************************************");
        System.out.println("scrollId: " + result.get("scrollId"));
        List<JobDetail> content = (List<JobDetail>)result.get("content");

        for (JobDetail jobDetail : content) {
            System.out.println(jobDetail);
        }
    }

    @Test
    public void searchByScrollPageTest2() throws IOException {
        Map<String, Object> result = jobFullTextService.searchByScrollPage("销售", "DXF1ZXJ5QW5kRmV0Y2gBAAAAAAAAAA0WRG4zZFVwODJSU2Uxd1BOWkQ4cFdCQQ==", 10);
        System.out.println("scrollId: " + result.get("scrollId"));
        List<JobDetail> content = (List<JobDetail>)result.get("content");

        for (JobDetail jobDetail : content) {
            System.out.println(jobDetail);
        }

    }

    @Test
    public void testClose() {
    }


    @AfterTest
    public void afterTest() throws IOException {
       jobFullTextService.close();
    }

}