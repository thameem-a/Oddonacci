import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * @Input:None (uses a fixed range of values for testing)
 * 
 * @Output: void (writes results to a text file)
 * 
 * @Purpose: Test the performance of the LinearOddonacci, MultipleOddonacci and Tail-Recursive Oddonacci method.
 *  The method will loop from 5 to 200 and test the algorithm with every multiple of 5.
 *  It will calculate the time taken for each computation and output the total time taken to a text file (OddoOut.txt).
 */
public class Driver {

    public static void main(String[] args) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream("OddoOut.txt"));
            long startTime, endTime, escapeTimeMultiple, escapeTimeLinear, escapeTimeTail;
            long result1, result2, result3; // Declare result3 for tail-recursive result
            long[] results;        // Declare results as an array for LinearOddonacci

            // Header row formatted
            pw.printf("%-12s %-14s %-12s %-10s %-10s%n", "Oddonacci", "Multiple(ns)", "Linear(ns)", "Tail(ns)", "Result");

            // Loop to calculate Oddonacci(5) to Oddonacci(200) in increments of 5
            for (int i = 5; i <= 200; i += 5) {
                pw.printf("%-14d", i);  // Print Oddonacci number

         
                // Multiple Recursive Oddonacci
                startTime = System.nanoTime();  // nanoTime for better precision
                result1 = Oddonacci.multipleOddonacci(i); // Single long result for multipleOddonacci
                endTime = System.nanoTime();
                escapeTimeMultiple = endTime - startTime;
                pw.printf("%-15d", escapeTimeMultiple);  // Print time for multiple recursion
               
                // Linear Recursive Oddonacci
                startTime = System.nanoTime();  // Use nanoTime for better precision
                results = Oddonacci.LinearOddonacci(i);  // Array result from LinearOddonacci
                endTime = System.nanoTime();
                escapeTimeLinear = endTime - startTime;
                result2 = results[0];  // The first element of results[] is Oddonacci(i)
                pw.printf("%-13d", escapeTimeLinear);  // Print time for linear recursion

                // Tail-Recursive Oddonacci
                startTime = System.nanoTime();  // nanoTime for better precision
                result3 = Oddonacci.oddonacciTail(i);  // Tail-recursive result
                endTime = System.nanoTime();
                escapeTimeTail = endTime - startTime;
                pw.printf("%-11d", escapeTimeTail);  // Print time for tail recursion

                // Verify that all methods produce the same result
                pw.printf("%-11d%n", (result1 == result2 && result1 == result3) ? result1 : -1); // Print result or error

               
                pw.flush();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to create OddoOut.txt, program will close.");
        }
    }
}






