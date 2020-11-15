#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int meau(){
	int choice = 0;
	printf("**********************\n");
	printf("  欢迎来到猜数字游戏\n");
	printf("**********************\n");
	printf("如想进入游戏请按1，退出游戏请按任意键\n");
	scanf("%d", &choice);
	return choice;
}

void game(){
	srand(time(NULL));
	int target = rand() % 100;
	while (1){
		printf("请输入你所猜的数字\n");
		int temp = 0;
		scanf("%d", &temp);
		if (temp > target){
			printf("猜大了\n");
		}
		else if (temp < target) {
			printf("猜小了\n");
		}
		else{
			printf("恭喜你，猜对了\n");
			break;
		}
	}
}
 
int main(){
	// 打印游戏菜单
	while (1){
		int choice = meau();
		if (choice){
			//进入游戏
			printf("您已进入游戏\n");
			game();
		} else {
			break;
		}
	}
	system("pause");
	return 0;
}