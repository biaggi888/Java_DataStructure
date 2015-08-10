package com._33oy.datastructure;

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
    for (int i = 0; i < n; i++) {
      a[i] = (int) (Math.random() * 1000);
      System.out.print(" No. " + (i + 1) + "=" + a[i]);
      if (i % 10 == 0) {
        System.out.println("");
      }
    }
    sort(a);
    System.out.println(a.toString());
    System.out.println("Enter an number to search :");
  }

  public static void sort(int[] a) {
    int len = a.length;
    for (int i = 0; i < len - 1; i++) {
      int min = i;
      for (int j = 0; j < len; j++) {
        if (a[j] < a[min]) {
          min = j;
        }
      }
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
