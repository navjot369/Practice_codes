#include<iostream>
using namespace std;

void printNum(int num) {
    if(num == 0) {
        return;
    }
    cout << num << " ";
    printNum(num-1);
}

int main(){
    printNum(10);
    cout << endl;
}
