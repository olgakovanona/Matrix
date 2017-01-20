package com.company;

import java.util.Arrays;
import java.util.NavigableMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       /*// 8. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз.
        Scanner input = new Scanner(System.in); // Объявляем Scanner
        System.out.println("Enter array length: ");
        int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        int array[][] = new int[size][size]; // Создаём массив int размером в size
        System.out.println("Insert array elements:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = input.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");  // print matrix from top to bottom
                // System.out.print(array[j][i] + "\t"); // print matrix from left to right

            }
            System.out.println(); // Переходим на следующую строку
        }


    }
}
*/
        Scanner input = new Scanner(System.in);
        System.out.println("Input size of the matrix: ");
        int size = input.nextInt();
        int[][] matrix = new int[size][size];
        fillMatrix(matrix, size);
        System.out.println("Generated matrix: ");
        printMatrix(matrix, size);
        sumElemMatrixBetweenNegativeElem();
        matrixInIncreaseOrder(matrix, size);
        matrixShifted(matrix, size);
        countMaxAmoutIncElem(matrix, size);
        rotateMatrix90(matrix, size);
        System.out.println("Rotated matrix to 90: ");
        printMatrix(matrix, size);
        rotateMatrix90(matrix, size);
        System.out.println("Rotated matrix to 180: ");
        printMatrix(matrix, size);
        rotateMatrix90(matrix, size);
        System.out.println("Rotated matrix to 270: ");
        printMatrix(matrix, size);
        System.out.println("Matrix with Zero elements in the end of each row: ");
        matrixWithZeroElemInTheEnd(matrix, size);
        printMatrix(matrix, size);
        matrixWithMinesAvr(matrix, size);
        printMatrix(matrix, size);
        matrixWithoutZeroRowAndCol();


    }

    //9.7. Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
    private static void matrixWithoutZeroRowAndCol() {
        int N = 6;
        boolean zero = false;
        int n = N, m = N;
        int[][] newmatrix = new int[][]{
                {1, 0, 3, 4, 8, 0},
                {0, 0, 0, 0, 0, 0},
                {8, 0, 3, 0, 0, 0},
                {9, 0, 0, 4, 0, 0},
                {4, 0, 0, 0, 5, 0},
                {11, 0, 0, 0, 0, 0}};

        // Delete row with zero elements
        for (int i = 0; i < n; i++) {
            zero = true;
            for (int j = 0; j < m; j++)
                if (newmatrix[i][j] != 0) {
                    zero = false;
                    break;
                }
            if (zero) {
                for (int k = i; k < (n - 1); k++)
                    for (int j = 0; j < m; j++)
                        newmatrix[k][j] = newmatrix[k + 1][j];
                --i;
                --n;
            }
        }

        // Delete column with zero elements
        for (int j = 0; j < m; j++) {
            zero = true;
            for (int i = 0; i < n; i++)
                if (newmatrix[i][j] != 0) {
                    zero = false;
                    break;
                }
            if (zero) {
                for (int k = j; k < (m - 1); k++)
                    for (int i = 0; i < m; i++)
                        newmatrix[i][k] = newmatrix[i][k + 1];
                --j;
                --m;
            }
        }
        System.out.println("Matrix without zero row or col: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(newmatrix[i][j] + " ");
            }
             System.out.println();
        }
    }

    //9.8. Преобразовать строки матрицы таким образом, чтобы элементы, равные нулю, располагались после всех остальных.

    static void matrixWithZeroElemInTheEnd(int[][] matrix, int size) {

        for (int i = 0; i < matrix.length; i++) {
            int n = 0;
            int[] temp = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 0) {
                    temp[n++] = matrix[i][j];
                }
            }
            matrix[i] = Arrays.copyOf(temp, temp.length);
        }
    }

    // 9.6 Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.

    public static double matrixAvr(double[][] matrix) {
        double sum = 0;
        double avr = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sum += matrix[i][j];

            }
            avr = sum / matrix.length;
        }
        return avr;
    }

    public static int[][] matrixWithMinesAvr(int[][] matrix, int avr) {
        System.out.println("Arithmetic average of generated matrix: " + avr);
        System.out.println("Matrix with elements-average: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] -= avr;
            }
        }
        return matrix;
    }

// 9.5. Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.

    private static int[][] rotateMatrix90(int[][] matrix, int size) {

        for (int i = 0; i < size / 2; i++) {
            for (int j = i; j < size - 1 - i; j++) {
                int x = matrix[i][j];
                matrix[i][j] = matrix[j][size - 1 - i];
                matrix[j][size - 1 - i] = matrix[size - 1 - i][size - 1 - j];
                matrix[size - 1 - i][size - 1 - j] = matrix[size - 1 - j][i];
                matrix[size - 1 - j][i] = x;
            }
        }
        return matrix;
    }

