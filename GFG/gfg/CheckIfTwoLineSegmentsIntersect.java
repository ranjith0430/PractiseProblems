/* Given the coordinates of the endpoints(p1,q1, and p2,q2) of the two line segments. Check if they intersect or not. 
 * If the Line segments intersect return true otherwise return false.
 * Note: Please check the intersection lies within the line segments.
 * Examples:
    * Input: p1=(1,1), q1=(10,1), p2=(1,2), q2=(10,2)
      Output: false
      Explanation:The two line segments formed by p1-q1 and p2-q2 do not intersect.
    * Input: p1=(10,0), q1=(0,10), p2=(0,0), q2=(10,10)
      Output: true
      Explanation: The two line segments formed by p1-q1 and p2-q2 intersect.
    * Input: p1=(5,-2), q1=(13,2), p2=(2,-3), q2=(3,0)
      Output: false
      Explanation: The two line segments formed by p1-q1 and p2-q2 are intersecting beyond endpoints, so it is not considerable.
 * Expected Time Complexity: O(1)
 * Expected Auxillary Space: O(1)
 * Constraints: -106<=X,Y(for all points)<=106
 */

// Initial Template for Java
package gfg;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CheckIfTwoLineSegmentsIntersect {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int[] p1 = new int[2];
            int[] q1 = new int[2];
            int[] p2 = new int[2];
            int[] q2 = new int[2];
            String[] firstLine = read.readLine().split(" ");
            p1[0] = Integer.parseInt(firstLine[0]);
            p1[1] = Integer.parseInt(firstLine[1]);
            q1[0] = Integer.parseInt(firstLine[2]);
            q1[1] = Integer.parseInt(firstLine[3]);
            String[] secondLine = read.readLine().split(" ");
            p2[0] = Integer.parseInt(secondLine[0]);
            p2[1] = Integer.parseInt(secondLine[1]);
            q2[0] = Integer.parseInt(secondLine[2]);
            q2[1] = Integer.parseInt(secondLine[3]);
            Solution ob = new Solution();
            String ans = ob.doIntersect(p1, q1, p2, q2);
            LogManager lgmngr = LogManager.getLogManager(); 
  
            // lgmngr now contains a reference to the log manager. 
            Logger logger = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME); 
            logger.log(Level.INFO, "output: {}",ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    String doIntersect(int[] p1, int[] q1, int[] p2, int[] q2) {
        // code here
        /*
         * Strategy is to find slopes of two segments and check whether they are same or not, if same, then return
         * "false" and also check whether p2 and q2 are on the same side of segment formed by p1 and q1 and also
         * check whether p1 and q1 are on the same side of segment formed by p2 and q2, if not, return "false"
         * otherwise return "true" if all the above conditions fails
         */
        // slope calculation for two lines
        double slopeFirstLine = (double) (q1[1] - p1[1]) / (q1[0] - p1[0]);
        double slopeSecondLine = (double) (q2[1] - p2[1]) / (q2[0] - p2[0]);
        if (slopeFirstLine == slopeSecondLine) {
            return "false";
        }
        // for relative position of end points
        boolean k1 = p2[1] - p1[1] - slopeFirstLine * (p2[0] - p1[0]) > 0;
        boolean k2 = q2[1] - p1[1] - slopeFirstLine * (q2[0] - p1[0]) > 0;
        boolean k3 = -p2[1] + p1[1] - slopeSecondLine * (p1[0] - p2[0]) > 0;
        boolean k4 = q1[1] - p2[1] - slopeSecondLine * (q1[0] - p2[0]) > 0;
        if ((k1 && k2) || (!k1 && !k2) || (k3 && k4) || (!k3 && !k4)) {
            return "false";
        }
        return "true";
    }
}