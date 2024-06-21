/*
 * You are given a perimeter & the area. Your task is to return the maximum volume that can be made in the form of 
 * a cuboid from the given perimeter and surface area.
 * Note: Round off to 2 decimal places and for the given parameters, it is guaranteed that an answer always exists.
 * Examples
 * Input: perimeter = 22, area = 15
 * Output: 3.02
 * Explanation: The maximum attainable volume of the cuboid is 3.02
 * Input: perimeter = 20, area = 5
 * Output: 0.33
 * Explanation: The maximum attainable volume of the cuboid is 0.33
 * Expected Time Complexity: O(1)
 * Expected Auxiliary Space: O(1)
 * Constraints : 1 ≤ perimeter ≤ 109 1 ≤ area ≤ 109
 */

import java.util.logging.LogManager;
import java.util.logging.Logger;

class Solution {

    double maxVolume(double perimeter, double area) {
        // code here
        /* approach: solve the equations - 2(lb+bh+lh)=area
         * perimeter = 4(l+b+h) volume = lbh so that volume should be in terms of any one
         * side. In order to get the maximum volume, differentiate the volume equation with
         * respect to the assumed side and equate to zero to identify the values of side
         * now do one more differentiation and subsitute the values in the equation and iden
         * -tify the values which make the equation or value of the obtained expression 
         * negative then consider that value as the required value(termed as length) and there is intuition that
         * if two sides of cuboid are equal then returns maximum value. So breadth and length are 
         * equal, use them and obtain height from perimeter expression.  Substitute all the
         * values and calculate the volume of cuboid and return it
         */
        double length = ((perimeter)-(Math.sqrt((perimeter*perimeter)-24*area)))/12.0;
        double volume = (length*length*((perimeter/4.0)-2*length));
        return Math.round(volume * 100.0) / 100.0;
    }
}
public class MaxVolumeCuboid {
    Solution solution = new Solution();
    LogManager lgmngr = LogManager.getLogManager(); 
    // lgmngr now contains a reference to the log manager. 
    Logger logger = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME); 
    // logger.log(Level.INFO,solution.getSolution(22,15));
    
}
