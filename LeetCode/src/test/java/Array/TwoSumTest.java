package Array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by qiaoyang on 16-4-17.
 */

/*
1.TwoSum0继承TwoSum，因此这里不同人使用只用改SetUp()方法里面创建对象的名字
  自动提升为TwoSum，测试用例通用的
2.测试不通过的注释好，解决不了方便复现

 */
public class TwoSumTest {
    public TwoSum math;

    int nums[] = new int[]{1, 2, 3, 4, 5};
    int target = 6;

    @Before
    public void SetUp() throws Exception {
        math = new TwoSum0();
    }

    @Test
    public void testFirst() {
        Assert.assertEquals(math.twoSum(nums, target)[0], 0);
    }

    @Test
    public void testSecond() {
        Assert.assertEquals(math.twoSum(nums, target)[1], 4);
    }

}
