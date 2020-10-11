#include<stdio.h>

#pragma 

#define _AGE_ 18

int main() {
	printf("请输入年龄");
	int age = 0;
	scanf("%d", &age);
	if (age < _AGE_){
		printf("还是少年");
	} else {
		printf("长大了");
	}
	return 0;
}