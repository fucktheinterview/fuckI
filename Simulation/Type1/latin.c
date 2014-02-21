/*
 * latin.c
 *
 *	Problem: Latin square is an n �� n array filled with n different symbols,
 *	each occurring exactly once in each row and exactly once in each column.
 *	����������һ��n��n�ķ��󣬷�����ǡ��n�ֲ�ͬ��Ԫ�أ�ÿ��Ԫ��ǡ��n��������ÿ��Ԫ����һ�к�һ���� ǡ�ó���һ�Ρ�
 *	������ѧ�Һ�����ѧ��ŷ��ʹ��������ĸ����Ϊ����������Ԫ�صķ��ţ�����������˶�����
 *	Here is an example:
 *	1 | 2 | 3
 *	2 | 3 | 1
 *	3 | 1 | 2
 *
 *	Implemented with circular linked list.
 *  Created on: Oct 27, 2013
 *      Author: Leon
 */

#include <stdio.h>
#include <stdlib.h>

#define OK 1;

typedef int ElemType;

typedef struct node {
	int data;
	struct node *next;
} node, *linklist;

linklist CreateLinklist(int n) {
	//1<n<10
	linklist p, s;
	int i;

	linklist L = (linklist)malloc(sizeof(node));
	p=L;

	for (i = 1; i <= n; i++) {
		s = (linklist) malloc(sizeof(node));
		s->data = i;
		p->next = s;
		p = s;

	}

	p->next = L->next;
	free(L);
	return p->next;
}

void OutPutLatinSquare(linklist p, int size){
	int i,j;

	for (j=0;j<size;j++){
		linklist s=p;
		for(i=0;i<size;i++){
				printf("%d | ",s->data);
				s=s->next;
			}
			printf("\n");
			p=p->next;
	}


}

int main() {

	int size;
	//scanf("Input square size: %d", &size);

	linklist p = CreateLinklist(7);

	OutPutLatinSquare(p,7);

	return OK;
}
