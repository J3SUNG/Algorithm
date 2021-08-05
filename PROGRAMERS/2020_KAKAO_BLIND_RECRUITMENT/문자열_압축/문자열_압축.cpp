#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string s)
{
    int answer = 1000;
    int count = 0;
    int continuity = 0;
    int length = s.length();
    string text = "";
    if (length == 1)
    {
        return 1;
    }
    for (int i = 1; i <= length / 2; ++i)
    {
        count = 0;
        continuity = 0;
        for (int j = 0; j < length; j += i)
        {
            if (length < j + i)
            {
                count += length - j;
                break;
            }
            if (text == "" || text != s.substr(j, i))
            {
                text = s.substr(j, i);
                count += i;
                continuity = 0;
            }
            else
            {
                ++continuity;
                if (continuity == 1 || continuity == 9 || continuity == 99 || continuity == 999)
                {
                    count++;
                }
            }
        }
        answer = min(answer, count);
        count = 0;
        text = "";
    }

    return answer;
}
