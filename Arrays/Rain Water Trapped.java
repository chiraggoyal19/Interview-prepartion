//DAY1
/*


Problem Description

Given a vector A of non-negative integers representing an 
elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is the vector A



Output Format
Return one integer, the answer to the question



Example Input
Input 1:

A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

1 unit is trapped on top of the 3rd element.
Explanation 2:

No water is trapped.
*/
/*
instead of calculating area by height*width, we can think it in a cumulative way.
In other words, sum water amount of each bin(width=1). 
Search from left to right and maintain a max height of
left and right separately, which is like a one-side wall of partial container.
 Fix the higher one and flow water
from the lower part. 
For example, if current height of left is lower, we fill water in the left bin.
Until left meets right,
we filled the whole container.
*/
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        int lmax=0;
        int rmax=0;
        int n=A.size();
        int l=0;
        int r=n-1;
        int result=0;
        while(l<=r){
            if(A.get(l)<A.get(r)){
                if(A.get(l)>lmax)
                    lmax=A.get(l);
                else
                    result=result+lmax-A.get(l);
                    
                l++;    
            }
            else{
                if(A.get(r)>rmax)
                    rmax=A.get(r);
                else
                    result+=rmax-A.get(r);
                r--;    
            }
        }
        return result;
    }
}
