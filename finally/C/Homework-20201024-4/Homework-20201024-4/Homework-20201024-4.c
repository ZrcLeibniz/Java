#include<stdio.h>
#include<stdlib.h>

int multiplicationTable(int tableNumber){
	for (int i = 1; i <= tableNumber; i++){
		for (int j = 1; j <= i; j++){
			printf("%d X %d = %d\t", j, i, i * j);
		}
		printf("\n");
	}
}

int main(){
	multiplicationTable(10);
	system("pause");
	return 0;
}