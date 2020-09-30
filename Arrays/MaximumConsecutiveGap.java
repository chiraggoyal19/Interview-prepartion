/* DAY1


Problem Description

Given an unsorted integer array A of size N.
Find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.
Return 0 if the array contains less than 2 elements.



Problem Constraints
1 <= N <= 106

1 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the maximum difference.



Example Input
Input 1:

 A = [1, 10, 5]
Input 2:

 A = [10, 9, 10]


Example Output
Output 1:

 5
Output 2:

 1


Example Explanation
Explanation 1:

 After sorting, the array becomes [1, 5, 10]
 Maximum difference is (10 - 5) = 5.
Explanation 2:

 Maximum difference is (10 - 9) = 1.
*/

/*solution approach
Now, first try to think if you were already given the minimum value MIN and 
maximum value MAX in the array of size N,
under what circumstances would the max gap be minimum and maximum ?
Obviously, maximum gap will be maximum when all elements are either MIN or MAX making maxgap = MAX - MIN.

Maximum gap will be minimum when all the elements are equally spaced apart between MIN and MAX.
Lets say the spacing between them is gap.
So, they are arranged as
MIN, MIN + gap, MIN + 2*gap, MIN + 3*gap, ... MIN + (N-1)*gap 
where

MIN + (N-1)*gap = MAX 
=> gap = (MAX - MIN) / (N - 1). 
So, we know now that our answer will lie in the range [gap, MAX - MIN].
Now, if we know the answer is more than gap, what we do is create buckets of size gap for ranges
[MIN, MIN + gap), [Min + gap, `MIN` + 2* gap) ... and so on

There will only be (N-1) such buckets. We place the numbers in these buckets based on their value.

If you pick any 2 numbers from a single bucket, their difference will be less than gap,
and hence they would never contribute to maxgap ( Remember maxgap >= gap ).
We only need to store the largest number and the smallest number in each bucket, 
and we only look at the numbers across bucket.

Now, we just need to go through the bucket sequentially ( they are already sorted by value ),
and get the difference of min_value with max_value of previous bucket with at least one value.
We take maximum of all such values.

*/

//This question is not done using the above approach//

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maximumGap(final int[] A) {
        if(A.length==1)
            return 0;
        else{    
        TreeSet<Integer>m=new TreeSet<Integer>();
        for(int i=0;i<A.length;i++){
            m.add(A[i]);
        }
        int i=0;
        int a[]=new int[m.size()];
        for(Integer value:m){
            a[i]=value;
            i++;
        }
    //    System.out.println(a.length);
        if(a.length==1)
            return 0;
      //  for(int j=0;j<a.length;j++)
        //    System.out.println(a[j]);
        int max=Integer.MIN_VALUE;
        for(int j=0;j<a.length-1;j++){
            max=Math.max(max,a[j+1]-a[j]);
        }
        return max;   
            
    }
}
