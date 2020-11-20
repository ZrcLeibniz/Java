#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void* myMemmove(const void* source, void* target, size_t n){
	char* sourceTemp = (char*)source;
	char* targetTemp = (char*)target;
	for (size_t i = 0; i < n; i++){
		*(targetTemp + i) = *(sourceTemp + i);
	}
	return target;
}

int main(){
	int a[10] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	int b[10] = {0};
	int* result = myMemmove(a, b, 10 * sizeof(int));
	int* result2 = memmove(a, b, 10);
	for (int i = 0; i < 10; i++){
		printf("%d\n", *(result+i));
	}
	printf("-----------------------\n");
	for (int i = 0; i < 10; i++){
		printf("%d\n", *(result2 + i));
	}
	system("pause");
	return 0;
}