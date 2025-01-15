import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.speculatingwook.sort.*;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class SortTest {
    private int[][] testArrays;
    private int[][] expectedArrays;

    @BeforeEach
    void setUp() {
        testArrays = new int[][] {
                {64, 34, 25, 12, 22, 11, 90}, // 일반적인 케이스
                {1}, // 단일 요소
                {}, // 빈 배열
                {1, 1, 1, 1}, // 동일한 요소들
                {1, 2, 3, 4, 5}, // 이미 정렬된 배열
                {5, 4, 3, 2, 1}, // 역순 정렬된 배열
                {-5, 0, -10, 8, 3, -1, 7}, // 음수 포함
                {Integer.MAX_VALUE, 0, Integer.MIN_VALUE} // 경계값
        };

        expectedArrays = new int[][] {
                {11, 12, 22, 25, 34, 64, 90},
                {1},
                {},
                {1, 1, 1, 1},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {-10, -5, -1, 0, 3, 7, 8},
                {Integer.MIN_VALUE, 0, Integer.MAX_VALUE}
        };
    }

    @Test
    void testBubbleSort() {
        Sort bubbleSort = new BubbleSort();
        runTestsForSort(bubbleSort, "버블 정렬");
        // 성능 테스트 - 큰 배열
        assertTimeout(Duration.ofSeconds(2), () -> {
            int[] largeArray = generateRandomArray(1000);
            bubbleSort.sort(largeArray);
        }, "버블 정렬 성능 테스트 실패");
    }

    @Test
    void testSelectionSort() {
        Sort selectionSort = new SelectionSort();
        runTestsForSort(selectionSort, "선택 정렬");
        // 동일 값이 많은 배열에서의 테스트
        int[] manyDuplicates = {1, 1, 1, 2, 2, 1, 1};
        assertArrayEquals(
                new int[]{1, 1, 1, 1, 1, 2, 2},
                selectionSort.sort(manyDuplicates),
                "선택 정렬: 중복값 처리 실패"
        );
    }

    @Test
    void testInsertionSort() {
        Sort insertionSort = new InsertionSort();
        runTestsForSort(insertionSort, "삽입 정렬");
        // 거의 정렬된 배열에서의 테스트
        int[] almostSorted = {1, 2, 4, 3, 5, 6};
        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5, 6},
                insertionSort.sort(almostSorted),
                "삽입 정렬: 거의 정렬된 배열 처리 실패"
        );
    }

    @Test
    void testQuickSort() {
        Sort quickSort = new QuickSort();
        runTestsForSort(quickSort, "퀵 정렬");
        // 피벗 선택이 최악인 경우 테스트
        int[] worstCase = {1, 2, 3, 4, 5};  // 이미 정렬된 배열
        assertTimeout(Duration.ofSeconds(1), () -> {
            quickSort.sort(worstCase);
        }, "퀵 정렬: 최악의 경우 성능 테스트 실패");
    }

    @Test
    void testMergeSort() {
        Sort mergeSort = new MergeSort();
        runTestsForSort(mergeSort, "병합 정렬");
        // 큰 배열에서의 안정성 테스트
        assertTimeout(Duration.ofSeconds(1), () -> {
            int[] largeArray = generateRandomArray(10000);
            mergeSort.sort(largeArray);
        }, "병합 정렬: 대규모 배열 처리 실패");
    }

    @Test
    void testHeapSort() {
        Sort heapSort = new HeapSort();
        runTestsForSort(heapSort, "힙 정렬");
        // 역순 배열에서의 테스트
        int[] reverse = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                heapSort.sort(reverse),
                "힙 정렬: 역순 배열 처리 실패"
        );
    }

    private void runTestsForSort(Sort sort, String sortName) {
        for (int i = 0; i < testArrays.length; i++) {
            int[] result = sort.sort(testArrays[i]);
            assertArrayEquals(
                    expectedArrays[i],
                    result,
                    String.format("%s: 테스트 케이스 %d 실패", sortName, i)
            );
        }
    }

    private int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}