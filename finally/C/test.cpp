#include<stdio.h> // 必须写
#include<windows.h>

int main() {
	printf("hello world\n");
	system("pause"); // 仅仅是为了让程序暂停一下
	printf("char: %d\n", sizeof(char));
	printf("short: %d\n", sizeof(short));
	printf("int: %d\n", sizeof(int));
	printf("long: %d\n", sizeof(long));
	// printf("long long: %d\n", sizeof(long long));
	printf("float: %d\n", sizeof(float));
	printf("double: %d\n", sizeof(double));
	char c = 'x';
	int i = 10;
	return 0;
}