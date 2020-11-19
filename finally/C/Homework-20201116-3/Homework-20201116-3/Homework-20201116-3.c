#include<stdio.h>
#include<stdlib.h>

int myStrcmp(const char* str1, const char* str2){
	while (str1 != '\0' && str2 != '\0') {
		if (*str1 == *str2){
			str1++;
			str2++;
		} else if (*str1 > *str2){
			return 1;
		}
		else {
			return -1;
		}
	}
	if (*str1 == '\0' && *str2 != '\0'){
		return -1;
	}else if (*str2 == '\0' && *str1 != '\0'){
		return 1;
	}
	return 0;
}

int main(){
	char str1[] = "abc";
	char str2[] = "ab";
	int a = myStrcmp(str1, str2);
	printf("%d", a);
	system("pause");
	return 0;
}