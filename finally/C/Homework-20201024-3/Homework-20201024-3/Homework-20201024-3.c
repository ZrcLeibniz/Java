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
	printf("a的值：%d，b的值：%d\n", a, b);
	exchange(&a, &b);
	printf("a的值：%d，b的值：%d\n", a, b);
	system("pause");
	return 0;
}