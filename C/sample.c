#include <stdio.h>
#include <string.h>

struct veh {
    int year;
    char brand[20];
    char class;
};

typedef int Array[4];
int main() {
    Array arr = {1, 5, 2, 9};
    for(int i = 0; i < 4; i++){
        printf("%d \n", arr[i]);
    }
}