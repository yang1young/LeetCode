package leetcode.SQL;

/**
 * Created by yang on 17-7-24.
 */
/*
 The Employee table holds all employees. Every employee has an Id, a salary, and there is also a column for the department Id.

+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+

The Department table holds all departments of the company.

+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+

Write a SQL query to find employees who have the highest salary in each of the departments. For the above tables, Max has the highest salary in the IT department and Henry has the highest salary in the Sales department.

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+


select B.Name as Department,A.Name as Employee, A.Salary as Salary
from Employee A,Department B
where A.DepartmentId = B.Id
and Salary = (select max(Salary) from Employee C where C.DepartmentId = B.Id  )

 */
public class DepartmentHighestSalary184 {
    public static void main(String[] args) {
        String sql ="select B.Name as Department,A.Name as Employee, A.Salary as Salary\n" +
                "from Employee A,Department B \n" +
                "where A.DepartmentId = B.Id\n" +
                "and Salary = (select max(Salary) from Employee C where C.DepartmentId = B.Id  )\n";
    }
}

/*
SELECT
    Department.name AS 'Department',
    Employee.name AS 'Employee',
    Salary
FROM
    Employee
        JOIN
    Department ON Employee.DepartmentId = Department.Id
WHERE
    (Employee.DepartmentId , Salary) IN
    (   SELECT
            DepartmentId, MAX(Salary)
        FROM
            Employee
        GROUP BY DepartmentId
    )
;
 */