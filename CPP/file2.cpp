#include <iostream>
using namespace std;
int x;
void add(double a) {
    x = a +1;
}
void add(int a, int b) {
    x = a +2;
}
int main() {
    int a = 0;
    add(6, 6);
    cout << x;
}