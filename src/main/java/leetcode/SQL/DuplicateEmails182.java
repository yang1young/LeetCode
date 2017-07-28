package leetcode.SQL;

/**
 * Created by yang on 17-6-26.
 */
/*
 Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+

For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+

Note: All emails are in lowercase.
 */
public class DuplicateEmails182 {
    String sql = "select Email from (select Email,count(Email) as emailCount from Person  group by Email)TEMP where TEMP.emailCount>1";
    String sql2 = "SELECT Email from Person\n" +
            "Group By Email\n" +
            "Having Count(Email) > 1;";
}
