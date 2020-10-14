package hw15;

import java.util.Scanner;

public class Matrix_Ops {
    public static void main(String[] args){

        // Define variables for rows and columns selection
        int rows = 0;
        int cols = 0;

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the number of rows in the matrix (between 1 and 4): ");
            rows = input.nextInt();
            if (rows >= 1 && rows <= 4) {
                System.out.println("Enter the number of columns in the matrix (between 1 and 4): ");
                cols = input.nextInt();
                while (true) {
                    if (cols >= 1 && cols <= 4) {
                        break;
                    }
                    else {
                        System.out.print("Invalid number of columns, try again!");
                    }
                }
                break;
            }
            else {
                System.out.print("Invalid number of rows, try again!");
            }
        }

        // Create a matrix object using the Matrix class 
        Matrix m1 = new Matrix(rows, cols);
        

        // Print the newly created matrix, m1
        m1.printMatrix();

        // Create matrix objects for the transposed, column summed, 
        // and reversed rows results:
        Matrix tmat, cmat, rmat;

        // Display menu, get user's menu selection, and call the 
        // appropriate instance method in the Matrix class
        String userInput = " ";
        do {
            printMenu();
            userInput = input.next().toUpperCase();
            System.out.println();

            switch(userInput) {
            case("T"): 
                tmat = m1.transpose();
                tmat.printMatrix();
                break; 
            case("C"): 
                cmat = m1.columnSum();
                cmat.printMatrix();
                break; 
            case("R"): 
                rmat = m1.reverseRows();
                rmat.printMatrix();
                break; 
            case("P"): 
                m1.printMatrix();
                break;
            case("Q"): 
                System.out.println("\n  Exiting.\n");
                input.close();
                break;
            default:
                System.out.println("\n  Error, invalid input.");
                break;
            }
        } while (!userInput.equals("Q"));
    }

    public static void printMenu() {
        System.out.println("\n");
        System.out.println("______________________________________________________________________\n");
        System.out.println("  T transpose   - Rows become colums (and vice versa)");
        System.out.println("  C columnSum   - Caclulate the sum of the values in each column");
        System.out.println("  R reverseRows - Reverse all elements in every row of the matrix");
        System.out.println("  P printMatrix - Print the original matrix");
        System.out.println("  Q quit        - Exit the program");
        System.out.println("______________________________________________________________________\n");

        System.out.print("\n  Enter: T, C, R, P, or Q =>  ");
    }     
}


class Matrix  {
    int[][] mat;  // mat is declared as an instance variable (note no 'static' keyword)
    
    
    // Constructor that initializes the matrix to 0 1 2, then 10 11 12, then 20 21 22, ...
    Matrix(int rows, int columns) {
        this.mat = new int [rows][columns];

        for (int i = 0; i < rows; i++) {
            int mp = i*10;
            for (int j = 0; j < columns; j ++) {
                this.mat[i][j] = mp + j;
            }
        }
    }
    
    /* --> next assignment
    // Constructor that initializes the entire matrix to the value passed in.
    Matrix(int row, int column, int value) {
        this.mat = new int [row][column];

        // TODO: Initialize mat with value
    }
    */
    
    void printMatrix() {
    	System.out.println();
        for (int row = 0; row < this.mat.length; row++) {
            for (int column = 0; column < this.mat[row].length; column++) {
                System.out.printf("%3d", this.mat[row][column]);
                System.out.print("   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    Matrix transpose() {
        // Create the matrix, mtran, that will hold the results
        Matrix mtran = new Matrix(this.mat[0].length, this.mat.length);

        int row = this.mat[0].length;
        int column = this.mat.length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                mtran.mat[r][c] = this.mat[c][r];
            }
        }
        return mtran;
    }

    Matrix columnSum() {
        // Create the matrix, mcolsum, that will hold the results-this matrix has 1 row
        // Initialize each element of mcolsum to 0 using the appropriate constructor
        Matrix mcolsum = new Matrix(1, mat[0].length);

        int columnz = this.mat[0].length;

        for (int column = 0; column < (columnz); column++) {
            int sums = 0;
            for (int row = 0; row < (this.mat.length); row++) {
                sums += this.mat[row][column]; 
            }
            mcolsum.mat[0][column] = sums;
        }
        return mcolsum;
    }

    Matrix reverseRows() {
        // Create the matrix, mrev, that will hold the results
        Matrix mrev = new Matrix(this.mat.length, this.mat[0].length);

        int row = this.mat.length;
        int column = this.mat[0].length;

        for (int r = 0; r < row; r++){
            for (int c = 0; c < column; c++ ){
                mrev.mat[r][(column - 1) - c] = this.mat[r][c];           
            }
        }
        return mrev;
    }
}