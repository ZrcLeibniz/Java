#include<stdio.h>
#include<stdlib.h>

void exchange(int* a, int * b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

int main(){
	int a = 3;
	int b = 5;
	printf("a��ֵ��%d��b��ֵ��%d\n", a, b);
	exchange(&a, &b);
	printf("a��ֵ��%d��b��ֵ��%d\n", a, b);
	system("pause");
	return 0;
}