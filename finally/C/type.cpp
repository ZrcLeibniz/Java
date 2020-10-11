#include<stdio.h>

extern int global;

void test(int x) {
	x = x + 1;
}

int main() {
	//printf("char: %d", sizeof(char));
	int num = 1;
	printf("%d\n", num);
	test(num);
	printf("%d\n", num);
	printf("%d\n", global);
	// printf("%d\n", global2);
	return 0;
}

