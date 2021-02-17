package flinkbatch;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.JoinOperator;

public class JoinDemo {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        DataSource<Score> scoreDataSource = env.readCsvFile("data/input/score.csv")
                .fieldDelimiter(",")
                .pojoType(Score.class, "id", "name", "subjectId", "score");

        DataSource<Subject> subjectDataSource = env.readCsvFile("data/input/subject.csv")
                .fieldDelimiter(",")
                .pojoType(Subject.class, "id", "name");

        JoinOperator.DefaultJoin<Score, Subject> joinedDataSource = scoreDataSource.join(subjectDataSource).where("subjectId").equalTo("id");
        joinedDataSource.print();
    }


    public static class Score{
        int id;
        String name;
        int subjectId;
        Double score;

        public Score(int id, String name, int subjectId, Double score) {
            this.id = id;
            this.name = name;
            this.subjectId = subjectId;
            this.score = score;
        }

        public Score() {}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(int subjectId) {
            this.subjectId = subjectId;
        }

        public Double getScore() {
            return score;
        }

        public void setScore(Double score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Score{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", subjectId=" + subjectId +
                    ", score=" + score +
                    '}';
        }
    }

    public static class Subject{
        int id;
        String name;

        public Subject(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Subject() {}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Subject{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
