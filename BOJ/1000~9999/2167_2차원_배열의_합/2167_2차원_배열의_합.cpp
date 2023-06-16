#include <iostream>
using namespace std;

int arr[301][301];
int d[301][301];
int n, m;

int main()
{
  cin >> n >> m;
  for (int i = 1; i <= n; i++)
  {
    for (int j = 1; j <= m; j++)
    {
      cin >> arr[i][j];
      d[i][j] = arr[i][j] + d[i - 1][j] + d[i][j - 1] - d[i - 1][j - 1];
    }
  }
  int k;
  cin >> k;
  while (k--)
  {
    int a, b, x, y;
    cin >> a >> b >> x >> y;
    cout << d[x][y] - d[a - 1][y] - d[x][b - 1] + d[a - 1][b - 1] << endl;
  }
  return 0;
}
