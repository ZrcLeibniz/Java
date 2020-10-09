#include<stdio.h>

int global = 100;

int main() {
	int global = 200;
	printf("global: %d\n", global);
	int num1 = 0;
	int num2 = 0;
	scanf("%d %d", &num1, &num2);
	int num3 = num1 + num2;
	printf("num3: %d\n", num3);
	return 0;
} 