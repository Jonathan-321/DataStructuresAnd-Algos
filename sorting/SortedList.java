import java.util.ArrayList;

public class SortedList<T extends Comparable<T>> extends ArrayList<T> {
    
    public void insertionSort() {
        for (int i = 1; i < size(); i++) {
            T key = get(i);
            int j = i - 1;
            while (j >= 0 && get(j).compareTo(key) > 0) {
                set(j + 1, get(j));
                j--;
            }
            set(j + 1, key);
        }
    }
    
    public void selectionSort() {
        for (int i = 0; i < size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size(); j++) {
                if (get(j).compareTo(get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            T temp = get(i);
            set(i, get(minIndex));
            set(minIndex, temp);
        }
    }
    
    public void quickSort() {
        quickSortHelper(0, size() - 1);
    }
    
    private void quickSortHelper(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSortHelper(low, pivotIndex - 1);
            quickSortHelper(pivotIndex + 1, high);
        }
    }
    
    private int partition(int low, int high) {
        T pivot = get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (get(j).compareTo(pivot) <= 0) {
                i++;
                T temp = get(i);
                set(i, get(j));
                set(j, temp);
            }
        }
        T temp = get(i + 1);
        set(i + 1, get(high));
        set(high, temp);
        return i + 1;
    }
    
    public void mergeSort() {
        mergeSortHelper(0, size() - 1);
    }
    
    private void mergeSortHelper(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(left, mid);
            mergeSortHelper(mid + 1, right);
            merge(left, mid, right);
        }
    }
    
    private void merge(int left, int mid, int right) {
        ArrayList<T> temp = new ArrayList<>(right - left + 1);
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (get(i).compareTo(get(j)) <= 0) {
                temp.add(get(i));
                i++;
            } else {
                temp.add(get(j));
                j++;
            }
        }
        while (i <= mid) {
            temp.add(get(i));
            i++;
        }
        while (j <= right) {
            temp.add(get(j));
            j++;
        }
        for (int k = 0; k < temp.size(); k++) {
            set(left + k, temp.get(k));
        }
    }

}