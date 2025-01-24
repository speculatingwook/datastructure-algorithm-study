package org.speculatingwook.sort;

public class HeapSort implements Sort{
    @Override
    public int[] sort(int array[]) {
        int n = array.length;

        // 힙을 먼저 만듭니다.
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // 힙에서 요소를 하나씩 뽑아 정렬합니다.
        for (int i = n - 1; i >= 0; i--) {
            // 최대 힙에서는 최대값을 맨 뒤로 보내고 힙 크기를 줄입니다.
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // 힙의 범위를 다시 조정하여 힙 속성을 유지합니다.
            heapify(array, i, 0);
        }
        return array;
    }

    // 주어진 배열을 힙으로 만드는 메소드입니다.
    void heapify(int arr[], int n, int i) {
        int largest = i; // 루트 노드
        int left = 2 * i + 1; // 왼쪽 자식 노드
        int right = 2 * i + 2; // 오른쪽 자식 노드

        // 왼쪽 자식이 루트보다 크다면 largest를 왼쪽으로 변경합니다.
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // 오른쪽 자식이 루트보다 크다면 largest를 오른쪽으로 변경합니다.
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // largest가 변경되었다면 해당 노드와 루트를 교환합니다.
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // 재귀적으로 힙을 만들어 나갑니다.
            heapify(arr, n, largest);
        }
    }
}