#include<stdio.h>

void maxPrint(int a, int b, int c){
	if (a < b) {
		int temp = a;
		a = b;
		b = temp;
	}
	if (a < c){
		int temp = a;
		a = c;
		c = temp;
	}
	if (b < c) {
		int temp = b;
		b = c;
		c = temp;
	}
	printf("a:%d, b:%d, c:%d", a, b, c);
}

int main(){
	maxPrint(4, 2, 7);
	return 0;
}