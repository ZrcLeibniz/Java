#include<stdio.h>
#include<stdlib.h>

char* myStrcpy(const char* source, const char* target){
	char* temp = target;
	while (*source != '\0') {
		*temp = *source;
		temp++;
		source++;
	}
	*temp = '\0';
	return target;
}

int main() {
	char target[20] = "";
	char source[] = "rich";
	char * result = myStrcpy(source, target);
	printf("%s\n", result);
	system("pause");
	return 0;
}
