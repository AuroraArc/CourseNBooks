    #include <cs50.h>
#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <math.h>

int count_letters(string text);
int count_words(string text);
int count_sentences(string text);

int main(void)
{
    string input = get_string("Text: ");
    double index = 0;
    double L = 0;
    double S = 0;
    L = (double)count_letters(input) / count_words(input) * 100.0;
    S = (double)count_sentences(input) / count_words(input) * 100.0;
    index = 0.0588 * L - 0.296 * S - 15.8;
    if (index < 1)
    {
        printf("Before Grade 1\n");
    }
    else if (index > 16)
    {
        printf("Grade 16+\n");
    }
    else
    {
        printf("Grade %i\n", (int)round(index));
    }
}

int count_letters(string text)
{
    int count = 0;
    for (int i = 0, length = strlen(text); i < length; i++)
    {
        if (isalpha(text[i]))
        {
            count++;
        }
    }
    return count;
}

int count_words(string text)
{
    int count = 0;
    for (int i = 0, length = strlen(text); i < length; i++)
    {
        if (text[i] == ' ')
        {
            if (isalpha(text[i + 1]) || text[i + 1] == '"')
            {
                count++;
            }
        }
    }
    return count + 1;
}

int count_sentences(string text)
{
    int count = 0;
    for (int i = 0, length = strlen(text); i < length; i++)
    {
        if (text[i] == '.' || text[i] == '!' || text[i] == '?')
        {
            count ++;
        }
    }
    return count;
}