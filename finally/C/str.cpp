#include<stdio.h>

int main() {
	// c�������ַ���Ĭ����"\0"��β�����ַ����Ľ�����־�������ַ���������
	printf("%d\n", sizeof("abcd"));
	printf("%d\n", sizeof("a"));
	printf("%d\n", sizeof(""));

	// c�������ַ�����ʹ�÷���
	char str[16] = "hello";
	printf("%s\n", str);
	return 0;
}