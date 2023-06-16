#include <iostream>
#include <queue>
using namespace std;
#define MAX_VERTICES 1000

int parent[MAX_VERTICES];
int num[MAX_VERTICES];

typedef struct Node
{
  int value;
  int from;
  int to;
  Node(int value, int from, int to) : value(value), from(from), to(to) {}
  Node() : value(0), from(0), to(0) {}
} Node;

struct compare
{
  bool operator()(Node t, Node u) { return t.value > u.value; }
};

void set_init(int n)
{
  int i;
  for (i = 0; i < n; i++)
  {
    parent[i] = -1;
    num[i] = 1;
  }
}

int set_find(int vertex)
{
  int p, s, i = -1;
  for (i = vertex; (p = parent[i]) >= 0; i = p)
    ;
  s = i;
  for (i = vertex; (p = parent[i]) >= 0; i = p)
    parent[i] = s;
  return s;
}

void set_union(int s1, int s2)
{
  if (num[s1] < num[s2])
  {
    parent[s1] = s2;
    num[s2] += num[s1];
  }
  else
  {
    parent[s2] = s1;
    num[s1] += num[s2];
  }
}
void insert_heap_edge(priority_queue<Node, vector<Node>, compare> *h, int u, int v, int weight)
{
  Node e;
  e.from = u;
  e.to = v;
  e.value = weight;
  h->push(Node(e.value, e.from, e.to));
}

void kruskal(int n, int m)
{
  int sum = 0;
  int from, to, value;
  int edge_accepted = 0;
  priority_queue<Node, vector<Node>, compare> h;
  int uset, vset;
  Node e;

  for (int i = 0; i < m; ++i)
  {
    scanf("%d", &from);
    scanf("%d", &to);
    scanf("%d", &value);
    insert_heap_edge(&h, from, to, value);
  }
  set_init(n);
  while (edge_accepted < (n - 1))
  {
    e = h.top();
    h.pop();
    uset = set_find(e.from);
    vset = set_find(e.to);
    if (uset != vset)
    {
      edge_accepted++;
      set_union(uset, vset);
      sum += e.value;
    }
  }
  cout << sum;
}

int main()
{

  priority_queue<Node, vector<Node>, compare> pq;
  int comnum;
  int linenum;
  cin >> comnum;
  cin >> linenum;

  kruskal(comnum, linenum);

  return 0;
}
