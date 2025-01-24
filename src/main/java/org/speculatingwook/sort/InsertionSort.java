package org.speculatingwook.sort;

public class InsertionSort implements Sort{
    @Override
    public int[] sort(int[] array) {
        for(int i = 1; i< array.length; i++){
            int index = i;
            while(index != 0 && array[index] < array[index-1]){
                int temp = array[index];
                array[index] = array[index-1];
                array[index-1] = temp;
                index--;
            }
        }
        return array;
    }
}