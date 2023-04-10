/* Given a string S. The task is to count the number of substrings which contains equal number of lowercase and uppercase letters. 

Example 1:

Input:
S = "gEEk"
Output: 3
Explanation: There are 3 substrings of
the given string which satisfy the
condition. They are "gE", "gEEk" and "Ek".
Example 2:

Input:
S = "WomensDAY"
Output: 4
Explanation: There are 4 substrings of 
the given string which satisfy the
condition. They are "Wo", "ensDAY", 
"nsDA" and "sD"
Your Task:
The task is to complete the function countSubstring() which takes the string S as input parameter and returns the number of substrings which contains equal number of uppercase and lowercase letters.

Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |S| ≤ 103
  
  
SOLUTION */




//User function Template for Java
class Solution 
{ 
    int countSubstring(String S) 
    { 
        // code here
        int count=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int diff = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            diff += Character.isUpperCase(c) ? 1 : -1;
            if (map.containsKey(diff)) {
                count += map.get(diff);
            }
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return count;
    }
} 
