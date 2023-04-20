#include "helpers.h"
#include <stdlib.h>
#include <math.h>


// Convert image to grayscale
void grayscale(int height, int width, RGBTRIPLE image[height][width])
{
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            if (image[i][j].rgbtBlue == image[i][j].rgbtGreen && image[i][j].rgbtGreen == image[i][j].rgbtRed)
            {
                continue;
            }
            else
            {
                int avg = round((image[i][j].rgbtBlue + image[i][j].rgbtGreen + image[i][j].rgbtRed) / 3.0);
                image[i][j].rgbtBlue = avg;
                image[i][j].rgbtGreen = avg;
                image[i][j].rgbtRed = avg;
            }
        }
    }
    return;
}

// Reflect image vertically
void reflect(int height, int width, RGBTRIPLE image[height][width])
{
    int width_half;
    if (width % 2 != 0)
    {
        width_half = round(width / 2);
    }
    else
    {
        width_half = width / 2;
    }

    for (int i = 0; i < height; i++)
    {
        for (int j = 0, k = width; j < width_half && k > width_half; j++, k--)
        {
            int pixel_leftBlue = image[i][j].rgbtBlue;
            int pixel_leftGreen = image[i][j].rgbtGreen;
            int pixel_leftRed = image[i][j].rgbtRed;

            int pixel_rightBlue = image[i][k - 1].rgbtBlue;
            int pixel_rightGreen = image[i][k - 1].rgbtGreen;
            int pixel_rightRed = image[i][k - 1].rgbtRed;

            image[i][j].rgbtBlue = pixel_rightBlue;
            image[i][j].rgbtGreen = pixel_rightGreen;
            image[i][j].rgbtRed = pixel_rightRed;

            image[i][k - 1].rgbtBlue = pixel_leftBlue;
            image[i][k - 1].rgbtGreen = pixel_leftGreen;
            image[i][k - 1].rgbtRed = pixel_leftRed;
        }
    }
    return;
}

