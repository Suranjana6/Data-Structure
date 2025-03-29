// Given a rod of length n(size of price) inches and an array of prices, price. price[i] denotes the value of a piece of length i. 
// Determine the maximum value obtainable by cutting up the rod and selling the pieces.

// Input: price[] = [1, 5, 8, 9, 10, 17, 17, 20]
// Output: 22
// Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5+17=22.

class RodCutting {
    public int cutRod(int[] price) {
        // code here
      int n=price.length;
      int[] dp=new int[n+1];

      for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
          dp[i]=Math.max(dp[i],price[j-1]+dp[i-j]);
        }
    }

      return dp[n];
}
