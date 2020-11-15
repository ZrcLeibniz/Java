#include<stdio.h>
#include<stdlib.h>

void printNumber(int number){
	if (number > 10) {
		printNumber(number / 10);
	}
	printf("%d\t", number % 10);
}

int main(){
	printNumber(1327638493);
	system("pause");
	return 0;
}