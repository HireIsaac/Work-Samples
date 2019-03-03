/*
 * main.c
 *
 *  Created on: Mar 10, 2018
 *      Author: Isaac
 */

#include <stdio.h>
#include <stdlib.h>

void swap(int *a, int *b) {
	int temp=*a;
	*a=*b;
	*b=temp;
}

void print(int *n, int size) {
	for (int i = 0; i < size; i++)
		printf("%d ", *n++);
	puts("");
}

void bubbleSort(int *n, int size) {
	int cont = 1;
	while (cont) {
		cont = 0;
		for (int i = 0; i < size-1 ; i++)
			if (n[i] > n[i + 1])
				swap(n + i,n + i + 1), cont = 1;
	}
}

void ssort(int *p, int n) {
	int i, j;
	printf("\nSorting Array\n");
	for (j = 0; j < n - 1; j++) {
		int iMin = j;


		for (i = j + 1; i < n; i++) {
			if (p[i] < p[iMin]) {
				iMin = i;
			}
		}
		if(iMin != j) {
			swap(p + j, p + iMin);
		}
	}
}

void merge(int *p, int sizep, int * q, int sizeq, int * * res, int * sizer) {
	int actual_size=0;
	int i=0;
	int j=0;

	*res=(int *)calloc(sizep+sizeq, sizeof(int));

	while (i < sizep ){
		while (i+1<sizep && p[i]==p[i+1]) i++;
		(*res)[actual_size++]=p[i++];
	}

	while (j < sizeq ){
		while (j+1<sizeq && q[j]==q[j+1]) j++;
		(*res)[actual_size++]=q[j++];
	}

	*res=(int *)realloc(*res, actual_size*sizeof(int) );
	*sizer=actual_size;
}



int main(void){

	int a[] = {9, 3, 0, 3, 10, 1, 6, 29, 83, 1777, -12, -42};
	int b[] = {4, -2, 54, 7, -694, 2, 9, 3, 6, 1, 6};

	int size_a=sizeof(a)/sizeof(int);
	int size_b=sizeof(b)/sizeof(int);

	int * merged = NULL;
	int merged_size=0;

	printf("Array A: (unsorted)\n");
	print(a,size_a);

	printf("Array B: (unsorted)\n");
	print(b,size_b);

	ssort(a, size_a);


	ssort(b, size_b);

	printf("\nArray A: (sorted)\n");
	print(a, size_a);
	printf("\nArray B: (sorted) \n");
	print(b, size_b);

	merge(a, size_a, b, size_b, &merged, &merged_size);
	bubbleSort(merged, merged_size);
	puts("\nArrays A and B merged:");
	print(merged, merged_size);


}


