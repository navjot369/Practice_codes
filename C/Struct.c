#include <stdio.h>

int main() {
    FILE *ptr;
    ptr = fopen("test1.txt", "r");

    char str[30];
    fgets(str, 30, ptr);
    printf("%s", str);
    rewind(ptr);
    fgets(str, 30, ptr);
    printf("%s", str);
    
    
    // char str[] = "My name is Mitul";
    // fwrite(str, 1, 30, ptr);

    // char str[30];
    // fread(str, 1, 10, ptr);
    // printf("%s", str);
    // char str[30];
    // char ch = fgetc(ptr);
    // while(ch != EOF) {
    //     printf("%c", ch);
    //     ch = fgetc(ptr);
    // }
    // while(fgets(str, 30, ptr) != 0) {
    //     printf("%s", str);
    // }
    fclose(ptr);
}