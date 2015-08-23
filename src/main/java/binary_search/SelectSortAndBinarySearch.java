package binary_search;

import java.util.Scanner;

public class SelectSortAndBinarySearch
{
  private static final int MAX_SIZE = 101;
  public static void main(String[] args) {
    int[] a = null;
    System.out.println("Enter the number of numbers to generate :");
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if (n < 0 || n > MAX_SIZE) {
      System.out.println("Improper number !");
      System.exit(0);
    }
    a = new int[n];
    /*
     * for (int i = 0; i < n; i++) { a[i] = (int) (Math.random() * 1000);
     * System.out.print(" No. " + (i + 1) + "=" + a[i]); if (i % 10 == 0) {
     * System.out.println(""); } }
     */
    print(a);
    sort(a);
    System.out.println("\nAfter sort \n\n");
    print(a);

    System.out.println("\nEnter an number to search :");
    int x = in.nextInt();
    if (x == -1) {
      System.out.println("Not result !");
      System.exit(0);
    }
    System.out.println("\nNo. " + (x + 1) + a[x]);
  }

  public static void print(int[] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      a[i] = (int) (Math.random() * 1000);
      System.out.print(" No. " + (i + 1) + "=" + a[i]);
      if (i % 10 == 0) {
        System.out.println("");
      }
    }
  }

  public static void sort(int[] a) {
    int len = a.length;
    for (int i = 0; i < len - 1; i++) {
      int min = i;
      for (int j = i + 1; j < len; j++) {
        if (a[j] < a[min]) {
          min = j;
        }
      }
      // swap(a, i, min);
      int tmp = a[i];
      a[i] = a[min];
      a[min] = tmp;
    }
  }

  public static void swap(int[] list, int p1, int p2) {
    int temp = list[p1];
    list[p1] = list[p2];
    list[p2] = temp;
  }

  public static int compare(int x, int y) {
    if (x == y) {
      return 0;
    } else if (x > y) {
      return 1;
    } else {
      return -1;
    }
  }
  public static int binSearch(int value, int[] a) {
    int len = a.length;
    int left = 0, right = len - 1;
    while (left <= right) {
      int middle = (left + right) / 2;
      switch (compare(value, a[middle])) {
        case 0 :
          return middle;
        case -1 :
          right = middle - 1;
          break;
        case 1 :
          left = middle + 1;
          break;
      }

    }
    return -1;
  }
}
