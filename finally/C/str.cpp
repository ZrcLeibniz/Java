#include<stdio.h>

int main() {
	// c语言中字符串默认以"\0"结尾，是字符串的结束标志，不是字符串的内容
	printf("%d\n", sizeof("abcd"));
	printf("%d\n", sizeof("a"));
	printf("%d\n", sizeof(""));

	// c语言中字符串的使用方法
	char str[16] = "hello";
	printf("%s\n", str);
	return 0;
}