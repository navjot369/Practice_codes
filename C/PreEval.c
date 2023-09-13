#include <stdio.h>
#include <string.h>
#include <math.h>

int intoNum(char *str) {
    int ans = 0, len = strlen(str);
    for(int i = 0; i < len; i++) {
        ans *= 10;
        ans += (str[i] - '0');
    }
    return ans;
}

int isOper(char ch) {
    return (ch == '+' || ch == '-' || ch == '*' ||
    ch == '/' || ch == '^');
}

int calculate(int num1, int num2, char oper) {
    switch (oper) {
        case '+': return num1 + num2;
        case '-': return num1 - num2;
        case '*': return num1 * num2;
        case '/': return num1 / num2;
        case '^': return pow(num1, num2);
        default : return -1;
    }
}

int prefix(char *str) {
    int stack[10];
    int top = -1;

    for(int i = strlen(str) - 1; i >= 0; i--){
        if(str[i] == ' ' || str[i] == '\t') {
            continue;
        }

        if(isOper(str[i])) {
            int num1 = stack[top--];
            int num2 = stack[top--];
            stack[++top] = calculate(num1, num2, str[i]);
        }
        else {
            int size = 0;
            while(i >= 0 && str[i] != ' ') {
                size++;
                i--;
            }
            char temp[10];
            strncpy(temp, str + i + 1, size);
            temp[size] = '\0';
            stack[++top] = intoNum(temp);
            for(int i = 0; i < top; i++) {
                printf("%d  ", stack[i]);
            }
            printf("\n");
        }
    }
    return stack[top--];
}

int main() {
    char str[30];
    printf("Enter string(Prefix): ");
    scanf("%[^\n]s", str);

    int result = prefix(str);
    printf("Result: %d \n", result);

}