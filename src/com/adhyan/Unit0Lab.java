package com.adhyan;

/** 
 * @author Adhyan Chandhoke
 * @date 08/06/2024
 * A program to compute the roots and vertex of a quadratic equation in the form ax^2 + bx + c. It takes coefficients a, b, and c as input from the user.
 */

import java.util.*;

public class Unit0Lab {

    /**
     * Main method
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Create a Scanner object to read from the standard input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the coefficient a
        System.out.println("Enter the a of ax^2 + bx + c");
        System.out.print("> ");
        double a = input.nextDouble();

        // Prompt the user to enter the coefficient b
        System.out.println("Enter the b of ax^2 + bx + c");
        System.out.print("> ");
        double b = input.nextDouble();

        // Prompt the user to enter the coefficient c
        System.out.println("Enter the c of ax^2 + bx + c");
        System.out.print("> ");
        double c = input.nextDouble();

        // Store coefficients in an array
        double[] coeffs = {a, b, c};

        // Print the quadratic equation
        System.out.println(quadToString(coeffs));

        // Calculate the roots of the quadratic equation
        double[] roots = calculateRoots(coeffs);

        // Check and print the roots
        if (roots == null) {
            System.out.println("The equation has complex roots.");
        } else {
            System.out.println("x1 = " + roots[0]);
            System.out.println("x2 = " + roots[1]);
        }

        // Calculate the vertex of the quadratic equation
        double vertexX = calculateVertexX(coeffs);
        double vertexY = f(coeffs, vertexX);

        // Print the vertex
        System.out.println("vertex: (" + vertexX + ", " + vertexY + ")");
    }

    /**
     * Converts the quadratic equation coefficients into a readable string format.
     * 
     * @param coeffs An array of doubles representing the coefficients a, b, and c.
     * @return A String representing the quadratic equation in standard form.
     */
    
    public static String quadToString(double[] coeffs) {
        String signB = coeffs[1] >= 0 ? " + " : " - ";
        String signC = coeffs[2] >= 0 ? " + " : " - ";
        return coeffs[0] + "x^2" + signB + Math.abs(coeffs[1]) + "x" + signC + Math.abs(coeffs[2]);
    }

    /**
     * Evaluates the quadratic function ax^2 + bx + c at a given value of x.
     * 
     * @param coeffs An array of doubles representing the coefficients a, b, and c.
     * @param x The value at which to evaluate the function.
     * @return The value of the quadratic function at x.
     */
    
    public static double f(double[] coeffs, double x) {
        return coeffs[0] * x * x + coeffs[1] * x + coeffs[2];
    }

    /**
     * Calculates the roots of the quadratic equation ax^2 + bx + c.
     * 
     * @param coeffs An array of doubles representing the coefficients a, b, and c.
     * @return An array of doubles containing the roots of the equation if they are real, null if the roots are complex.
     */
    
    public static double[] calculateRoots(double[] coeffs) {
        double discriminant = coeffs[1] * coeffs[1] - 4 * coeffs[0] * coeffs[2];
        if (discriminant < 0) {
            return null; // Complex roots
        }
        double x1 = (-coeffs[1] + Math.sqrt(discriminant)) / (2 * coeffs[0]);
        double x2 = (-coeffs[1] - Math.sqrt(discriminant)) / (2 * coeffs[0]);

        return new double[]{x1, x2};
    }

    /**
     * Calculates the x-coordinate of the vertex of the quadratic equation ax^2 + bx + c.
     * 
     * @param coeffs An array of doubles representing the coefficients a, b, and c.
     * @return The x-coordinate of the vertex.
     */
    
    public static double calculateVertexX(double[] coeffs) {
        return -coeffs[1] / (2 * coeffs[0]);
    }
}
