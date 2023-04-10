#include <stdio.h>
#include <cs50.h>

int main(void)
{
    int n = get_int("Height: ");
    while (n < 1 || n > 8)
    {
        n = get_int("Height: ");
    }
    int iter = 0;
    for (int i = n; i > 0; i--)
    {
        //left side
        int j = 1;
        while (j < i)
        {
            printf(" ");
            j++;
        }
        iter++;
        for (int z = 0; z < iter; z++)
        {
            printf("#");
        }
        //spacing in middle
        printf("  ");

        //right side
        for (int x = 0; x < iter; x++)
        {
            printf("#");
        }

        printf("\n");
    }
}