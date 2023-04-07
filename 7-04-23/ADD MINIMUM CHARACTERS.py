""" Given a string str, find the minimum characters to be added at front of the string to make it a palindrome.


Example 1:

Input:
str = ABCD
Output: 3
Explanation: The resultant string 
after adding 3 characters is DCBABCD.
The minimum possible answer is 3.
Example 2:

Input:
str = ABA
Output: 0
Explanation: The given string
is already a palindrome.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function addMinChar() which takes the string str as input parameters and returns the minimum number of characters to be added to make it a palindrome.


Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(|str|)


Constraints:
1 ≤  |str| ≤ 105
str contains only uppercase english alphabets



SOLUTION 


#User function Template for python3 """

class Solution:
    def addMinChar (self, str):
        # code here 
        start=0
        end=len(str)-1
        temp=end
        while(start<end):
            if(str[start]==str[end]):
                start+=1
                end-=1
            else:
                start=0
                end=temp
                temp-=1
                end-=1
        return len(str)-temp-1
