package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите массив: ");
        try {
            int[] arr = readArray();
            System.out.printf("Количество минимумов\n: %d", getLocalMinCount(arr));
            System.out.println();
            System.out.printf("Количество максимумов\n: %d", getLocalMaxCount(arr));
        } catch (Exception ex) {
            System.out.println("Ошибка ввода");
            System.exit(1);
        }
    }

    private static int[] readArray() {
        Scanner in = new Scanner(System.in);
        String[] parts = in.nextLine().split(" ");
        int[] arr = new int[parts.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }

    private static int getLocalMinCount(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] < arr[i + 1]) {
                    count++;
                }
            } else if (i == arr.length - 1) {
                if (arr[i] < arr[i - 1]) {
                    count++;
                }
            } else {
                if (arr[i] < arr[i + 1] && arr[i] < arr[i - 1]) {
                    count++;
                }
            }
        }

        return count;
    }

    private static int getLocalMaxCount(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] > arr[i + 1]) {
                    count++;
                }
            } else if (i == arr.length - 1) {
                if (arr[i] > arr[i - 1]) {
                    count++;
                }
            } else {
                if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
                    count++;
                }
            }
        }

        return count;
    }
}

