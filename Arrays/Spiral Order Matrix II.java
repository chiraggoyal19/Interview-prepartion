/* DAY1
Problem Description

Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.



Problem Constraints
1 <= A <= 1000



Input Format
First and only argument is integer A


Output Format
Return a 2-D matrix which consists of the elements in spiral order.



Example Input
Input 1:

1
Input 2:

2


Example Output
Output 1:

[ [1] ]
Output 2:

[ [1, 2], [4, 3] ]


Example Explanation
Explanation 1:

 
Only 1 is to be arranged.
Explanation 2:

1 --> 2
      |
      |
4<--- 3


*/
/* SOLUTION APPROACH
This is more of a simulation problem.

You need to maintain state indicating which direction 
you are traversing to ( left to right, right to left, top to down, down to top ) and 
then know when to change the directions.

Note that in each direction, either row or column remains constant.

Based on the constant row or column, you can predict when to change the direction.
*/

public class Solution {
    public int[][] generateMatrix(int Ar) {
        int[][] A=new int[Ar][Ar];
        int r1=0,r2=Ar,c1=0,c2=Ar;
        
        int s=1;
        int x=0;
        while(r1<r2 && c1<c2){
            for(int i=c1;i<c2;i++){
                A[r1][i]=s;
                s++;
            }
            r1++;
            for(int i=r1;i<r2;i++){
                A[i][c2-1]=s;
                s++;
            }
            c2--;
            for(int i=c2-1;i>=c1;i--){
                A[r2-1][i]=s;
                s++;
            }
            r2--;
            for(int i=r2-1;i>=r1;i--){
                A[i][c1]=s;
                s++;
            }
            c1++;
        }
        return A;
    }
}
