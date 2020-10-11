#include<stdio.h>

#define SIZE 64

int main() {
	int a = 1;
	int b = 2;
	printf("long long: %d\n", sizeof(long long));
	printf("%d", add(1, 2));
	struct stu tom = {"tom", 15, "0", "110"};
	struct str* p = &tom;
	printf("%s, %s", tom.name, tom.age);
	return 0;
}

struct stu{
	char name[SIZE];
	int age;
	char sex[5];
	char id[15];
};