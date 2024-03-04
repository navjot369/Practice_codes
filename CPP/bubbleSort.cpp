#include <iostream>
using namespace std;

void bubble(int[], int);

int main() {
    int arr[] = {6, 4, 5, 2, 3, 1};
    bubble(arr, 6);

    for(int i = 0; i < 6; i++) {
        cout << arr[i] << " ";
    }
}

void bubble(int arr[], int len) {
    bool swap = false;
    for(int i = len-1; i > 0; i--) {
        swap = false;
        for(int j = 0; j < i; j++) {
            if(arr[j+1] < arr[j]) {
                swap = true;
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
        if(!swap) {
            return;
        }
    }
}