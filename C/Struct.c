#include <stdio.h>
#include <string.h>

int main() {
    FILE *file1;
    file1 = fopen("test1.txt", "w");
    if(file1 == NULL) {
        printf("file not opened");
        return 0;
    }
    char str1[40];
    scanf("%[^\n]",  str1);
    fprintf(file1, "%s", str1);
    
    fclose(file1);
}