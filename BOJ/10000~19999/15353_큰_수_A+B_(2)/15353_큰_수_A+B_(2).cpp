#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int carry = 0;
int num;
string x, y;
string result = "";

string sum()
{
	for (int i = 0; i < x.length(); ++i)
	{
		num = (x[i] - '0' + y[i] - '0' + carry) % 10;
		result += to_string(num);
		carry = (x[i] - '0' + y[i] - '0' + carry) / 10;
	}
	if (carry != 0)
	{
		result += to_string(carry);
	}

	return result;
}

int main(int argc, char *argv[])
{

	cin >> x >> y;

	reverse(x.begin(), x.end());
	reverse(y.begin(), y.end());

	while (x.length() < y.length())
	{
		x += '0';
	}
	while (x.length() > y.length())
	{
		y += '0';
	}

	sum();

	reverse(result.begin(), result.end());

	cout << result;

	return 0;
}