#include<stdio.h>

int main(){
	// 编写代码在一个整形有序数组中查找具体的某个数
	int a[] = {5, 2, 6, 7, 4};
	int target = 6;
	int length = sizeof(a) / sizeof(a[0]);
	for (int i = 0; i < length; i++){
		if (a[i] == target){
			printf("数字的下标为:%d\n", i);
		}
	}
	printf("找不到该数字");
}