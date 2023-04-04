""" Given a string str consisting of only two characters 'a' and 'b'. You need to find the minimum steps required to make the string empty by removing consecutive a's and b's.

Example 1:

Input:
str = "bbaaabb"
Output:
2
Explanation:
Operation 1: Removal of all a's modifies str to "bbbb".
Operation 2: Removal of all remaining b's makes str
empty.
Therefore, the minimum number of operations required
is 2.
Example 2:

Input:
str = "aababaa"
Output:
3
Explanation:
Operation 1: Removal of b's modifies str to "aaabaa".
Operation 2: Removal of b's modifies str = "aaaaa".
Operation 3: Removal of all remaining a's makes str 
empty.
Therefore, the minimum number of operations required 
is 3.
Your Task:

You need to complete the function minSteps() which takes a string str as the only input parameter and returns an integer, denoting the minimum steps required to make the string empty.

Expected Time Complexity: O(N), where N = length of string str
Expected Space Complexity: O(1)

Constraints:

1 <= str.length() <= 105
'a' <= str[i] <= 'b' 


SOLUTION """


class Solution:
    def minSteps(self, str : str) -> int:
        # code here
        acount=0
        bcount=0
        i=0
        for i in range(len(str)):
            if(i!=len(str)-1 and str[i]=='a' and str[i+1]!='a'):
                acount+=1
            if(i!=len(str)-1 and str[i]=='b' and str[i+1]!='b'):
                bcount+=1
            if(i==len(str)-1 and str[i]=='a'):
                acount+=1
            if(i==len(str)-1 and str[i]=='b'):
                bcount+=1
                
        return min(acount,bcount)+1
            
