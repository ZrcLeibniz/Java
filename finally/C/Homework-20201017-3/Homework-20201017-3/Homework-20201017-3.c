#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int meau(){
	int choice = 0;
	printf("**********************\n");
	printf("  ��ӭ������������Ϸ\n");
	printf("**********************\n");
	printf("���������Ϸ�밴1���˳���Ϸ�밴�����\n");
	scanf("%d", &choice);
	return choice;
}

void game(){
	srand(time(NULL));
	int target = rand() % 100;
	while (1){
		printf("�����������µ�����\n");
		int temp = 0;
		scanf("%d", &temp);
		if (temp > target){
			printf("�´���\n");
		}
		else if (temp < target) {
			printf("��С��\n");
		}
		else{
			printf("��ϲ�㣬�¶���\n");
			break;
		}
	}
}
 
int main(){
	// ��ӡ��Ϸ�˵�
	while (1){
		int choice = meau();
		if (choice){
			//������Ϸ
			printf("���ѽ�����Ϸ\n");
			game();
		} else {
			break;
		}
	}
	system("pause");
	return 0;
}