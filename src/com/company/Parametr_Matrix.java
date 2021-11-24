package com.company;

import java.util.Arrays;
import java.util.Objects;

public class Parametr_Matrix<E extends Number> {
    private int row; // количество строк
    private int col; // количество столбцов
    private Object[][] array;   // двумерный массив (матрица)

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setArray(Object[][] array) {
        this.array = array;
    }

    /*public Matrix(int n, int m , int k) {
        row = n;
        col = m;
        array = new int[row][col];
        for (int[] arr : array) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 0;
            }
        }
    }*/


    // Первый конструктор
    public Parametr_Matrix(int n, int m) {
        row = n;
        col = m;
        array = new Object[row][col];
    }

    // Второй конструктор
    public Parametr_Matrix(Object[][] ar) {
        array =  ar;
        row = array.length;
        col = array[0].length;
    }

    // Первый пустой конструктор
    public Parametr_Matrix() {
        row = 0;
        col = 0;
        array = new Object[row][col];
    }

    // для копии матрицы
    public Parametr_Matrix(Parametr_Matrix matrix) {
        this.array =  matrix.getMatrix();
        row = array.length;
        col = array[0].length;
    }

    public Object[][] getMatrix() {
        return array;
    }


    // Метод вычисления размерности матрицы
    public void sizeMatrix() {
        System.out.println("Размерность матрицы: " + row +"×"+col);
    }

    public void get_Element(int row, int col){
        System.out.println("Элемент под индексом " + row + "," + col + " = " + (E)array[row-1][col-1]);
    }
    public void get_row(int row){
        System.out.print("Ряд"+row+": ");
        for (int i = 0; i<array[row-1].length; i++){
            System.out.print(array[row-1][i]+ " ");
        }
        System.out.print("\n");
    }

    public void get_col(int col){
        System.out.print("Столбец"+col+": ");
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i][col-1]+ " ");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parametr_Matrix matrix = (Parametr_Matrix) o;
        return row == matrix.row && col == matrix.col && Arrays.equals(array, matrix.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(row, col);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }



    public void Upper_triangle_matrix1(){
        double mu = 0;
        for (int k=0;k<array.length;k++)
        {
            for (int i=k+1;i<array.length;i++)
            {
                mu =  ((double)array[i][k]/(double)array[k][k]);
                for (int j=0;j<array.length;j++)
                    array[i][j] =(double)array[i][j] -((double)array[k][j] * mu);
            }
        }
    }

    public void Lower_triangle_matrix2() {
        double mu = 0;
        for (int k = array.length - 1; k >= 0; k--) {
            for (int i = k - 1; i >= 0; i--) {
                mu =  ((double)array[i][k] / (double)array[k][k]);
                for (int j = array.length - 1; j >= 0; j--)

                    array[i][j] =(double)array[i][j] -((double)array[k][j] * mu);
            }
        }
    }


    public  void fillMatrix() {
        for (Object[] arr : array) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] =  (Math.random() * 9 + 1);
            }
        }
    }

    public  void printMatrix() {
        for (int i = 0; i <array.length; i++)
            for (int j = 0; j < array.length; j++) {
                System.out.print((E) array[i][j] + "\t");
                if (j == array[0].length - 1) System.out.println();
            }
    }
}
