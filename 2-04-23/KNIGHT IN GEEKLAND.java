/* Knight is at (start_x,start_y) in Geekland which is represented by an NxM 2D matrix.
# Each cell in the matrix contains some points. In the ith step, the knight can collect all the points from all the cells that can be visited in exactly i steps without revisiting any cell.
# Also, the knight has some magical powers that enable him to fetch coins from the future i.e. If the knight can collect y coins in the xth step he can fetch all the coins that he will collect in the (x + y)th step and if the knight can collect z coins in the yth step he can fetch all the coins that he will collect in the (y + z)th step and so on without increasing the step count i.e. knight will stay on xth step and will get all the coins of the future steps mentioned above((x + y)th step coins + (y+z)th steps + ...).
# Find the minimum number of steps required to collect the maximum points.
# Note: The knight moves exactly the same as the knight on a chess board. Please follow 0 indexing.



# Input:
# n = 9
# m = 10
# start_x = 4, start_y = 5
# arr =
# 0 0 0 2 0 2 0 2 0 0
# 0 0 2 0 2 0 2 0 2 0
# 0 2 0 0 1 2 0 0 0 2
# 0 0 2 0 2 0 2 0 2 0
# 0 2 0 2 0 0 0 2 0 2
# 0 0 2 0 2 0 2 0 2 0
# 0 2 0 0 0 2 0 0 0 2
# 0 0 2 0 2 0 2 0 2 0
# 0 0 0 2 0 2 0 2 0 0
# Output: 1
# Explanation: minimum knight have to take 1 steps to gain maximum points.
# Initially, the knight has 0 coins, he will take 1 step to collect 1 point (sum of cells denoted in red color).
# Now in the second step, he can collect points from all the cells colored green i.e. 64 points.
# But with his magical power, at the 1st step, he can fetch points from the (1 + 1)th step. Therefore he can collect 1 + 64 coins at step 1 only. Hence answer is 1.




# Input:
# n = 3 
# m = 3
# start_x = 2, start_y = 1
# arr =
# 7 6 8
# 9 1 4
# 6 2 8
# Output:0
# Explanation:
# Initially, the knight has 2 points, or more formally we can say that at the 0th step knight has 2 points.
# In the first step, he can collect points from cells (0, 0) and (0, 2) i.e. 15 points.
# In the second step, he can collect points from cells (1, 0) and (1, 2) i.e. 13 coins.
# In the third step, he can collect points from cells (2, 0) and (2, 2) i.e. 14 points.
# In the fourth step, he can collect points from the cell (0, 1) i.e. 6 points.
# So in each step, he can collect coins like -You can see in the below image  Knight can collect 15 coins in the 0th step only




# Your Task:
# You don't need to read input or print anything. Your task is to complete the function knightInGeekland() which takes 2-d array arr[][], starting coordinates of knight start_x, and start_y as input, and return an integer value as min steps to gain max points.

# Expected Time Complexity: O(N*M)
# Expected Auxiliary Space: O(N*M)

# Constraints:
#  1 <= len(arr), len(arr[0]) < 103
#   0 <= values in arr <=100


# SOLUTION */

class Solution{
    int[] moves_x = {-2, -2, -1, -1, 1, 1, 2, 2};
    int[] moves_y = {-1, 1, -2, 2, 2, -2, 1, -1};
    public boolean isValid(int i,int j,int[][] arr,boolean[][] visited)
    {
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || visited[i][j]==true) return false;
        
            return true;
    }
    public int knightInGeekland(int arr[][], int start_x, int start_y){
        int n=arr.length,m=arr[0].length;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{start_x,start_y});
        boolean[][] visited=new boolean[n][m];
        visited[start_x][start_y]=true;
        ArrayList<Integer> points=new ArrayList<>();
        while(!q.isEmpty())
        {
            int size=q.size();
            int sum=0;
            for(int i=0;i<size;i++)
            {
                int[] coor=q.poll();
                int curX=coor[0];
                int curY=coor[1];
                sum+=arr[curX][curY];
                for(int index=0;index<8;index++)
                {
                    int xIndex=moves_x[index]+curX;
                    int yIndex=moves_y[index]+curY;
                    if(isValid(xIndex,yIndex,arr,visited))
                    {
                        visited[xIndex][yIndex]=true;
                        q.add(new int[]{xIndex,yIndex});
                    }
                }
            }
            points.add(sum);
        }
        int[] pointsArr=new int[points.size()];
        for(int i=0;i<points.size();i++) pointsArr[i]=points.get(i);
        int max=Integer.MIN_VALUE;
        int ans=0;
        for(int i=points.size()-1;i>=0;i--)
        {
            if(pointsArr[i]+i<points.size())
            {
                pointsArr[i]+=pointsArr[pointsArr[i]+i];
            }
            
            if(pointsArr[i]>=max)
            {
                max=pointsArr[i];
                ans=i;
            }
        }
        return ans;
    }
}   
