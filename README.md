# LeetCode


LeetCode problems solutions
## 参考资料

1. Java编程思想（第4版） [thinking in java][美] Bruce Eckel 著；陈昊鹏 译
2. 算法竞赛入门经典（第2版）刘汝佳 著
3. 算法 第4版 Algorithms Fourth Edition [Algorithms, Fourth Edition] [美] Robert Sedgewick，[美] Kevin Wayne 著；谢路云 译
4. 数据结构与算法分析：Java语言描述（第2版） [Data structures and algorithm analysis in java second edition]
   [美] 韦斯（Mark AIlen Weiss） 著；冯舜玺 译


## 解题原则

1. 一道题只有一个public类，public类用来记录LeetCode上给的标准方法名，免得再复制粘贴一次
2. 每个人的解题思路使用包可见类实现，命名规则为public类+数字0，1，2，3
  约定我是0，魏楚阳为1，张玲瑶为2，黄坤鸿为3
3. 测试使用Junit框架，保存测试用例，测试命名方式和解题类一致，方便大家看思路和帮你Fix Bug
4. 多写注释和心得体会，解题思路和遇到的问题，以便全方位覆盖知识点，有问题写在注释里，别人看到直接解答

## 测试原则

1. 大家共享一个测试类，多个测试用例
2. 有问题无法解决方便他人复现

## 测试例子1

1. TwoSum0继承TwoSum，因此这里不同人使用只用改SetUp()方法里面创建对象的名字
  自动提升为TwoSum，测试用例通用的
2. 测试不通过的注释好，解决不了方便复现

