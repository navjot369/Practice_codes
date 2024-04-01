#include <iostream>
#include <vector>
using namespace std;

vector<char> fun(vector<char> v) {
    vector<char> ans;
    ans.push_back(v[0]);
    char uniq = v[0];
    int ind = 0;

    for(int i = 1; i < v.size(); i++) {
        if(uniq != v[i]) {
            ans.push_back(uniq);
        }
        else{
            char ele = v[ind+1];
            for(int j = ind+2; j <= i; j++) {
                if(j == i) {
                    uniq = ele;
                    ind++;
                    i--;
                }
                if(ele == v[j]) {
                    ind++;
                    i--;
                    break;
                }
            }
        }
    }
    return ans;
}

int main() {
    vector<char> v;
    string s;
    cin >> s;
    for(int i = 0; i < s.length(); i++) {
        v.push_back(s[i]);
    }

    vector<char> ans = fun(v);

    for(int i = 0; i < ans.size(); i++) {
        cout << ans[i];
    }
    cout << endl;
}

