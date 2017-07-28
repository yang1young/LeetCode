package leetcode.SQL;

/**
 * Created by yang on 17-6-26.
 */
/*
 Write a SQL query to find all numbers that appear at least three times consecutively.

+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+

For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.

+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+

 */
public class ConsecutiveNumbers180 {
 String sql = "select distinct l1.num as ConsecutiveNums\n" +
         "\" +\n" +
         "            \"from Logs l1 \\n\" +\n" +
         "            \"    join Logs l2 on l1.id=l2.id-1 \\n\" +\n" +
         "            \"    join Logs l3 on l1.id=l3.id-2\\n\" +\n" +
         "            \"where l1.num=l2.num and l2.num=l3.num";
}
