package leetcode.SQL;

/**
 * Created by yang on 17-6-26.
 */
/*
 Write a SQL query to get the nth highest salary from the Employee table.
+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+

For example, given the above Employee table, the nth highest salary where n = 2 is 200.
If there is no nth highest salary, then the query should return null.
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+
 */
public class NthHighestSalary177 {
    /*
    CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
    BEGIN
    RETURN (
      # Write your MySQL query statement below.

    );
    END
    */
    //set N=N-1;
    String sql = "select max(Salary) from ((select Id,Salary from Employee ) t1 inner join (select Id from Employee  order by Salary DESC limit N)  t2 on t1.Id!=t2.Id)";
    String sql2 = "select distinct Salary from Employee order by Salary desc limit N, 1";
    String sql3 = "CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT\n" +
            "BEGIN\n" +
            "      set N=N-1;\n" +
            "  RETURN (\n" +
            "      # Write your MySQL query statement below.\n" +
            "        select max(Salary) from \n" +
            "        (\n" +
            "            select Salary from \n" +
            "            (\n" +
            "                select distinct Salary from Employee A \n" +
            "                    UNION ALL \n" +
            "                (select distinct Salary from Employee B order by Salary DESC limit N)\n" +
            "            )D GROUP BY Salary HAVING COUNT(Salary) = 1 \n" +
            "        )E\n" +
            "        \n" +
            "  );\n" +
            "END";
}
