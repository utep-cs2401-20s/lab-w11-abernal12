/* The algorithm in comments
 * 1. first we set a specific size that we would want the array to be to sorted in.
 * 2. if the array is less than the given size, then we sort the array using recursive Quicksort.
 * 3. else, if the array still tends to be longer than the given size,
 * 4. we will call the method newSort of the left half of the array
 * and also call the method newSort of the right half of the array
 * along with the mergeSortedHalves method on the two sorted halves of the array.
 */
class newSort {
    public void newSort(int[] A, int size) {
        size = 4; // setting the minimum size of the array needed.
        // base case 1
        if (A.length <= size) { // if the array is less than or equal to the size(4)...
            int left = 0; // set left equal to the start of the array
            int right = A.length - 1; // quickSort(A, right, left); // use quick sort to sort the array
            recursiveQuickSort(A, left, right);
        } else {
            int mid = A.length / 2; // sets the middle of the array
            int[] L = new int[mid]; // sets the left side of the array
            int[] R = new int[A.length - mid]; // sets the right side of the array wich will start from after the mid
        }


//        for (int i = 0; i < L.length; i++) {
//            L[i] = A[i]; //
//        }
//        for (int j = 0; j < R.length; j++) {
//            R[j] = A[j];
//        }
    }

    void recursiveQuickSort(int[] A, int right, int left) {
        int index = partition(A, left, right);

        if (left < index - 1) {
            recursiveQuickSort(A, left, index - 1);
        }

        if (right > index) {
            recursiveQuickSort(A, index, right);
        }
    }

    int partition(int[] A, int L, int R) {
        int pivot = A[L];

        while (L <= R) {
            while (A[L] < pivot) {
                L++;
            }
            while (A[R] > pivot) {
                R--;
            }
            if (L <= R) {
                int temp = A[L];
                A[L] = A[R];
                A[R] = temp;

                L++;
                R--;
            }
        }
        return L;
    }

    private void mergeSortedHalves(int[] result, int[] L, int[] R) {
        int i = 0; // will be used for the left half of the array
        int j = 0; // will be used for the right half of the array
        int k = 0; // will be used for the new array

        while (i < L.length && j < R.length) { // while the indexes at left and right arrays are less than or within the array
            if (L[i] > R[j]) { // if the index at L is greater than the index at R
                result[k] = R[i]; // set the result array at k equal to the R index to k
                j++; // once the int is set to the k we will iterate to the next index of R
            } else {
                result[k] = L[i]; // if the if statement above is not satisfied we will then set the result at k equal to the index at L
                i++; // once the int is set to the k we will iterate to the next index of L
            }
            k++; // every time we insert an element in the array of result, we will move the k position to the next empty array slot to fill it up
            if (j == R.length) { // if the index at j is equal to the R length...
                for (i = 0; i < L.length; i++) { // we will continue to iterate through the L array
                    result[k] = L[i]; // and begin to insert all of the elements left within the L array into the
                    k++; // after each element of the array that is inserted into the result array, we will move the k up
                }
                break;
            }
            if (i == L.length) { // if the index at i is equal to the length of the L length
                for (j = 0; j < R.length; i++) { // we will iterate through the R array
                    result[k] = L[i]; // and begin to add the remainder of the elements left in the R array
                    k++; // after each element of the array that is inserted into the result array, we will move the k up
                }
                break;
            }
        }

    }
}
// merge sort does not have to be recursive
// everything else needs to be recursive like quicksort and newsort
