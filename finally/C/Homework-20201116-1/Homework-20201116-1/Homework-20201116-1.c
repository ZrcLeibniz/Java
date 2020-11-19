#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char* myStrstr(const char* source, const char* target) {
	char* sourceErgodic = source;
	char* sourceComparison = source;
	char* targetComparison = target;
	while (*sourceErgodic != '\0'){
		while (*targetComparison != '\0' && *sourceComparison != '\0'){
			if (*targetComparison == *sourceComparison){
				targetComparison++;
				sourceComparison++;
			} else {
				break;
			}
		}
		if (*targetComparison == '\0'){
			return sourceErgodic;
		}
		if (*targetComparison != '\0' && *sourceComparison == '\0') {
			return NULL;
		}
		sourceErgodic++;
		sourceComparison = sourceErgodic;
		targetComparison = target;
	}
	return NULL;
}

int main(){
	char source[] = "Hello rich";
	char target[] = "ich";
	char* myStrstrResult = myStrstr(source, target);
	char* strstrResult = strstr(source, target);
	printf("%s\n", myStrstrResult);
	printf("%s\n", strstrResult);
	system("pause");
	return 0;
}