package com.company;

class MatrixTest {
    public static void main(String[] args) {



        /*System.out.println("Матрица1: ");
        Matrix matrix1 = new Matrix(5, 5);
        fillMatrix(matrix1);
        printMatrix(matrix1);

        System.out.println("\n");
        Matrix matrix2 = new Matrix(matrix1);
        printMatrix(matrix2);


        matrix1.sizeMatrix();
        matrix2.get_Element(5,5);

        matrix2.get_row(1);
        matrix2.get_col(1);

        System.out.print(matrix1.equals(matrix2));

        ImmutableMatrix matrix4 = new ImmutableMatrix(4,7);
        fillMatrix(matrix4);
        printMatrix(matrix4);

        System.out.println("\n");
        ImmutableMatrix matrix5 = new ImmutableMatrix(matrix4);
        printMatrix(matrix5);*/
        Matrix matrix = new Matrix(4,4);
        matrix.fillMatrix();
        Matrix matrix1 = new Matrix(matrix);
        matrix1.Upper_triangle_matrix1();
        matrix1.printMatrix();




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

}
