#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

void reverseStr(char *str) {
    int len = strlen(str);
    char *stack = (char *)malloc(sizeof(char) * len);
    int top = -1;

    for(int i = 0; i < len; i++){
        if(str[i] == '(') {
            stack[++top] = ')';
        }
        else if(str[i] == ')') {
            stack[++top] = '(';
        }
        else {
            stack[++top] = str[i];
        }
    }

    for(int i = 0; i < len; i++) {
        str[i] = stack[top--];
    }
}

int isOper(char ch) {
    return (ch == '+' || ch == '-' ||
    ch == '*' || ch == '/' || ch == '*');
}

int prec(char ch){
    switch(ch) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
        default:
            return -1;
    }
}

int dopop(char top, char curr) {
    if(top == '^' || curr == '^') {
        return 1;
    }
    if(prec(top) > prec(curr)) {
        return 1;
    }
    else {
        return 0;
    }
}

char *prefix(char *str) {
    int len = strlen(str);
    char stack[len];
    int top = -1;
    reverseStr(str);
    printf("After reverse: %s \n", str);
    char *ans = (char *)malloc(sizeof(char) * len);
    int ind = 0;
    for(int i = 0; i < len; i++) {
        if(str[i] == ' ' || str[i] == '\t') {
            continue;
        }

        if(str[i] == '(') {
            stack[++top] = str[i];
        }
        else if(str[i] == ')') {
            while(stack[top] != '(') {
                ans[ind++] = stack[top--];
            }
            top--;
        }
        else if(isOper(str[i])) {
            while(top > -1 && dopop(stack[top], str[i])) {
                ans[ind++] = stack[top--];
            }
            stack[++top] = str[i];
        }
        else {
            ans[ind++] = str[i];
        }
    }
    while(top > -1) {
        ans[ind++] = stack[top--];
    }
    reverseStr(ans);
    return ans;

}

int main(){
    char str[20];
    printf("Enter string: ");
    scanf("%[^\n]s", str);
    char *result = prefix(str);

    printf("Prefix: %s \n", result);
}