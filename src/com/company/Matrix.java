package com.company;

import java.util.Arrays;
import java.util.Objects;

class Matrix implements Cloneable{
    private int row; // количество строк
    private int col; // количество столбцов
    private int[][] array;   // двумерный массив (матрица)

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

    public void setArray(int[][] array) {
        this.array = array;
    }


    // Первый конструктор
    public Matrix(int n, int m) {
        row = n;
        col = m;
        array = new int[row][col];
    }

    // Второй конструктор
    public Matrix(int ar[][]) {
        array = ar;
        row = array.length;
        col = array[0].length;
    }

    // Первый пустой конструктор
    public Matrix() {
        row = 0;
        col = 0;
        array = new int[row][col];
    }

    // для копии матрицы
    public Matrix(Matrix matrix) throws CloneNotSupportedException {
        int[][] copy = new int[matrix.getMatrix().length][];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = new int[matrix.getMatrix()[i].length];
            System.arraycopy(matrix.getMatrix()[i], 0, copy[i], 0, matrix.getMatrix()[i].length);
        }
        this.array =copy;
        this.col = matrix.col;
        this.row = matrix.row;
    }

    public int[][] getMatrix() {
        return array;
    }


    // Метод вычисления размерности матрицы
    public void sizeMatrix() {
        System.out.println("Размерность матрицы: " + row +"×"+col);
    }

    public void get_Element(int row, int col){
        System.out.println("Элемент под индексом " + row + "," + col + " = " + array[row-1][col-1]);
    }

    public void set_Element(int row, int col, int value){
        array[row-1][col-1] = value;
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
        Matrix matrix = (Matrix) o;
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
                mu = (double) array[i][k]/array[k][k];
                for (int j=0;j<array.length;j++)
                    array[i][j]-=array[k][j]*mu;
            }
        }
    }

    public void Lower_triangle_matrix2() {
        double mu = 0;
        for (int k = array.length - 1; k >= 0; k--) {
            for (int i = k - 1; i >= 0; i--) {
                mu = (double) array[i][k] / array[k][k];
                for (int j = array.length - 1; j >= 0; j--)
                    array[i][j] -= array[k][j] * mu;
            }
        }
    }


    public  void fillMatrix() {
        for (int[] arr : array) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 9 + 1);
            }
        }
    }

    public  void printMatrix() {
        for (int i = 0; i <array.length; i++)
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
                if (j == array[0].length - 1) System.out.println();
            }
        System.out.println();
    }

    @Override
    public Matrix clone() throws CloneNotSupportedException {
        return (Matrix) super.clone();
    }

}
