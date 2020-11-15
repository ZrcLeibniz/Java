#include<stdio.h>
#include<stdlib.h>

int isLeapYear(int year){
	if (year % 4 == 0){
		if (year % 100 == 0) {
			if (year % 400 == 0) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 1;
		}
	} else {
		return 0;
	}
}

int main(){
	for (int i = 1000; i <= 3000; i++) {
		if (isLeapYear(i)){
			printf("%dÊÇÈòÄê\t", i);
		}
	}
	system("pause");
	return 0;
}