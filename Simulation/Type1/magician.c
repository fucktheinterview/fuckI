/*
 * magician.c
 *
 *  Created on: Oct 22, 2013
 *      Author: Leon
 */

/*
 * Question: Magician Licensing Problem
 * Explanation: ħ��ʦ����һ�����е�13�ź��ƣ�Ԥ�Ƚ������źú������һ�����泯�¡�
 * �Թ���˵�����Ҳ����ƣ�ֻ�����Ϳ��Բµ�ÿ������ʲô���Ҵ��������������������ţ��ֳ���ʾ����
 * ħ��ʦ�����������������Ϊ1�����������������Ǻ���A��������A���������ϣ��ڶ�����1,2������һ���Ʒ�����Щ�Ƶ����棬
 * ���ڶ����Ʒ������������Ǻ���2��Ҳ���������������������ν��н�13����ȫ��������׼ȷ����
 * Problem: �ƵĿ�ʼ˳������ΰ��ŵģ�
 *
 * Implemented by using circular linklist.
 * Contributor: Yucheng Liu
 *
 * Created on: Oct 23, 2013
 */

#include <stdio.h>
#include <stdlib.h>

#define CardNum 13

typedef struct node {
	int data;
	struct node *next;
} node, *linklist;

//Create a linklist in which all node's data are set as 0
linklist CreateLinkList() {
	linklist head = NULL;
	linklist p, s;

	int i;
	p = head;

	for (i = 0; i < CardNum; i++) {
		s = (linklist) malloc(sizeof(node));
		s->data = 0;

		if (head == NULL)
			head = s;
		else
			p->next = s;

		p = s;
	}

	p->next = head;

	return head;
}

void Magician(linklist head) {
	linklist p;
	int j;
	int counter = 2;

	p = head;
	p->data = 1;

	while (1) {
		for (j = 0; j < counter; j++) {
			p = p->next;
			if (p->data != 0) {
				p = p->next;
				j--;
			}

		}

		if(p->data ==0){
			p->data = counter;
			counter++;

			if (counter == 14)
				break;
		}
	}
}

int main() {
	linklist p;
	int i;

	p = CreateLinkList();
	Magician(p);

	for (i = 0; i < CardNum; i++) {
		printf("����%d ->", p->data);
		p = p->next;
	}

	free(p);
	return 0;
}
