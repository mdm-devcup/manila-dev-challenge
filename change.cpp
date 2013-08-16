#include <algorithm>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <queue>
#include <set>
#include <map>
#include <cstdio>
#include <cstdlib>
#include <cctype>
#include <cmath>
#include <cstring>

using namespace std;

#define all(v) v.begin(), v.end()
#define pb(v, e) v.push_back(e)
#define rall(v) v.rbegin, v.rend()
#define ll long long
#define sz(v) (int) v.size()
#define az(x) (sizeof(x) / sizeof(x[0]))
#define oo (int) 13e7
#define fill(v, e) memset(v, e, sizeof v)
#define N 4
#define M 1 << 20

const int coins[] = {1, 5, 10, 25};
ll cache[M];

ll doit(int n) {
  if(n == 0) return 1ll;
  if(n < 0) return 0ll;
  ll &r = cache[n];
  if(r != -1) return r;
  r = 0;
  for(int i = 0; i < N; ++i)
    r += doit(n - coins[i]);
  return cache[n] = r;
}

int main() {
  int n = 100000;
  fill(cache, -1);
  cout << doit(n) << endl; 
}
