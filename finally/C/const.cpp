#include<stdio.h>

#define MAX 100 // �궨��

enum {
	RED,
	YELLOW,
	BALCK,
	BLUE
}; // ö��

int main() {
	int a = MAX;
	const int b = 200; // const�ؼ���
	printf("a: %d, MAX: %d\n", a, MAX);
	return 0;
}