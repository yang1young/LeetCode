package leetcode.SQL;

/**
 * Created by yang on 17-6-26.
 */

/*
 Write a SQL query to get the second highest salary from the Employee table.
+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+

For example, given the above Employee table, the query should return 200 as the second highest
salary. If there is no second highest salary, then the query should return null.
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
 */

public class SecondHighestSalary176 {
    String sql1 = "Select MAX(Salary) AS SecondHighestSalary from Employee where Salary < (Select MAX(Salary) from Employee)";
    String sql2 = "  select distinct Salary from Employee order by Salary Desc limit 1 offset 1";
}
