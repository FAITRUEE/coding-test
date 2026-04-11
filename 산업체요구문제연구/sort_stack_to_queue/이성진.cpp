void my_push(int s);
int my_pop(int s);
void enqueue(void);

void test_main(void)
{
    int cnt[5] = { 0, 0, 0, 0, 0 };

    for (int i = 0; i < 10000; i++)
    {
        int val = my_pop(0);

        if (val < 256)
        {
            my_push(1);
            cnt[1]++;
        }
        else if (val < 512)
        {
            my_push(2);
            cnt[2]++;
        }
        else if (val < 768)
        {
            my_push(3);
            cnt[3]++;
        }
        else
        {
            my_push(4);
            cnt[4]++;
        }
    }

    int sorted = 0;
    for (int b = 1; b <= 4; b++)
    {
        for (int i = 0; i < cnt[b]; i++)
        {
            int val = my_pop(b);
            my_push(9);
            int changed = 0;

            for (int j = 0; j < sorted; j++)
            {
                int top = my_pop(5);
                if (top <= val)
                {
                    my_push(5);
                    break;
                }
                my_push(6);
                changed++;
            }

            my_pop(9);
            my_push(5);

            for (int k = 0; k < changed; k++)
            {
                my_pop(6);
                my_push(5);
            }
            sorted++;
        }
    }

    for (int i = 0; i < 10000; i++)
    {
        my_pop(5);
        my_push(7);
    }

    for (int i = 0; i < 10000; i++)
    {
        my_pop(7);
        enqueue();
    }
}
