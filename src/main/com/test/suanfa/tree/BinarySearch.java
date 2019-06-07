package suanfa.tree;

/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 二分查找遍历查找方法
     * @param arr
     * @param x
     * @return
     */
    public static int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int middle = (low+high)/2;
            if (x == arr[middle]) {
                return middle;
            } else if (x < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }


    /**
     * 二分查找递归查找方法
     * @param dataset
     * @param data
     * @param beginIndex
     * @param endIndex
     * @return
     */
    public static int binarySearch(int[] dataset, int data, int beginIndex, int endIndex) {
        int midIndex = (beginIndex+endIndex)/2;
        if (data < dataset[beginIndex] || data > dataset[endIndex] || beginIndex > endIndex) {
            return -1;
        }
        if (data < dataset[midIndex]) {
            return binarySearch(dataset, data, beginIndex, midIndex - 1);
        } else if (data > dataset[midIndex]) {
            return binarySearch(dataset, data, midIndex + 1, endIndex);
        } else {
            return midIndex;
        }
    }



    public static void main(String[] args) {
        int[] arr = { 6, 12, 33, 87, 90, 97, 108, 561 };
        System.out.println("循环查找：" + (binarySearch(arr, 87) + 1));
        System.out.println("循环查找：" + (binarySearch(arr, 87,0,arr.length-1) + 1));

        System.out.println(5/2+"-----------");
    }

}
