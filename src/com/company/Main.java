package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/////////////////////////////   Основное ДЗ  ///////////////////////////////////
        System.out.println();
        System.out.println("         Основное ДЗ           ");
        String[][] data = {
                {"БИШКЕК", "8:170.0;10:500.0;30:800.0;50:3495.0->1.0:-1.0"},
                {"ОШ", "8.0:350.0;10.0:900.0;30.0:2460.0;50.0:4926.0->1.0:-1.0"},
                {"АЛМАТЫ", "0.3:650.0;0.5:750.0->1.0:430.0"},
                {"ШЫМКЕНТ", "0.3:700.0;0.5:750.0->1.0:430.0"},
                {"МОСКВА", "0.5:1130.14->1.0:160.0"},
                {"САНКТ-ПЕТЕРБУРГ", "0.5:856.98->1.0:231.53"},
                {"ЛОНДОН", "0.5:2900.0->1.0:500.0"},
                {"МАДРИД", "0.5:3000.0->1.0:700.0"},
        };
        System.out.print("Введите вес товара в килограммах: ");
        double weight = scanner.nextDouble();
        System.out.println("Введите код города из нижеперечисленных");
        for (int i = 0; i < data.length; i++) {
            System.out.println(i + " " + data[i][0]);
        }
        int city_id = scanner.nextInt();

        double eachNextPrice = Double.parseDouble(getEachNextPriceArr(data[city_id][1]));

        String[] arr = getArr(city_id);
        char j = ';';
        int k = 0, i = 0;
        while (data[city_id][1].indexOf("-") != k) {
            if (data[city_id][1].charAt(k) == j) {
                ++i;
                ++k;
            }
            arr[i] += data[city_id][1].charAt(k);
            k++;
        }
        i = 0;
        j = ':';
        double intervalWeight, intervalPrice;
        while (i < arr.length) {
            k = arr[i].indexOf(j);
            intervalWeight = Double.parseDouble(arr[i].substring(0, k));
            intervalPrice = Double.parseDouble(arr[i].substring(k + 1, arr[i].length()));
            if (weight <= intervalWeight) {
                System.out.println("ЦЕНА = " + intervalPrice);
                break;
            } else {
                if (i == arr.length - 1 && eachNextPrice == -1) {
                    System.out.println("Невозможно просчитать цену.");
                    break;
                } else {
                    if (i == arr.length - 1) {
                        System.out.println("ЦЕНА = " + (intervalPrice + (weight - intervalWeight) * eachNextPrice));
                    }
                }
            }
            ++i;
        }

//////////////////////////////////////// Доп ДЗ-1 //////////////////////////////////////////////

        System.out.println();
        System.out.println("         Доп ДЗ-1          ");
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        int revert_number = 0;
        while (number >= 1) {
            revert_number = revert_number * 10 + number % 10;
            number /= 10;
        }
        System.out.println(revert_number);

////////////////////////////////////// Доп ДЗ-2 //////////////////////////////////////////////

        System.out.println();
        System.out.println("         Доп ДЗ-2          ");
        int[] array = {9, 2, 1, 4, 3, 7, 2, 5};
        int pre_max_num = getPreMaxNum(array);
        System.out.println("Второе максимальное число: " + pre_max_num);

////////////////////////////////////// Доп ДЗ-3 //////////////////////////////////////////////
        System.out.println();
        System.out.println("         Доп ДЗ-3          ");
        System.out.print("Введите начальный диапазон: ");
        int from = scanner.nextInt();
        System.out.print("Введите конечный диапазон: ");
        int to = scanner.nextInt();
        while (from <= to) {
            if (from >= 1)
                System.out.print(from + " ");
            from++;
        }

    }

    private static int getPreMaxNum(int[] array) {
        int pre = 0; //  array = {9,2,1,4,3,7,2,5};
        int max = array[0];
        for (int j = 0; j < array.length - 1; j++) {
            if (max < array[j + 1]) {
                pre = max;
                max = array[j + 1];
            }
        }
        for (int i1 : array) {
            if (pre < i1 && i1 != max) {
                pre = i1;
            }
        }
        return pre;
    }

    private static String getEachNextPriceArr(String line) {
        int indexOf = line.indexOf("->1.0:") + "->1.0:".length();
        return line.substring(indexOf, line.length());
    }

    private static String[] getArr(int id) {
        int[] index = {4, 4, 2, 2, 1, 1, 1, 1};
        String[] arr = new String[index[id]];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "";
        }
        return arr;
    }

}
