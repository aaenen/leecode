package com.sword;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class Exchange {
    //方法一：用双指针的方法，虽然时间复杂度为O（N），但是空间复杂度只有O（1）
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, temp;
        while (i < j) {
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    //方法二：暴力法，时间复杂度和空间复杂度均为O（N）
    public int[] exchange2(int[] nums) {
        int[] arr = new int[nums.length];
        int i = 0, j = 0;
        int[] brr = new int[nums.length];
        for (int num : nums) {
            if (num % 2 == 1) {
                arr[i] = num;
                i++;
            } else {
                brr[j] = num;
                j++;
            }
        }
        return nums;
    }

    //方法三：快慢双指针 时间复杂度O[N]，空间复杂度O[1]
    //定义快慢双指针 fast 和 low ，fast 在前， low 在后 .
    //fast 的作用是向前搜索奇数位置，low 的作用是指向下一个奇数应当存放的位置
    //fast 向前移动，当它搜索到奇数时，将它和 nums[low]nums[low] 交换，此时 low 向前移动一个位置 .
    //重复上述操作，直到 fast 指向数组末尾
    public int[] exchange3(int[] nums) {
        int fast = 0, low = 0, temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                temp = nums[low];
                nums[low] = nums[fast];
                nums[fast] = temp;
                low++;
            }
            //天王老子来来，fast也要++
            fast++;
        }
        return nums;
    }

}