// Blur image
void blur(int height, int width, RGBTRIPLE image[height][width])
{
    RGBTRIPLE temp[height][width];

    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            int tlBlue = 0;
            int tlGreen = 0;
            int tlRed = 0;

            int tmBlue = 0;
            int tmGreen = 0;
            int tmRed = 0;

            int trBlue = 0;
            int trGreen = 0;
            int trRed = 0;

            int mlBlue = 0;
            int mlGreen = 0;
            int mlRed = 0;

            int mmBlue = 0;
            int mmGreen = 0;
            int mmRed = 0;

            int mrBlue = 0;
            int mrGreen = 0;
            int mrRed = 0;

            int blBlue = 0;
            int blGreen = 0;
            int blRed = 0;

            int bmBlue = 0;
            int bmGreen = 0;
            int bmRed = 0;

            int brBlue = 0;
            int brGreen = 0;
            int brRed = 0;

            int pixel_count = 0;

            // Top left pixel
            if (i - 1 < 0 || j - 1 < 0)
            {
                ;
            }
            else
            {
                tlBlue = image[i - 1][j - 1].rgbtBlue;
                tlGreen = image[i - 1][j - 1].rgbtGreen;
                tlRed = image[i - 1][j - 1].rgbtRed;
                pixel_count++;
            }

            // Top middle pixel
            if (i - 1 < 0)
            {
                ;
            }
            else
            {
                tmBlue = image[i - 1][j].rgbtBlue;
                tmGreen = image[i - 1][j].rgbtGreen;
                tmRed = image[i - 1][j].rgbtRed;
                pixel_count++;
            }

            // Top right pixel
            if (i - 1 < 0 || j + 1 == width)
            {
                ;
            }
            else
            {
                trBlue = image[i - 1][j + 1].rgbtBlue;
                trGreen = image[i - 1][j + 1].rgbtGreen;
                trRed = image[i - 1][j + 1].rgbtRed;
                pixel_count++;
            }

            // Middle left pixel
            if (j - 1 < 0)
            {
                ;
            }
            else
            {
                mlBlue = image[i][j - 1].rgbtBlue;
                mlGreen = image[i][j - 1].rgbtGreen;
                mlRed = image[i][j - 1].rgbtRed;
                pixel_count++;
            }

            // Middle pixel (starting point)
            mmBlue = image[i][j].rgbtBlue;
            mmGreen = image[i][j].rgbtGreen;
            mmRed = image[i][j].rgbtRed;
            pixel_count++;

            // Middle right pixel
            if (j + 1 == width)
            {
                ;
            }
            else
            {
                mrBlue = image[i][j + 1].rgbtBlue;
                mrGreen = image[i][j + 1].rgbtGreen;
                mrRed = image[i][j + 1].rgbtRed;
                pixel_count++;
            }

            // Bottom left pixel
            if (i + 1 == height || j - 1 < 0)
            {
                ;
            }
            else
            {
                blBlue = image[i + 1][j - 1].rgbtBlue;
                blGreen = image[i + 1][j - 1].rgbtGreen;
                blRed = image[i + 1][j - 1].rgbtRed;
                pixel_count++;
            }

            // Bottom middle pixel
            if (i + 1 == height)
            {
                ;
            }
            else
            {
                bmBlue = image[i + 1][j].rgbtBlue;
                bmGreen = image[i + 1][j].rgbtGreen;
                bmRed = image[i + 1][j].rgbtRed;
                pixel_count++;
            }

            // Bottom right pixel
            if (i + 1 == height || j + 1 == width)
            {
                ;
            }
            else
            {
                brBlue = image[i + 1][j + 1].rgbtBlue;
                brGreen = image[i + 1][j + 1].rgbtGreen;
                brRed = image[i + 1][j + 1].rgbtRed;
                pixel_count++;
            }

            temp[i][j].rgbtBlue = round((double)(tlBlue + tmBlue + trBlue + mlBlue + mmBlue + mrBlue + blBlue + bmBlue + brBlue) / pixel_count);
            temp[i][j].rgbtGreen = round((double)(tlGreen + tmGreen + trGreen + mlGreen + mmGreen + mrGreen + blGreen + bmGreen + brGreen) / pixel_count);
            temp[i][j].rgbtRed = round((double)(tlRed + tmRed + trRed + mlRed + mmRed + mrRed + blRed + bmRed + brRed) / pixel_count);
        }
    }

    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            image[i][j].rgbtBlue = temp[i][j].rgbtBlue;
            image[i][j].rgbtGreen = temp[i][j].rgbtGreen;
            image[i][j].rgbtRed = temp[i][j].rgbtRed;
        }
    }
    return;
}

