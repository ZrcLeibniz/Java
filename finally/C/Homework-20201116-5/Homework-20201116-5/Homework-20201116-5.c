#include<stdio.h>
#include<stdlib.h>

int myStrlen(const char* str) {
	if (*str == '\0'){
		return 0;
	}
	return myStrlen(str + 1) + 1;
}

int main(){
	char str[] = "abc";
	int result = myStrlen(str);
	printf("%d\n", result);
	system("pause");
	return 0;
}