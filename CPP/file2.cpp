#include <iostream>
using namespace std;

int dr[4] = { 1, 0, 0, -1 };
int dc[4] = { 0, -1, 1, 0 };


bool isValid(int row, int col, int n, int m
             char[][] maze)
{
    return row >= 0 && col >= 0 && row < n && col < m
           && maze[row][col];
}

// Function to get all valid paths
void findPath(int row, int col, char[][] maze,
              int n, int m, vector<string>& ans,
              string& currentPath)
{
    if (row == n - 1 && col == m - 1) {
        ans.push_back(currentPath);
        return;
    }
    maze[row][col] = 'O';

    for (int i = 0; i < 4; i++) {
        int nextrow = row + dr[i];
        int nextcol = col + dc[i];

        if (isValid(nextrow, nextcol, n, m, maze)) {
            currentPath += direction[i];
            findPath(nextrow, nextcol, maze, n, ans,
                     currentPath);
            currentPath.pop_back();
        }
    }
    maze[row][col] = 'X';
}

int main()
{
    //n, m and grid ki input khud liyo
    vector<string> result;
    string currentPath = "";

    if (maze[0][0] != 'O' && maze[n - 1][n - 1] != 'O') {
        findPath(0, 0, maze, n, m,result, currentPath);
    }

    if (result.size() == 0)
        cout << -1;
    else
        for (int i = 0; i < result.size(); i++)
            cout << result[i] << " ";
    cout << endl;

    return 0;
}