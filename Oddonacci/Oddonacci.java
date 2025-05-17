public class Oddonacci {

    // Linear recursive Oddonacci method
	/**
	 * @Input:The n-th number of the sequence to calculate
	 * @Output:The n-th number of the sequence 
	 * 
	 * @Purpose:Calculate the n-th number of the oddonacci sequence using a linear recursive approach. 
	 * 	If the input is 1, 2, or 3, the method returns predefined base case of 1. 
	 * 	If the input is greater than 3, it will make a recursive call to get the previous three 
	 * 	values, calculate the current value, and return an array holding the current and prior values.  
	 */
    public static long[] LinearOddonacci(int n) {
        // Handle base cases for n = 1, 2, 3
        if (n == 1) {  
            return new long[] {1, 0, 0};  // Oddonacci(1) = 1, Oddonacci(0) = 0, Oddonacci(-1) = 0
        } else if (n == 2) {
            return new long[] {1, 1, 0};  // Oddonacci(2) = 1, Oddonacci(1) = 1, Oddonacci(0) = 0
        } else if (n == 3) {
            return new long[] {1, 1, 1};  // Oddonacci(3) = 1, Oddonacci(2) = 1, Oddonacci(1) = 1
        } else {
            // Recursively get Odd(n-1), Odd(n-2), Odd(n-3)
            long[] temp = LinearOddonacci(n - 1);
            // Compute Odd(n), which is the sum of Odd(n-1), Odd(n-2), and Odd(n-3)
            long[] answer = {temp[0] + temp[1] + temp[2], temp[0], temp[1]};
            return answer;
        }
    }
    
    // Multiple recursive Oddonacci method
    /**
     * @Input:The n-th number of the sequence to calculate
     * @Output:The n-th number of the sequence
     * 
     * @Purpose:Calculate the n-th number of the oddonacci sequence using a multi-recursive approach. 
     * 	If the input is less than 4, it will return 1 , being the first 3 numbers in the sequence. 
     * 	If the input is greater than 3, it will make 3 recursive calls with decremented values 
     * 	to calculate the current value, and then return the output of the 3 recursive calls.  
     */
    public static long multipleOddonacci(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return 1;  // Base cases: Oddonacci(1), Oddonacci(2), Oddonacci(3) are all 1
        }
        // Recursive case: Oddonacci(n) = Oddonacci(n-1) + Oddonacci(n-2) + Oddonacci(n-3)
        return multipleOddonacci(n - 1) + multipleOddonacci(n - 2) + multipleOddonacci(n - 3);
    }

    // Tail-recursive helper method
    /**
     * @Input:n: The position in the Oddonacci sequence to calculate.
     * @Output:Returns the n-th Oddonacci number using a tail-recursive approach.
     *
     * @Purpose: This method calculates the n-th Oddonacci number using tail recursion. It takes three parameters 
     *  (a, b, c), which represent the last three Oddonacci numbers, and shifts them in each recursive 
     *  call. When n == 1, 2, or 3, it returns the respective base value.
     */
    public static long oddonacciTailRec(int n, long a, long b, long c) {
        if (n == 1) {
            return a;
        } else if (n == 2) {
            return b;
        } else if (n == 3) {
            return c;
        } else {
            return oddonacciTailRec(n - 1, b, c, a + b + c);
        }
    }

    // Tail-recursive Oddonacci entry point
    public static long oddonacciTail(int n) {
        // Start with base values for Oddonacci(1), Oddonacci(2), and Oddonacci(3)
        return oddonacciTailRec(n, 1, 1, 1);
    }

    // Test
    public static void main(String[] args) {
        for (int i = 1; i <= 200; i += 1) {
            System.out.println("Oddonacci(" + i + ") = " + oddonacciTail(i));
        }
    }
}
