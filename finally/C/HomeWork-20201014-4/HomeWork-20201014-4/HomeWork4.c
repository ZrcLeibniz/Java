#include<stdio.h>

int main(){
	// ��д������һ���������������в��Ҿ����ĳ����
	int a[] = {5, 2, 6, 7, 4};
	int target = 6;
	int length = sizeof(a) / sizeof(a[0]);
	for (int i = 0; i < length; i++){
		if (a[i] == target){
			printf("���ֵ��±�Ϊ:%d\n", i);
		}
	}
	printf("�Ҳ���������");
}