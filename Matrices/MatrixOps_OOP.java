import java.util.Scanner;

public class Matrix_Ops {
    public static void main(String[] args){

        // Define variables for rows and columns selection
        int rows = 0;
        int cols = 0;

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // TODO: Get rows and columns and validate the inputs

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
        mat = new int [rows][columns];

        // TODO: Initialize mat
    }

    void printMatrix() {
        // TOOD: Print out matrix mat
    }

    Matrix transpose() {
        // Create the matrix, mtran, that will hold the results
        Matrix mtran = new Matrix(mat[0].length, mat.length);

        // TODO: Transpose matrix mat into matrix mtran and return mtran
        return mtran;
    }

    Matrix columnSum() {
        // Create the matrix, mcolsum, that will hold the results-this matrix has 1 row
        // Initialize each element of mcolsum to 0 using the appropriate constructor
        Matrix mcolsum = new Matrix(1, mat[0].length, 0);

        // TODO: Sum the columns of matrix mat into matrix mcolsum and return mcolsum
        return mcolsum;
    }

    Matrix reverseRows() {
        // Create the matrix, mrev, that will hold the results
        Matrix mrev = new Matrix(mat.length, mat[0].length);

        // TODO: Reverse the rows of matrix mat into matrix mrev and return mrev
        return mrev;
    }
}
