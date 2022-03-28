package com.sword;

/**
 * 旋转数组里的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在重元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class MinArray {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            // 中间点的值小于最右边的值，说明最小值在上半区 例如 5 1 2 3 4
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
                //中间点的值大于最右边的值，说明最小值在下半区 例如 3 4 5 1 2
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
                //不然就一个一个减 5 1 2 2 2
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
