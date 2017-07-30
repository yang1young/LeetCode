package leetcode.SQL;

/**
 * Created by yang on 17-7-30.
 * X city built a new stadium, each day many people visit it and the stats are saved as these columns: id, date, people

 Please write a query to display the records which have 3 or more consecutive rows and the amount of people more than 100(inclusive).
 For example, the table stadium:

 +------+------------+-----------+
 | id   | date       | people    |
 +------+------------+-----------+
 | 1    | 2017-01-01 | 10        |
 | 2    | 2017-01-02 | 109       |
 | 3    | 2017-01-03 | 150       |
 | 4    | 2017-01-04 | 99        |
 | 5    | 2017-01-05 | 145       |
 | 6    | 2017-01-06 | 1455      |
 | 7    | 2017-01-07 | 199       |
 | 8    | 2017-01-08 | 188       |
 +------+------------+-----------+

 For the sample data above, the output is:

 +------+------------+-----------+
 | id   | date       | people    |
 +------+------------+-----------+
 | 5    | 2017-01-05 | 145       |
 | 6    | 2017-01-06 | 1455      |
 | 7    | 2017-01-07 | 199       |
 | 8    | 2017-01-08 | 188       |
 +------+------------+-----------+

 */
public class StadiumTraffic601 {
    String sql = "select distinct A.id,A.date,A.people from " +
            "stadium A,stadium B,stadium C where (A.people>=100 " +
            "and B.people>=100 and C.people>=100 and " +
            "((B.id = A.id + 1 and C.id = B.id +1) or " +
            "(B.id =A.id-1 and C.id = B.id -1) or " +
            "(A.id = B.id + 1 and C.id = A.id +1))) " +
            "order by A.id";
}
