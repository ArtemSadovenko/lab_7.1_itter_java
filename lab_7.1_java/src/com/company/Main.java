package com.company;


import java.util.Random;

public class Main {

    public static void  create(int[][] a, int col, int row, int l, int h) {
        Random rn = new Random();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                a[i][j] = l + rn.nextInt() % (h - l + 1);
            }
        }
    }


        public static void print(int[][] a, int row, int col ) {
        for (int i = 0; i < row; i++) {
            System.out.print("|");
            for (int j = 0; j < col; j++) {
                System.out.printf("%4d" ,a[i][j]);

            }
            System.out.print( "|");
            System.out.println();
        }
        System.out.println();
    }

    public static void Tsort(int[][] a, int row, int col) {
        for (int i0 = 0; i0 < row - 1; i0++)
            for (int i1 = 0; i1 < row - i0 - 1; i1++)
                if ((a[i1][0] > a[i1 + 1][0])
                        ||
                        (a[i1][0] == a[i1 + 1][0] &&
                                a[i1][1] > a[i1 + 1][1])
                        ||
                        (a[i1][0] == a[i1 + 1][0] &&
                                a[i1][1] == a[i1 + 1][1] &&
                                a[i1][3] < a[i1 + 1][3]))
                    change(a, i1, i1 + 1, col);
    }

    public static void change(int[][] a, int i1, int i2, int col) {
        int k;
        for (int i = 0; i < col; i++) {
            k = a[i1][i];
            a[i1][i] = a[i2][i];
            a[i2][i] = k;
        }
    }

    public static int sum(int[][] a, int row, int col) {
        int s = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ( !(a[i][j] % 2 == 0)
                        ||
                        !(a[i][j] < 0) ) {
                    s += a[i][j];
                    a[i][j] = 0;
                }
            }
        }
        return s;
    }

    public static int amou(int[][] a, int row, int col) {
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ( !(a[i][j] % 2 == 0)
                        ||
                        !(a[i][j] < 0) ) {
                    k++;
                }
            }
        }
        return k;
    }


    public static void main(String[] args) {
        int row = 7;
        int col = 6;
        int k;
        int s;
        int l = -12;
        int h = 23;

        int[][] X = new int[row][col];



        create(X, col, row, l, h);

        print(X, row, col);

        Tsort(X, row, col);

        print(X, row, col);

        k = amou(X, row, col);
        s = sum(X, row, col);

        print(X, row, col);

        System.out.println("sum = " + s );
        System.out.println("amount = " + k);
    }

}

