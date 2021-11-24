package com.company;

class MatrixTest {
    public static void main(String[] args) throws CloneNotSupportedException {




        Matrix matrix = new Matrix(4,4);
        matrix.fillMatrix();
        Matrix matrix1 = new Matrix(matrix);
        matrix.printMatrix();
        matrix1.printMatrix();
        matrix1.set_Element(1,1,1000);
        matrix1.printMatrix();
        matrix.printMatrix();


        //create_diagonal_matrix2(new int[]{1,2,3});
    }




    // Метод заполнения массива случайными числами от 1 до 9
    public static void fillMatrix(Matrix matrix) {
        for (int[] arr : matrix.getMatrix()) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 9 + 1);
            }
        }
    }

    // Метод вывода массива на консоль
    public static void printMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.getMatrix().length; i++)
            for (int j = 0; j < matrix.getMatrix()[0].length; j++) {
                System.out.print(matrix.getMatrix()[i][j] + "\t");
                if (j == matrix.getMatrix()[0].length - 1) System.out.println();
            }
    }

   /* public static void create_diagonal_matrix(int ar[], Matrix matrix) {
        int j =0;
        int k =0;
        for (int i = 0; i< ar.length;i++){
            if(j==matrix.getMatrix().length ) break;
            matrix.getMatrix()[j][k] = ar[i];
            j++;
            k++;
            }
    }*/


    public static void create_diagonal_matrix1(int ar[], Matrix matrix)
    {
            for (int j =0;j<matrix.getMatrix().length; j++){
                for (int k =0; k<matrix.getMatrix()[j].length; k++){
                    if(j == k){
                        matrix.getMatrix()[j][k] = ar[j];
                    }
                    else  matrix.getMatrix()[j][k] = 0;
                }
            }

    }


    public static void create_diagonal_matrix2(int ar[])
    {
        int len = ar.length;
        int[][] array = new int[len][len];
        for (int j =0;j<len; j++){
            for (int k =0; k<len; k++){
                if(j == k){
                    array[j][k] = ar[j];
                }
                else  array[j][k] = 0;
            }
        }
        for (int i = 0; i <array.length; i++)
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
                if (j == array[0].length - 1) System.out.println();
            }
    }

}
