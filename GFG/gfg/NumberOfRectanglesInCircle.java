package gfg;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class NumberOfRectanglesInCircle {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int radius = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans = ob.rectanglesInCircle(radius);
            LogManager lgmngr = LogManager.getLogManager();
            // lgmngr now contains a reference to the log manager.
            Logger logger = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);
            logger.log(Level.INFO, "output: {}", ans);
        }
    }
}


// User function Template for Java

class Solution {
    int rectanglesInCircle(int r) {
        // code here
        /*
         * rectangle can be fit in a circle only when each side of rectangle
         * length is less than or equal to the diameter of circle
         * (length)^2+(breadth)^2<=(2*radius)^2
         */
        int count = 0;
        for (int i = 1; i < 2 * r; i++) {
            for (int j = 1; j < 2 * r; j++) {
                if (i * i + j * j <= 4 * r * r) {
                    count++;
                }
            }
        }
        return count;
    }
}