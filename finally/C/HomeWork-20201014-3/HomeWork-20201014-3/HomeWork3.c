#include<stdio.h>

int main(){
	// 计算1 / 1 - 1 / 2 + 1 / 3 - 1 / 4 + 1 / 5 …… + 1 / 99 - 1 / 100 的值，打印出结果
	double result = 0;
	for (int i = 1; i <= 100; i++){
		int num = i;
		if (i % 2 == 0){
			num = -i;
		}
		result = result + (1.0 / num);
	}
	printf("%f\n", result);
	return 0;
}