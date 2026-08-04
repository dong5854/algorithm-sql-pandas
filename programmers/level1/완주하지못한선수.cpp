#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> count;

    for (const auto& name : participant)
        count[name]++;

    for (const auto& name : completion)
        count[name]--;

    for (const auto& [name, cnt] : count)
        if (cnt > 0)
            return name;

    return "";
}