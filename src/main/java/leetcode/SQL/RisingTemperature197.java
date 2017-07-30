package leetcode.SQL;

/**
 * Created by yang on 17-7-30.
 * Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.

 +---------+------------+------------------+
 | Id(INT) | Date(DATE) | Temperature(INT) |
 +---------+------------+------------------+
 |       1 | 2015-01-01 |               10 |
 |       2 | 2015-01-02 |               25 |
 |       3 | 2015-01-03 |               20 |
 |       4 | 2015-01-04 |               30 |
 +---------+------------+------------------+

 For example, return the following Ids for the above Weather table:

 +----+
 | Id |
 +----+
 |  2 |
 |  4 |
 +----+

 SELECT t1.Id
 FROM Weather t1
 INNER JOIN Weather t2
 ON TO_DAYS(t1.Date) = TO_DAYS(t2.Date) + 1
 WHERE t1.Temperature > t2.Temperature

 to_days()函数作用：

 TO_DAYS(date) 给定一个日期date, 返回一个天数 (从年份0开始的天数 )

 mysql> SELECT TO_DAYS(‘1997-10-07′); -> 729669
 */
public class RisingTemperature197 {
    String sql = "";
}
