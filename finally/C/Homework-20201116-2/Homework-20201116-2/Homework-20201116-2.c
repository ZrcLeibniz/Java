#include<stdio.h>
#include<stdlib.h>

char* myStrcat(char* source, const char* target){
	char* temp = source;
	while (*temp != '\0'){
		temp++;
	}
	while(*target != '\0'){
		*temp = *target;
		temp++;
		target++;
	}
	*temp = '\0';
	return source;
}

int main(){
	char source[50] = "hello ";
	char target[] = "rich";
	char* result = myStrcat(source, target);
	printf("%s", result);
	system("pause");
	return 0;
}