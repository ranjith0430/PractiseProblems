/*
Given a number n, find out if n can be expressed as a+b, where both a and b are prime numbers. If such a pair exists, return the values of a and b, otherwise return [-1,-1] as an array of size 2.
Note: If [a, b] is one solution with a <= b, and [c, d] is another solution with c <= d, and a < c then  [a, b] is considered as our answer.

Examples

Input: n = 10
Output: 3 7
Explanation: There are two possiblities 3, 7 & 5, 5 are both prime & their sum is 10, but we'll pick 3, 7 as 3 < 5.
Input: n = 3
Output: -1 -1
Explanation: There are no solutions to the number 3.
Expected Time Complexity: O(n*loglog(n))
Expected Auxiliary Space: O(n)

Constraints:
2 <= n <= 106
*/
//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    import java.util.ArrayList;
    
    class IntArray {
        public static int[] input(BufferedReader br, int n) throws IOException {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
    
            return a;
        }
    
        public static void print(int[] a) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    
        public static void print(ArrayList<Integer> a) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
    
                int n;
                n = Integer.parseInt(br.readLine());
    
                Solution obj = new Solution();
                ArrayList<Integer> res = obj.getPrimes(n);
    
                IntArray.print(res);
            }
        }
    }
    
    // } Driver Code Ends
    
    
    class Solution {
        public static boolean isPrime(int num){
            // returns true if number is prime otherwise false
            if(num<2){
                return false;
            }
            for(int i=2; i<=Math.sqrt(num);i++){
                if(num%i==0){
                    return false;
                }
            }
            return true;
        }
        public static ArrayList<Integer> getPrimes(int n) {
            // code here
            /* Divided the number list till n into two halves and considered the first half
             * checked the each number in the list and n-i is prime or not if so, then considered minimum value as i
             * if no primes are found then added -1,-1 to the result set otherwise the identified primes whose sum is equal to n
             * by considering least prime number as i.
             */
            ArrayList<Integer> result=new ArrayList<>();
            int min=n;
            for(int i=2;i<=(n/2);i++){
                if(isPrime(i) && isPrime(n-i) && i<=min){
                    min=i;
                }
            }
            if(min==n){
                result.add(-1);
                result.add(-1);
            }else{
                result.add(min);
                result.add(n-min);
            }
            return result;
        }
    }
    