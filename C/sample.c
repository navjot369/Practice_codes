#include <stdio.h>

struct person {
    int age;
    int num;
};

int main() {
    struct person p1;
    p1.age = 45;
    printf("%d", p1.age);
    return 0;
}