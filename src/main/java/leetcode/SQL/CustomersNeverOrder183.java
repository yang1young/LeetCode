package leetcode.SQL;

/**
 * Created by yang on 17-6-26.
 */
/*
 Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all customers who never order anything.

Table: Customers.
+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+

Table: Orders.
+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+

Using the above tables as example, return the following:
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+

 */
public class CustomersNeverOrder183 {
    String sql = "select Name Customers from Customers c left join Orders o on c.Id=o.CustomerId where o.CustomerId is NULL";
}
