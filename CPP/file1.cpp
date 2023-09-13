#include <iostream>
#include <string>
#include <ctime>
using namespace std;

typedef int *ptrInt;

int main() {
    int x = 8;
    ptrInt x1;
    x1 = &x;
    cout << x1 << endl;
    cout << *x1 << endl;
}
