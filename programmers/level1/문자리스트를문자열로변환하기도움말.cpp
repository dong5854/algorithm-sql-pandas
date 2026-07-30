#include <string>
#include <vector>
#include <sstream>

using namespace std;

string solution(vector<string> arr) 
{
    ostringstream oss;
    for (size_t i = 0; i < arr.size(); i++)
    {
        oss << arr[i];
    }
    string answer = oss.str();
    return answer;
}