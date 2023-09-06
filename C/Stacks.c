#include <stdio.h>
int top=-1;
int stack[4];
int mem[4];

void push(int data){
    if(top==3){
        printf("Stack is full");
    }
    else{
        top++;
        stack[top]=data;
    }
}

void pop(){
    if(top==-1){
        printf("\nstack is empty");
        return;
    }
    else{
        stack[top]=mem[3-top];
        top--;
    }
}

void print(){
    
    for(int i=top;i>=0;i--){
        printf(" %d",stack[i]);
    }
}

int main(){
    push(2);
    pop();
    push(6);
    push(3);
    push(1);
    push(5);
    pop();
    print();
    return 0;
}