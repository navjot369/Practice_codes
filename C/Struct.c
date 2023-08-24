// #include <stdio.h>
// #include <string.h>

// typedef struct Address {
//     int house;
//     int street;
//     int pincode;
//     char town[20];
// } add;

// int main() {
//     add a1;
//     a1.house = 4;
//     a1.street = 56;
//     a1.pincode = 144108;
//     strcpy(a1.town, "Model town");
//     printf("%d, %d, %s - %d \n", a1.house, a1.street, a1.town, a1.pincode);
// }

#include <stdio.h>
struct pad
{
    int dd:8;
    int mm:4;
    int yy:3;

};

int main()
{   
    struct pad A;
    printf("Size of A is %lu.\n", sizeof(A));   
    return 0;
}