#include <cs50.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main(int argc, string argv[])
{
    if (argc != 2)
    {
        printf("Please input one key.\n");
        return 1;
    }
    if (strlen(argv[1]) != 26)
    {
        printf("Key should include 26 letters.\n");
        return 1;
    }
    string key = argv[1];
    string key_upper = key;
    for (int i = 0; i < 26; i++)
    {
        key_upper[i] = toupper(key[i]);
    }
    for (int i = 0; i < 26; i++)
    {
        if (!isalpha(key[i]))
        {
            printf("Key should only include letters.\n");
            return 1;
        }
    }
    for (int i = 0; i < 26; i++)
    {
        for (int j = i + 1; j < 26; j++)
        {
            if (key_upper[i] == key_upper[j])
            {
                printf("Key should include each letter only once.\n");
                return 1;
            }
        }
    }
    string plaintext = get_string("plaintext: ");
    string ciphertext = plaintext;
    string alphabet_upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    string alphabet_lower = "abcdefghijklmnopqrstuvwxyz";
    for (int i = 0; i < strlen(plaintext); i++)
    {
        for (int j = 0; j < 26; j++)
        {
            if (!isalpha(ciphertext[i]))
            {
                break;
            }
            if (ciphertext[i] == alphabet_upper[j])
            {
                ciphertext[i] = toupper(key[j]);
                break;
            }
            if (ciphertext[i] == alphabet_lower[j])
            {
                ciphertext[i] = tolower(key[j]);
                break;
            }
        }
    }
    printf("ciphertext: %s", ciphertext);
    printf("\n");
    return 0;

}