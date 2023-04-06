#include <cs50.h>
#include <stdio.h>

int main(void)
{
    long number = get_long("Number: ");
    long verify = number;
    int verifyOne = 0;
    int digits = 1;
    int algoOne = 0;
    while ((number / 10) >= 1)
    {
        verifyOne = number % 10;
        if (digits % 2 != 0)
        {
            algoOne += number % 10;
        }
        number = number / 10;
        digits++;
        if (digits % 2 == 0)
        {
            int divOne = 0;
            divOne = (number % 10) * 2;
            if ((divOne / 10) >= 1)
            {
                int divOneF = 0;
                int divOneS = 0;
                divOneF = divOne % 10;
                divOneS = (divOne / 10) % 10;
                algoOne += divOneF + divOneS;
            }
            else
            {
                algoOne += divOne;
            }
        }
    }
    if (digits % 2 == 0)
    {
    }
    else
    {
        algoOne += number % 10;
    }
    if (algoOne % 10 != 0)
    {
        printf("INVALID\n");
    }
    else if (number == 4 && (digits == 13 || digits == 16))
    {
        printf("VISA\n");
    }
    else if (number == 3 && (verifyOne == 4 || verifyOne == 7) && digits == 15)
    {
        printf("AMEX\n");
    }
    else if (number == 5 && (verifyOne == 1 || verifyOne == 2 || verifyOne == 3 || verifyOne == 4 || verifyOne == 5) && digits == 16)
    {
        printf("MASTERCARD\n");
    }
    else
    {
        printf("INVALID\n");
    }
}