// Detect edges
void edges(int height, int width, RGBTRIPLE image[height][width])
{

    RGBTRIPLE temp[height][width];

    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            int tlBlue = 0;
            int tlGreen = 0;
            int tlRed = 0;

            int tmBlue = 0;
            int tmGreen = 0;
            int tmRed = 0;

            int trBlue = 0;
            int trGreen = 0;
            int trRed = 0;

            int mlBlue = 0;
            int mlGreen = 0;
            int mlRed = 0;

            int mmBlue = 0;
            int mmGreen = 0;
            int mmRed = 0;

            int mrBlue = 0;
            int mrGreen = 0;
            int mrRed = 0;

            int blBlue = 0;
            int blGreen = 0;
            int blRed = 0;

            int bmBlue = 0;
            int bmGreen = 0;
            int bmRed = 0;

            int brBlue = 0;
            int brGreen = 0;
            int brRed = 0;

            int pixel_count = 0;

            // Top left pixel
            if (i - 1 < 0 || j - 1 < 0)
            {
                ;
            }
            else
            {
                tlBlue = image[i - 1][j - 1].rgbtBlue;
                tlGreen = image[i - 1][j - 1].rgbtGreen;
                tlRed = image[i - 1][j - 1].rgbtRed;
            }

            // Top middle pixel
            if (i - 1 < 0)
            {
                ;
            }
            else
            {
                tmBlue = image[i - 1][j].rgbtBlue;
                tmGreen = image[i - 1][j].rgbtGreen;
                tmRed = image[i - 1][j].rgbtRed;
            }

            // Top right pixel
            if (i - 1 < 0 || j + 1 == width)
            {
                ;
            }
            else
            {
                trBlue = image[i - 1][j + 1].rgbtBlue;
                trGreen = image[i - 1][j + 1].rgbtGreen;
                trRed = image[i - 1][j + 1].rgbtRed;
            }

            // Middle left pixel
            if (j - 1 < 0)
            {
                ;
            }
            else
            {
                mlBlue = image[i][j - 1].rgbtBlue;
                mlGreen = image[i][j - 1].rgbtGreen;
                mlRed = image[i][j - 1].rgbtRed;
            }

            // Middle pixel (starting point)
            mmBlue = image[i][j].rgbtBlue;
            mmGreen = image[i][j].rgbtGreen;
            mmRed = image[i][j].rgbtRed;

            // Middle right pixel
            if (j + 1 == width)
            {
                ;
            }
            else
            {
                mrBlue = image[i][j + 1].rgbtBlue;
                mrGreen = image[i][j + 1].rgbtGreen;
                mrRed = image[i][j + 1].rgbtRed;
            }

            // Bottom left pixel
            if (i + 1 == height || j - 1 < 0)
            {
                ;
            }
            else
            {
                blBlue = image[i + 1][j - 1].rgbtBlue;
                blGreen = image[i + 1][j - 1].rgbtGreen;
                blRed = image[i + 1][j - 1].rgbtRed;
            }

            // Bottom middle pixel
            if (i + 1 == height)
            {
                ;
            }
            else
            {
                bmBlue = image[i + 1][j].rgbtBlue;
                bmGreen = image[i + 1][j].rgbtGreen;
                bmRed = image[i + 1][j].rgbtRed;
            }

            // Bottom right pixel
            if (i + 1 == height || j + 1 == width)
            {
                ;
            }
            else
            {
                brBlue = image[i + 1][j + 1].rgbtBlue;
                brGreen = image[i + 1][j + 1].rgbtGreen;
                brRed = image[i + 1][j + 1].rgbtRed;
            }

            int Gx_blue = (double)(tlBlue * -1 + tmBlue * 0 + trBlue * 1 + mlBlue * -2 + mmBlue * 0 + mrBlue * 2 + blBlue * -1 + bmBlue * 0 + brBlue * 1);
            int Gx_green = (double)(tlGreen * -1 + tmGreen * 0 + trGreen * 1 + mlGreen * -2 + mmGreen * 0 + mrGreen * 2 + blGreen * -1 + bmGreen * 0 + brGreen * 1);
            int Gx_red = (double)(tlRed * -1 + tmRed * 0 + trRed * 1 + mlRed * -2 + mmRed * 0 + mrRed * 2 + blRed * -1 + bmRed * 0 + brRed * 1);

            int Gy_blue = (double)(tlBlue * -1 + tmBlue * -2 + trBlue * -1 + mlBlue * 0 + mmBlue * 0 + mrBlue * 0 + blBlue * 1 + bmBlue * 2 + brBlue * 1);
            int Gy_green = (double)(tlGreen * -1 + tmGreen * -2 + trGreen * -1 + mlGreen * 0 + mmGreen * 0 + mrGreen * 0 + blGreen * 1 + bmGreen * 2 + brGreen * 1);
            int Gy_red = (double)(tlRed * -1 + tmRed * -2 + trRed * -1 + mlRed * 0 + mmRed * 0 + mrRed * 0 + blRed * 1 + bmRed * 2 + brRed * 1);

            int Sobel_blue = round(sqrt(pow(Gx_blue, 2) + pow(Gy_blue, 2)));
            int Sobel_green = round(sqrt(pow(Gx_green, 2) + pow(Gy_green, 2)));
            int Sobel_red = round(sqrt(pow(Gx_red, 2) + pow(Gy_red, 2)));

            if (Sobel_blue > 255)
            {
                temp[i][j].rgbtBlue = 255;
            }
            else
            {
                temp[i][j].rgbtBlue = Sobel_blue;
            }
            if (Sobel_green > 255)
            {
                temp[i][j].rgbtGreen = 255;
            }
            else
            {
                temp[i][j].rgbtGreen = Sobel_green;
            }
            if (Sobel_red > 255)
            {
                temp[i][j].rgbtRed = 255;
            }
            else
            {
                temp[i][j].rgbtRed = Sobel_red;
            }
        }
    }

    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            image[i][j].rgbtBlue = temp[i][j].rgbtBlue;
            image[i][j].rgbtGreen = temp[i][j].rgbtGreen;
            image[i][j].rgbtRed = temp[i][j].rgbtRed;
        }
    }
    return;
}


