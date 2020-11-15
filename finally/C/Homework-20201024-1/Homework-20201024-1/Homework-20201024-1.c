#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int isPrimeNumber(int number){
	for (int i = 2; i <= sqrt(number); i++){
		if (number % i == 0) {
			return 0;
		}
	}
	return 1;
}

int main(){
	for (int i = 100; i <= 200; i++){
		if (isPrimeNumber(i)) {
			printf("%dÊÇËØÊý\t", i);
		}
	}
	system("pause");
	return 0;
}