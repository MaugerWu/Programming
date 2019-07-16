# LeetCode_001

- [LeetCode-001.两数之和](https://leetcode-cn.com/problems/two-sum/)

```
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
```

示例：

```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9

所以返回 [0, 1]。
```

示例代码：

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
    }
}
```


# Solution

## 方法一：两层 for 循环暴力破解

- 测试用例：29个，{(2, 7, 11, 15), target=9, [0, 1]}、{(2, 5, 5, 11), target=10, [1, 2]} 等。
- 执行用时：69ms
- 内存消耗：37.4MB
- 时间复杂度：O(n^2)
- 空间复杂度：O(1)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[] {i, j};
                }
            }    
        }
        return null;
    }
}
```

## 方法二：哈希映射题解

- 测试用例：29个，{(2, 7, 11, 15), target=9, [0, 1]}、{(2, 5, 5, 11), target=10, [1, 2]} 等。
- 执行用时：7ms
- 内存消耗：38.7MB
- 时间复杂度：O(n)
- 空间复杂度：O(n)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
```
