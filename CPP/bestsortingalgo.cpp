// C++ implementation of Bogo Sort
#include <iostream>
#include <cstdlib> 
using namespace std;

// To check if array is sorted or not
bool isSorted(int a[], int n)
{
	while (--n > 0)
		if (a[n] < a[n - 1])
			return false;
	return true;
}

// To generate permutation of the array
void shuffle(int a[], int n)
{
	for (int i = 0; i < n; i++)
		swap(a[i], a[rand() % n]);
}

// Sorts array a[0..n-1] using Bogo sort
void bogosort(int a[], int n)
{
	// if array is not sorted then shuffle
	// the array again
	while (!isSorted(a, n))
		shuffle(a, n);
}

// prints the array
void printArray(int a[], int n)
{
	for (int i = 0; i < n; i++)
		printf("%d ", a[i]);
	printf("\n");
}

// Driver code
int main()
{
	int a[] = { 3, 2, 5, 1, 0, 4 ,2,69,420,110,223,123,145,189,190,897,907,97};
	int n = sizeof a / sizeof a[0];
	bogosort(a, n);
	printf("Sorted array :\n");
	printArray(a, n);
	return 0;
}
