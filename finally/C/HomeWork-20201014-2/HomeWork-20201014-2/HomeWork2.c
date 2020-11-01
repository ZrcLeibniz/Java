#include<stdio.h>

int main(){
	// 编写程序数一下 1到 100 的所有整数中出现多少个数字9
	int count = 0;
	for (int i = 90; i <= 100; i++){
		int num = i;
		while (num >= 9){
			if (num % 10 == 9) {
				count++;
			}
			num = num / 10;
		}
	}
	printf("%d\n", count);
	return 0;
}