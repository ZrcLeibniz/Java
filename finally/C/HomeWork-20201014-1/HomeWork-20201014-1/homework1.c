#include<stdio.h>
#include<math.h>

int main() {
	//дһ�����룺��ӡ100~200֮�������
	int i = 0;
	int j = 0;
	for (i = 100; i <= 200; i++) {
		for (j = 2; j <= sqrt(i); j++){
			if (i % j == 0) {
				break;
			}
		}
		if (j > sqrt(i)){
			printf("%d\t", i);
		}
	}
	return 0;
}