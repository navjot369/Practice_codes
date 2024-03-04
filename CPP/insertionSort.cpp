#include <iostream>
using namespace std;

void sort(int arr[], int len) {
    int temp, j;
    for(int i = 1; i < len; i++) {
        if(arr[i] < arr[i-1]) {
            temp = arr[i];
            j = i-1;
            while(j >= 0 && arr[j] >= temp) {
                arr[j+1] = arr[j];
                j--;
            }
            j++;
            arr[j] = temp;
        }
        for(int i = 0; i < len; i++) cout << arr[i] << "  ";
        cout << endl;
     }
}

int main() {
    int arr[] = {3, 3, 5, 2, 1 , 3};
    sort(arr, 6);
    for(int i = 0; i < 6; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

