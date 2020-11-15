#include<stdio.h>
#include<stdlib.h>

int recursionFactorial(int target){
	if (target == 1) {
		return 1;
	}
	return recursionFactorial(target - 1) * target;
}

int nonRecursionFactorial(int target){
	int result = 1;
	for (int i = 1; i <= target; i++){
		result *= i;
	}
	return result;
}

int main(){
	int recursionResult = recursionFactorial(5);
	int nonRecursionResult = nonRecursionFactorial(5);
	printf("%d\n", recursionResult);
	printf("%d\n", nonRecursionResult);
	system("pause");
	return 0;
}