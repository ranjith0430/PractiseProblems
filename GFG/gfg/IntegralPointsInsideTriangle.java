// User function Template for Java

/*
 * Given three non-collinear points whose co-ordinates are p(p1, p2), q(q1, q2) and r(r1, r2) in the X-Y plane. 
 * Return the number of integral / lattice points strictly inside the triangle formed by these points.
 * Note: - A point in the X-Y plane is said to be an integral / lattice point if both its coordinates are integral.
 * Examples: 
 * Input: p = (0,0), q = (0,5), r = (5,0)
 * Output: 6
 * Explanation: 
 * As shown in figure, points (1,1) (1,2) (1,3) (2,1) (2,2) and (3,1) are the integral points inside the triangle. So total 6 are there.
 * Input: p = (62,-3), q = (5,-45), r = (-19,-23)
 * Output: 1129
 * Explanation: There are 1129 integral points in the triangle formed by p, q and r.
 * Expected Time Complexity: O(Log10^9 base 2)
 * Expected Auxillary Space: O(1)
 * Constraints: -109 ≤ x-coordinate, y-coordinate ≤ 109
 */

class Solution {

    //Brute force approach  - O(n^2)
    // public boolean isPointInsideSegment(long[] p, long[] q, long[] point){
    //     long xDiff = q[0]-p[0];
    //     long yDiff = q[1]-p[1];
    //     long yPDiff = point[1]-p[1];
    //     long xPDiff = point[0]-p[0];
    //   // System.out.println(xDiff+" "+yDiff+" "+xPDiff+" "+yPDiff);
    //     return yPDiff*xDiff-yDiff*xPDiff<0;
    // }
    // public long findLargest(long p, long q, long r){
    //     if(p>q){
    //         if(p>r){
    //             return p;
    //         }
    //         return r;
    //     }else if(q>r){
    //         return q;
    //     }return r;
    // }
    // public long findSmallest(long p, long q, long r){
    //     if(p<q){
    //         if(p<r){
    //             return p;
    //         }
    //         return r;
    //     }else if(q<r){
    //         return q;
    //     }return r;
    // }
    // long InternalCount(long p[], long q[], long r[]) {
    //     // code here
    //     long xSmallest = findSmallest(p[0],q[0],r[0]);
    //     long ySmallest = findSmallest(p[1],q[1],r[1]);
    //     long xLargest = findLargest(p[0],q[0],r[0]);
    //     long yLargest = findLargest(p[1],q[1],r[1]);
    //     long count=0;
    //     for(long i=xSmallest+1; i<xLargest;i++){
    //         for(long j=ySmallest+1; j<yLargest;j++){
    //             long[] p1= new long[2];
    //             p1[0]=i;
    //             p1[1]=j;
    //             if(isPointInsideSegment(p,q,p1) && isPointInsideSegment(q,r,p1) && isPointInsideSegment(r,p,p1)){
    //                 count+=1;
    //             }
    //         }
    //     }
    //     return count;
    // }
    long computeGCD(long p,long q){
        if(p==0){
            return q;
        } if(q==0){
            return p;
        }if(p==q){
            return p;
        }
        if(p>q){
            return computeGCD(p-q,q);
        }return computeGCD(p,q-p);
    }
    long InternalCount(long p[], long q[], long r[]) {
        // efficient implementation
        // code here - lattice points calculation - pick's theorem
        // Area+1 = latPointInside+latBound/2
        // to calculate area of the triangle 1/2∣x1(y2-y3)+x2(y3−y1)+r1(y1−y2)∣
        long area = Math.abs(p[0]*(q[1]-r[1])+q[0]*(r[1]-p[1])+r[0]*(p[1]-q[1]))/2;
        // the number of lattice points on the line segment between them, including
        // the endpoints: 
        // Boundary Points=gcd⁡(∣x2−x1∣,∣y2−y1∣)+1
        long bPoints = computeGCD(Math.abs(q[0]-p[0]), Math.abs(q[1]-p[1]))+ computeGCD(Math.abs(r[0]-q[0]), Math.abs(r[1]-q[1]))+computeGCD(Math.abs(p[0]-r[0]), Math.abs(p[1]-r[1]));
        return area+1-(bPoints)/2;
    }
};