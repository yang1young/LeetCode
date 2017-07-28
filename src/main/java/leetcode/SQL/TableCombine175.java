package leetcode.SQL;

/**
 * Created by yang on 17-6-25.
 */
public class TableCombine175 {

    /*Table: Person
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId is the primary key column for this table.

Table: Address
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId is the primary key column for this table.

Write a leetcode.SQL query for a report that provides the following information for each person
in the Person table, regardless if there is an address for each of those people:
FirstName, LastName, City, State
*/
    public static void tableCombine(){
        String sql = "select p.FirstName,p.LastName,a.City,a.State from Person as p left join Address as a on p.PersonId==a.PersonId";
    }
}
