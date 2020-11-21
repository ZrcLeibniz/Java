#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>


typedef struct Person{
	char name[1024];
	char tel[1024];
} Person;

typedef struct AddressBook{
	Person person[1024];
	int size;
} AddressBook;

AddressBook address;

void init(AddressBook* address) {
	address->size = 0;
}

void addAddress(AddressBook* address){
	printf("新增联系人\n");
	if (address->size >= 1024) {
		printf("人员已满");
		return;
	}
	printf("请输入姓名");
	scanf("%s", address->person[address->size].name);
	printf("请输入电话");
	scanf("%s", address->person[address->size].tel);
	address->size++;
	printf("新增联系人成功");
}

void updateAddress(AddressBook* address){
	printf("修改联系人");
	printf("请输入要修改的编号");
	int id = 0;
	scanf("%d", &id);
	if (id < 0 || id > address->size){
		printf("不存在此联系人");
		return;
	}
	printf("请输入修改后的姓名");
	scanf("%s", address->person[id].name);
	printf("请输入修改后的电话");
	scanf("%s", address->person[id].tel);
	printf("修改成功");
}

void deleteAddress(AddressBook* address){
	printf("删除联系人");
	printf("输入删除联系人的编号");
	int id = 0;
	scanf("%d", &id);
	if (id < 0 || id >= address->size) {
		printf("您输入的编号有误");
		return;
	}
	if (id == address->size - 1) {
		address->size--;
		printf("删除成功");
		return;
	}
	address->person[id] = address->person[address->size - 1];
	address->size--;
	printf("删除成功");
}

void selectAddress(AddressBook* address){
	printf("查找联系人");
	printf("请输入要查找的姓名");
	char name[1024] = { 0 };
	scanf("%s", name);
	for (int i = 0; i < address->size; i++){
		Person* p = &address->person[i];
		if (strcmp(name, p->name) == 0) {
			printf("[%d]\t\t%s\t\t%s\n", i, p->name, p->tel);
		}
	}
	printf("查找完成");
}

void queryAddress(AddressBook* address){
	printf("打印所有联系人");
	for (int i = 0; i < address->size;  i++){
		Person* p = &address->person[i];
		printf("[%d]\t\t%s\t\t%s\n", i, p->name, p->tel);
	}
	printf("当前通讯录有%d个人",address->size);
}

void clearAddress(AddressBook* address){
	printf("清除通讯录");
	printf("您确定要清除通讯录的所有内容吗？yes/no");
	char option[] = "";
	scanf("%s", option);
	if (!strcmp("yes", option)){
		printf("清除成功");
		address->size = 0;
	}
	if (!strcmp("no", option)){
		return;
	}
	return;
}

int meau(){
	printf("欢迎进入通讯录程序");
	printf("1，添加新用户\n");
	printf("2，修改新用户\n");
	printf("3，删除新用户\n");
	printf("4，查询用户\n");
	printf("5，查询所有用户\n");
	printf("6, 清空通讯录\n");
	printf("请您输入您的选择\n");
	int choice = 0;
	scanf("%d", &choice);
	return choice;
}

typedef void (*func)(AddressBook* address);

int main() {
	func func[] = {
		NULL,
		addAddress,
		deleteAddress,
		updateAddress,
		selectAddress,
		queryAddress,
		clearAddress,
	};
	while (1){
		int choice = meau();
		if (choice < 0 || choice >= sizeof(func)/sizeof(func[0])) {
			printf("您输入的编号有误,请重新输入");
			continue;
		}
		func[choice];
	}
	system("pause");
	return 0;
}