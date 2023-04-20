#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

typedef uint8_t BYTE;

int main(int argc, char *argv[])
{

    if (argc != 2)
    {
        printf("Usage: ./recover IMAGE\n");
        return 1;
    }

    FILE *input_file = fopen(argv[1], "r");

    if (input_file == NULL)
    {
        printf("Cannot open file.\n");
        return 2;
    }

    BYTE buffer[512];
    int count = 0;
    char filename[8];
    FILE *output_file = NULL;

    int *pictures = malloc(sizeof(BYTE) * 30);

    while (fread(buffer, sizeof(char), 512, input_file))
    {
        if (buffer[0] == 0xff && buffer[1] == 0xd8 && buffer[2] == 0xff && (buffer[3] & 0xe0) == 0xe0)
        {
            if (!(count == 0))
            {
                fclose(output_file);
            }
            sprintf(filename, "%03i.jpg", count);
            output_file = fopen(filename, "w");
            count++;
        }

        if (output_file != NULL)
        {
            fwrite(buffer, sizeof(char), 512, output_file);
        }
    }

    free(pictures);

    fclose(output_file);
    fclose(input_file);

    return 0;
}