void main()
{
		int a;
		float b;

		b = 7.14;
		a = 100;
		printf("enter");
		scanf("%d", &a);

		if(a > 10){ b = 3 * (a + 3.14);}
		else{a = b * (b - 3.14);}

		printf("%f", b);
}