//  9.4. Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки.

    private static void sumElemMatrixBetweenNegativeElem() {
        int[][] matrix2 = new int[][]{
                {1, 0, -3, 4, -9, 0},
                {0, -2, -1, 0, 0, 0},
                {-8, 1, -3, 0, 0, 0},
                {9, 0, 0, -4, 0, -1},
                {-4, 2, 1, 0, -5, 0},
                {11, -3, 3, 4, 0, -1}};

        int indexStartj = 0;
        int indexEndj = 0;

        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {

                if (matrix2[i][j] < 0) {
                    indexStartj = j;
                    System.out.println("1st negative number: " + matrix2[i][indexStartj]);
                    break;

                }
            }

            for (int j1 = indexStartj + 1; j1 < matrix2[i].length; j1++) {
                if (matrix2[i][j1] < 0) {
                    indexEndj = j1;
                    System.out.println("2nd negative number: " + matrix2[i][indexEndj]);
                    break;

                }
            }

            int sum = 0;
            for (int l = indexStartj + 1; l < indexEndj; l++)
                sum += matrix2[i][l];
            {
                System.out.println("Sum elements: " + sum);
            }
        }
    }
// 9.3. Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.

    private static void countMaxAmoutIncElem(int[][] matrix, int size) {
        int count = 0;
        int deccount = 0;
        int max = 0;
        int min = 0;
        int index = 0;
        int decindex = 0;
        int[] vector = new int[size * size];
        for (int i = 0; i < matrix.length; i++)       //trasform the matrix to vector
            for (int j = 0; j < matrix[i].length; j++)
                vector[i * size + j] = matrix[i][j];

        for (int k = 0; k < vector.length - 1; k++) {
            if (vector[k] < vector[k + 1]) {
                count++;
                if (count > max) {
                    max = count;
                    index = k + 1;   // save an index of the element
                }
            } else {
                count = 0;            // breake the sequence
            }
            if (vector[k] > vector[k + 1]) {
                deccount++;
                if (deccount > min) {
                    min = deccount;
                    decindex = k + 1;   // save an index of the element
                }
            } else {
                deccount = 0;            // breake the sequence
            }
        }

        System.out.println("Max sequence of increase digits: ");
        int[] sequence = new int[max + 1];
        System.arraycopy(vector, (index - max), sequence, 0, (max + 1));//copy the sequence of the max elements to new array
        System.out.println(Arrays.toString(sequence) + " " + (max + 1) + " " + "elements");
        System.out.println("Max sequence of decrease digits: ");
        int[] decsequence = new int[min + 1];
        System.arraycopy(vector, (decindex - min), decsequence, 0, (min + 1));//copy the sequence of the max elements to new array
        System.out.println(Arrays.toString(decsequence) + " " + (min + 1) + " " + "elements");

    }

//9.2. Выполнить циклический сдвиг заданной матрицы на k позиций вправо(влево, вверх, вниз).

    private static void matrixShifted(int[][] matrix, int size) {
        int[][] matrixShifted = new int[size][size];
        int k = 1;
        int knew = size - k % size;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrixShifted[i][(j + k) % size] = matrix[i][j]; //shift to the right
                //matrixShifted[i][(j+knew)%size] = matrix[i][j]; //shift to the left
                //matrixShifted[(i+knew)%size][j] = matrix[i][j]; //shift to the bottom
                //matrixShifted[(i + k) % size][j] = matrix[i][j]; //shift to the top
            }
        }

        System.out.println("Matrix shifted to the right: ");
        for (int i = 0; i < matrixShifted.length; i++) {   //print the sorted matrix
            for (int j = 0; j < matrixShifted[i].length; j++) {
                System.out.print(matrixShifted[i][j] + "\t");
            }
            System.out.println();
        }

    }

// 9.1. Упорядочить строки (столбцы) матрицы в порядке возрастания значений.

    private static void matrixInIncreaseOrder(int[][] matrix, int size) {
        int[] vector = new int[size * size];
        int[][] matrixSorted = new int[size][size];
        int n = 0;
        for (int i = 0; i < matrix.length; i++)       //trasform the matrix to vector
            for (int j = 0; j < matrix[i].length; j++)
                vector[i * size + j] = matrix[i][j];
        //System.out.println(Arrays.toString(vector));
        Arrays.sort(vector);                              //sort the vector
        //System.out.println(Arrays.toString(vector));
        for (int i1 = 0; i1 < matrixSorted.length; i1++) {      //transform the vector to matrix back
            for (int j1 = 0; j1 < matrixSorted[i1].length; j1++) {
                matrixSorted[i1][j1] = vector[n];
                n++;
            }
        }
        System.out.println("Matrix in increase order: ");
        for (int i = 0; i < matrixSorted.length; i++) {   //print the sorted matrix
            for (int j = 0; j < matrixSorted[i].length; j++) {
                System.out.print(matrixSorted[i][j] + "\t");
            }
            System.out.println();
        }

    }

// 9. a [n] [n]. Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.

    private static int[][] fillMatrix(int[][] matrix, int size) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 2 * size - size);
            }
        }
        return matrix;
    }

    private static int[][] printMatrix(int[][] matrix, int size) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        return matrix;
    }

}

