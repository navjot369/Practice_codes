#include <iostream>
using namespace std;

void sort(int arr[], int len) {
    int min, temp;
    for(int i = 0; i < len-1; i++) {
        min = i;
        for(int j = i+1; j < len; j++) {
            if(arr[j] < arr[min]) {
                min = j;
            }
        }
        if(min != i) {
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        for(int i = 0; i < len; i++) {
            cout << arr[i] << "  ";
        }
        cout << endl;
    }
}

int main(){
    int arr[] = {6, 3 ,4 ,2 ,1 ,3};
    sort(arr, 6);

    for(int i = 0; i < 6; i++) {
        cout << arr[i] << "  ";
    }
    cout << endl;
}