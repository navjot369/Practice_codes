#include <stdio.h>
#include <string.h>

void push(char *stack, int *size,char val) {
    if(*size >= 100) {
        return;
    }
    stack[*size] = val;
    (*size)++;
}

char pop(char stack[], int *size) {
    if(*size <= 0) {
        return '!';
    } 
    char data = stack[*size - 1];
    (*size)--;
    return data;
}

char peek(char stack[], int size) {
    if(size <= 0) {
        return '!';
    }
    return stack[size-1];
}

int main() {
    char stack[100];
    int size = 0;

    char str[50];
    printf("Enter string: ");
    scanf("%[^\n]s", str);
    for(int i = 0; i < strlen(str); i++) {
        char curr = str[i];
        if(curr == '(' || curr == '{' || curr == '[') {
            push(stack, &size, curr);
        }
        if(curr == ')' || curr == '}' || curr == ']') {
            if((curr == ')' && peek(stack, size) == '(') || 
            (curr == '}' && peek(stack, size) == '{') ||
            (curr == ']' && peek(stack, size) == '[') ) {
                pop(stack, &size);
            }
            else{
                printf("Not a valid string \n");
                return 0;
            }
        }

    }
    if(size != 0) {
        printf("Not a valid string\n");
    }else {
        printf("Is a valid String\n");
    }

}