#include<stdio.h>

int main(){
	// ��д������һ�� 1�� 100 �����������г��ֶ��ٸ�����9
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