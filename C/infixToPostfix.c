#include <stdio.h>
#include <string.h>
#include <stdlib.h>

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

int isdrop(char top, char curr) {
    if(top == '^' && curr == '^') {
        return 0;
    }
    if(prec(top) >= prec(curr)) {
        return 1;
    }else {
        return 0;
    }
}

int isOper(char curr) {
    return (curr == '+' ||
    curr == '-' ||
    curr == '*' ||
    curr == '/' ||
    curr == '^');
}

char *postfix(char *infix) {
    int len = strlen(infix);
    int ind = 0;
    char *post = (char*)malloc(sizeof(char) * (len + 2));
    char stack[len];
    int top = -1;

    for(int i = 0; i < len; i++) {
        char curr = infix[i];

        if(curr == ' ' || curr == '\t') {
            continue;
        }

        if(curr == '(') {
            stack[++top] = curr;
        }
        else if(curr == ')') {
            while(stack[top] != '(') {
                post[ind++] = stack[top--];
            }
            top--;
        }
        else if(isOper(curr)) {
            while(top > -1 && isdrop(stack[top], curr)) {
                post[ind++] = stack[top--];
            }
            stack[++top] = curr;
        }
        else {
            post[ind++] = curr;
        }
    }
    while(top > -1) {
        post[ind++] = stack[top--];
    }

    post[ind] = '\0';

    return post;
}

int main() {
    char str[20];
    printf("Enter string: ");
    scanf("%[^\n]s", str);

    char *ans = postfix(str);
    printf("Infix: %s \n", ans);
    free(ans);
    return 0;
}
