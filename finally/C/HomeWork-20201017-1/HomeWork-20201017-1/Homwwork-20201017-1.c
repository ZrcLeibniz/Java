#include<stdio.h>
#include<stdlib.h>

int maxofTen(int arr[]) {
	int max = 0;
	for (int i = 0; i < 10; i++){
		if (max < arr[i]) {
			max = arr[i];
		}
	}
	return max;
}

int main(){
	int arr[] = { 3, 5, 3, 6, 10, 7, 3, 98, 6, 10 };
	int result = maxofTen(arr);
	printf("%d\n", result);
	system("pause");
}