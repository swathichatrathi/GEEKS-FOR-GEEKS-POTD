# You are given an array a and you need to generate an array b. You are allowed to apply only one type of operation on the array a, any number of times. In one operation you can swap ai, ai+1 if ai+ai+1 is even.
# Array b should be generated after applying the above operation any number of times on array a and array b should be lexicographically the largest among all arrays that can be generated from array a, after applying the above operation any number of times.





# Input:
# N=3
# a[]={1,3,5}
# Output:
# 5,3,1
# Explanation: [1,3,5],[1,5,3],[3,1,5],[3,5,1],
# [5,1,3] and [5,3,1] are all possible
# values of array b while the last one is 
# lexicographically largest.




# Input:
# N=4
# a[]={1,3,4,2}
# Output:
# b[]={3,1,4,2}
# Explanation: [1,3,4,2],[1,3,2,4],[3,1,2,4] and 
# [3,1,4,2] are all possible values of b among 
# which the last one is lexicographically largest one.



# Your Task:  
# You don't need to read input or print anything. Your task is to complete the function lexicographically Largest() which takes the array arr[], and its size N as input parameters and returns the array b.

 

# Expected Time Complexity: O(NlogN)
# Expected Auxiliary Space: O(1)

 

# Constraints:
# 1 <= N <= 105
# 1<= arr[i] <= 105
# Array may contain duplicate elements. 



# SOLUTION 


#User function Template for python3

class Solution():
    def lexicographicallyLargest(self, a, n):
        start=0
        end=1
        while start<n and end<n:
            if(a[start]+a[end])%2==0:
                end+=1
            else:
                a[start:end]=sorted(a[start:end],reverse=True)
                start=end
                end+=1
        if end==n:
            a[start:end]=sorted(a[start:end],reverse= True)
        return a
        
