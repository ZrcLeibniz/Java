#include<stdio.h>

#pragma 

#define _AGE_ 18

int main() {
	printf("����������");
	int age = 0;
	scanf("%d", &age);
	if (age < _AGE_){
		printf("��������");
	} else {
		printf("������");
	}
	return 0;
}