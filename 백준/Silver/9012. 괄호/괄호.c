#include <stdio.h>

char stack[50];
int top = 0;

int is_empty() {
	return top == 0;
}
void push(char c) {
	stack[top++] = c;
}

char pop() {
	return stack[--top];
}

int is_VPS(char* str) {
	int result = 1;

	for (int i = 0; str[i]; i++) {
		if (str[i] == '(')
			push(str[i]);
		else {
			if (is_empty()) {
				result = 0;
				break;
			}
			else pop();
		}
	}
	if (!is_empty()) result = 0;
	while (!is_empty())
		pop();

	return result;
}

int main(void) {
	int t;
	char str[50];

	scanf("%d", &t); 

	for (int i = 0; i < t; i++) {
		scanf("%s", str);

		if (is_VPS(str)) printf("YES \n");
		else printf("NO \n");
	}

	return 0;
}