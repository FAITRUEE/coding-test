#include <stdio.h>
#include <stdlib.h> 

#define SIZE 10000

void test_main(void);

static int stack[10][SIZE];

static int sp[10];

static int queue[SIZE];

static int qs;

static int hold;

static long long SCORE = 0;

void my_push(int s)
{
    SCORE++;
    stack[s][sp[s]++] = hold;
}

int my_pop(int s)
{
    SCORE++;
    return hold = stack[s][--sp[s]];
}

void enqueue(void)
{
    queue[qs++] = hold;
    hold = -1;
}

static void build_data(void)
{
    for (int c = 0; c < SIZE; c++)
    {
        stack[0][c] = rand() % 1024;
    }
    sp[0] = SIZE;
    for (int c = 1; c < 10; c++) sp[c] = 0;
    qs = 0;
}

int main(void)
{
    SCORE = 0;
    for (int c = 0; c < 10; c++)
    {
        build_data();
        test_main();
    }
    printf("SCORE = %lld\n", SCORE);

    int ok = 1;
    for (int i = 0; i < SIZE - 1; i++)
    {
        if (queue[i] > queue[i + 1])
        {
            ok = 0;
            printf("ERROR: queue[%d]=%d > queue[%d]=%d\n", i, queue[i], i + 1, queue[i + 1]);
            break;
        }
    }
    if (ok)
        printf("SORT OK!\n");

    printf("queue: ");
    for (int i = 0; i < SIZE; i++)
        printf("%d ", queue[i]);
    printf("\n");
}
