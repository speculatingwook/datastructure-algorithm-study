package org.speculatingwook.sort;

public class MergeSort implements Sort{
    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            return array;
        }

        if (array.length > 1) {
            int mid = array.length / 2;
            int[] leftArray = new int[mid];
            int[] rightArray = new int[array.length - mid];

            System.arraycopy(array, 0, leftArray, 0, mid);
            System.arraycopy(array, mid, rightArray, 0, array.length - mid);

            sort(leftArray);
            sort(rightArray);
            merge(array, leftArray, rightArray);
        }
        return array;
    }

    public static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;

        // 왼쪽과 오른쪽 배열을 비교, 그중 작은 값을 먼저 병합
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                array[mergedIndex++] = leftArray[leftIndex++];
            } else {
                array[mergedIndex++] = rightArray[rightIndex++];
            }
        }

        // 남은 요소들 처리
        while (leftIndex < leftArray.length) {
            array[mergedIndex++] = leftArray[leftIndex++];
        }

        while (rightIndex < rightArray.length) {
            array[mergedIndex++] = rightArray[rightIndex++];
        }
    }
}