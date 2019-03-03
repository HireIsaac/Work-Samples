#include <stdio.h>
#include <math.h>

double sortTimer(int* a, int size, void (*f)(int*, int));

int numlevels(int height)
{
	int num = 1;
	int layer = 0;
	int last_layer = 0;

	for (int i = height; i > 0; i--){
		layer = last_layer + num;
		last_layer = layer;
		num = num + 1;
	}
	return layer;

	/* Piotr. I know numlevels has some bad naming conventions but I have a headache from the stupidity
	 * and simpleness that was coming up with it. It was so simple and I spent half an hour on it.
	 */



}
//numlevels takes the user input height, and returns the total number of spheres that will be in the pyramid.

double ballCalc(double radius)
{
	double pi = 4.0 * atan(1.0);
	double vol = 4 * pi * radius * radius* radius / 3;
	double silverMASS = 0.379;
	return vol * silverMASS;
}

//circleCalc takes the radius of spheres, and outputs the mass, using iron weight supplied by piotr

double p3 (int height, double rad){
	double mass = numlevels(height)  * ballCalc(rad);
	return mass;
}

//Above is p3, this is called later in main. This pretty much finishes Q1. Indented below to Q2



//String compare funct
int strings_comp(char a[], char b[])
{
   int c = 0;

   while (a[c] == b[c]) {
      if (a[c] == '\0' || b[c] == '\0')
         break;
      c++;
   }

   if (a[c] == '\0' && b[c] == '\0')
      return 0;
   else
      return -1;
}




//Array_gen takes array and length and inserts random numbers into array
void array_gen (int array[],int len){
	for (int i = len; i >0; i--){
		array[i] = rand() % len + 1;
	}

}


//This is sort function from previous assignment
void sort(int array[], int n)
{
	setbuf(stdout, NULL);
    int i,step,temp;


    for(step=0;step<n-1;++step)
    for(i=0;i<n-step-1;++i)
    {
        if(array[i]>array[i+1])
        {
        	temp=array[i];
        	array[i]=array[i+1];
        	array[i+1]=temp;

        }
    }
    printf("\nIn ascending order\n: ");
    for(i=0;i<n;++i)
         printf("%d  ",array[i]);

    }


//implement_clock simply creates three arrays for testing, inserts random numbers, and displays compute time
void implement_clock(){
	int array1[100];
	int array2[200];
	int array3[300];

	array_gen(array1,100);
	array_gen(array1,100);
	array_gen(array1,100);

	sortTimer(array1, 100, sort);
	sortTimer(array2, 200, sort);
	sortTimer(array3, 300, sort);

}


//
//int main()
//{
//	int height;
//	double rad;
//	char str1[1000], str2[1000];
//	setbuf(stdout, NULL);
//
//	//Below calls Q2. I had a weird error when I put it after Q1, so it will be the first thing implemented.
//	printf("Input string to compare\n");
//	gets(str1);
//	printf("Input another string to compare\n");
//	gets(str2);
//	if (strings_comp(str1, str2) == 0)
//		printf("Equal strings.\n");
//	else
//		printf("Unequal strings.\n");
//
//	//Here is the triangle ball calc
//    printf("\n\nEnter # of levels for ball calc:\n ");
//    scanf("%d", &height);
//    printf("You entered: %d\n", height);
//    printf("Enter radius of spheres:\n ");
//    scanf("%lf", &rad);
//    printf("You entered: %f\n", rad);
//	printf("Mass of pyramid: %f", p3(height,rad) );
//
//
//
//
//	//Implement clock is kind of yucky, but it works
//	implement_clock();
//	return 0;
//}
