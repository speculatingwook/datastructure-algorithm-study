package org.speculatingwook.sort;

/**
 * 최소값을 찾고, 요소 교환
 * 그 다음, 인덱스를 하나 늘린 뒤 최솟값을 찾고, 요소 교환 -> 반복
 */
public class SelectionSort implements Sort{
    @Override
    public int[] sort(int[] array) {
        for(int j = 0; j< array.length-1; j++){
            int min = 1000000000;
            int minIndex = 0;
            for(int i = j; i<array.length; i++){
                if(min > array[i]){
                    min = array[i];
                    minIndex = i;
                }
            }
            int temp = array[j];
            array[j] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }
}