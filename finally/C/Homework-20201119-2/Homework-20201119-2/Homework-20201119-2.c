#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char* myMemmove(const void* source, void* target, size_t n){
	char* targetTemp = (char*)target;
	char* sourceTemp = (char*)source;
	if (targetTemp > sourceTemp && targetTemp < (sourceTemp + n)){
		for (int i = n - 1; i >= 0; i--) {
			*(targetTemp + i) = *(sourceTemp + i);
		}
	} else {
		for (int i = 0; i < 0; i++) {
			*(targetTemp + i) = *(sourceTemp + i);
		}
	}
}

int main(){
	int a[10] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	int b[10] = {0};

	system("pause");
	return 0;
}