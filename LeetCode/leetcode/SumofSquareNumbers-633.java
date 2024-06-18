/*
 * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
 * Example 1:
    Input: c = 5
    Output: true
    Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
    Input: c = 3
    Output: false
 * Constraints: 0 <= c <= 231 - 1
 */
package leetcode;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;

class Solution {

    public boolean judgeSquareSum(int c) {
        /*
         * strategy applied:
         * since we have to get the target sum as sum of squares, the obtained value may
         * be square of another number,
         * hence considered the square root of the target sum as "sqrtValue" and
         * iterated the numbers from 0 to sqrtValue
         * consider the absolute difference between the targetSum and i as "valueTwo",
         * now check whether the valueTwo is lesser than
         * or equal to sqrtValue, if so, then return true else, return false.
         * Efficiency can be improved by using two pointers algorithm - one variable
         * faster and other slower
         */

        int i = (int) Math.sqrt(c);
        while (i >= 0) {
            double c1 = Math.sqrt(c - (double) (i * i));
            double c2 = (int) c1;
            if (c1 == c2 && c2 <= Math.sqrt(c)) {
                return true;
            }
            i--;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // // Generating some log messages through the
        // // function defined above
        LogManager lgmngr = LogManager.getLogManager();

        // // lgmngr now contains a reference to the log manager.
        Logger logger = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);
        boolean result = solution.judgeSquareSum(5);
        logger.log(Level.INFO, "output: {}", result);
    }
}