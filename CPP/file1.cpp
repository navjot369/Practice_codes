#include <iostream>
using namespace std;

class Calculator {
    public:
    int num1 = 20;
    int num2 = 30;

    int addition(int num) {
        return num1 + num;
    }
};

int main(){
    Calculator c1;
    int ans = c1.addition(4);
    
    cout << ans << endl;
}
