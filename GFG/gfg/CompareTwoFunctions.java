/*
 * 
 */
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;

public class CompareTwoFunctions {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    Solution(){

    }
    
    double convertStringToInteger(String str){
        String[] strArr= str.split("/");
        int num1 = Integer.parseInt(strArr[0]);
        int num2 = Integer.parseInt(strArr[1]);
        return (double)num1/num2;
    }

    String compareFrac(String str) {
        // Code here
        String[] strArr = str.split(", ");
        double value1 = convertStringToInteger(strArr[0]);
        double value2 = convertStringToInteger(strArr[1]);
        if(value1==value2){
            return "equal";
        }
        return value1>value2?strArr[0]:strArr[1];
    }
}
