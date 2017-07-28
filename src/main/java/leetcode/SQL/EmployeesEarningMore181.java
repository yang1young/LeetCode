package leetcode.SQL;

/**
 * Created by yang on 17-6-26.
 */
/*
 The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.

+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+

Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.

+----------+
| Employee |
+----------+
| Joe      |
+----------+

 */
public class EmployeesEarningMore181 {
    String sql = "select Name as Employee from Employee as TEMP1 where TEMP1.ManagerId is not NULL and TEMP1.Salary>(select Salary from Employee as TEMP2 where TEMP2.Id = TEMP1.ManagerId ) ";
    String sql2 = "select E1.Name \n" +
            "from Employee as E1, Employee as E2 \n" +
            "where E1.ManagerId = E2.Id and E1.Salary > E2.Salary";
}
