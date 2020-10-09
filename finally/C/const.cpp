#include<stdio.h>

#define MAX 100 // 宏定义

enum {
	RED,
	YELLOW,
	BALCK,
	BLUE
}; // 枚举

int main() {
	int a = MAX;
	const int b = 200; // const关键字
	printf("a: %d, MAX: %d\n", a, MAX);
	return 0;
}