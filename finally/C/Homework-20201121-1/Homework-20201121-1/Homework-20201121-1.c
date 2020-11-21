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
	printf("������ϵ��\n");
	if (address->size >= 1024) {
		printf("��Ա����");
		return;
	}
	printf("����������");
	scanf("%s", address->person[address->size].name);
	printf("������绰");
	scanf("%s", address->person[address->size].tel);
	address->size++;
	printf("������ϵ�˳ɹ�");
}

void updateAddress(AddressBook* address){
	printf("�޸���ϵ��");
	printf("������Ҫ�޸ĵı��");
	int id = 0;
	scanf("%d", &id);
	if (id < 0 || id > address->size){
		printf("�����ڴ���ϵ��");
		return;
	}
	printf("�������޸ĺ������");
	scanf("%s", address->person[id].name);
	printf("�������޸ĺ�ĵ绰");
	scanf("%s", address->person[id].tel);
	printf("�޸ĳɹ�");
}

void deleteAddress(AddressBook* address){
	printf("ɾ����ϵ��");
	printf("����ɾ����ϵ�˵ı��");
	int id = 0;
	scanf("%d", &id);
	if (id < 0 || id >= address->size) {
		printf("������ı������");
		return;
	}
	if (id == address->size - 1) {
		address->size--;
		printf("ɾ���ɹ�");
		return;
	}
	address->person[id] = address->person[address->size - 1];
	address->size--;
	printf("ɾ���ɹ�");
}

void selectAddress(AddressBook* address){
	printf("������ϵ��");
	printf("������Ҫ���ҵ�����");
	char name[1024] = { 0 };
	scanf("%s", name);
	for (int i = 0; i < address->size; i++){
		Person* p = &address->person[i];
		if (strcmp(name, p->name) == 0) {
			printf("[%d]\t\t%s\t\t%s\n", i, p->name, p->tel);
		}
	}
	printf("�������");
}

void queryAddress(AddressBook* address){
	printf("��ӡ������ϵ��");
	for (int i = 0; i < address->size;  i++){
		Person* p = &address->person[i];
		printf("[%d]\t\t%s\t\t%s\n", i, p->name, p->tel);
	}
	printf("��ǰͨѶ¼��%d����",address->size);
}

void clearAddress(AddressBook* address){
	printf("���ͨѶ¼");
	printf("��ȷ��Ҫ���ͨѶ¼������������yes/no");
	char option[] = "";
	scanf("%s", option);
	if (!strcmp("yes", option)){
		printf("����ɹ�");
		address->size = 0;
	}
	if (!strcmp("no", option)){
		return;
	}
	return;
}

int meau(){
	printf("��ӭ����ͨѶ¼����");
	printf("1��������û�\n");
	printf("2���޸����û�\n");
	printf("3��ɾ�����û�\n");
	printf("4����ѯ�û�\n");
	printf("5����ѯ�����û�\n");
	printf("6, ���ͨѶ¼\n");
	printf("������������ѡ��\n");
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
			printf("������ı������,����������");
			continue;
		}
		func[choice];
	}
	system("pause");
	return 0;
}