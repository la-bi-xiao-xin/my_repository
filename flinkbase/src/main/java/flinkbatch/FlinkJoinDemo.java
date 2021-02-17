package flinkbatch;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.JoinOperator;

/*	步骤:
       分别将资料中的两个文件复制到项目中的 data/join/input 中
       构建批处理环境
       创建两个类
       学科Subject（学科ID、学科名字）
       成绩Score（唯一ID、学生姓名、学科ID、分数——Double类型）
       分别使用 readCsvFile 加载csv数据源，并制定泛型
       使用join连接两个DataSet，并使用 where 、 equalTo 方法设置关联条件
       打印关联后的数据源
*/
public class FlinkJoinDemo {
    public static void main(String[] args) throws Exception {
        //1.构建批处理环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        /*//2.创建两个类,学科Subject（学科ID、学科名字）,成绩Score（唯一ID、学生姓名、学科ID、分数——Double类型）

        //3.分别使用 readCsvFile 加载csv数据源，并制定泛型
        //3.1读取subject.csv文件
        CsvReader subject = env.readCsvFile("./data/input/subject.csv");
        DataSource<Subject> subjectDataSource = subject.lineDelimiter(",")
                .pojoType(Subject.class, "id", "subject");

        //3.2读取score.csv文件
        CsvReader score = env.readCsvFile("./data/input/score.csv");
        DataSource<Score> scoreDatasouce = score.lineDelimiter(",")
                .pojoType(Score.class, "id", "name", "subjectId", "score");

        //3.3进行关联操作
        JoinOperator.DefaultJoin<Subject, Score> joinData = subjectDataSource
                .join(scoreDatasouce).where("id").equalTo("subjectId");

        //4.打印果结
        joinData.print();*/

        DataSource<JoinDemo.Score> scoreDataSource = env.readCsvFile("data/input/score.csv")
                .fieldDelimiter(",")
                .pojoType(JoinDemo.Score.class, "id", "name", "subjectId", "score");

        DataSource<JoinDemo.Subject> subjectDataSource = env.readCsvFile("data/input/subject.csv")
                .fieldDelimiter(",")
                .pojoType(JoinDemo.Subject.class, "id", "name");

        JoinOperator.DefaultJoin<JoinDemo.Score, JoinDemo.Subject> joinedDataSource =
                scoreDataSource.join(subjectDataSource).where("subjectId").equalTo("id");
        joinedDataSource.print();


    }
}
