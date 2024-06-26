package Binary_Search.Set_3;

import java.util.Scanner;

class Q01_Allocate_minimum_number_of_pages {

    // Function to find minimum number of pages.
    public static int findPages(int[] A, int N, int M) {
        // no of student < no of books
        if (N < M)
            return -1;

        // find max & sum of total pages
        // i.e min range should be max of pages.
        // & max range of should be sum of pages

        int max = 0;
        int sum = 0;
        for (int num : A) {
            max = Math.max(max, num);
            sum += num;
        }

        int start = max;
        int end = sum;
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isValid(A, mid, M)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    // to getMax pages with respect to student is valide or not
    public static boolean isValid(int[] arr, int max, int k) {
        int student = 1;
        int sum = 0;
        for (int num : arr) {
            sum += num;
            if (sum > max) {
                student += 1;
                sum = num;
            }
            if (student > k) {
                return false;
            }
        }
        return true;
    }


    class Solution2 {
        //Function to find minimum number of pages.
        public int findPages(int[] books, int totalBooks, int students) {
            if (books == null || books.length == 0 || totalBooks < students) {
                return -1;
            }
            int low = 0;
            int high = 0;
            for (int num : books) {
                low = Math.max(low, num);
                high += num;
            }

            int answer = -1;
            while (low <= high) {
                int mid = (low + high) / 2;

                if (isPossibleToDistribute(books, mid, students)) {
                    answer = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return answer;
        }


        public boolean isPossibleToDistribute(int[] books, int pageLimit, int students) {
            int studentCount = 1;
            int pages = books[0];
            for (int i = 1; i < books.length; i++) {
                if (pages + books[i] <= pageLimit) {
                    pages += books[i];
                } else {
                    studentCount += 1;
                    pages = books[i];
                }

                if (studentCount > students) {
                    return false;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    }
}