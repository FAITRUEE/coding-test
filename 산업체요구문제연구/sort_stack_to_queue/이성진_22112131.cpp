void my_push(int s);
int my_pop(int s);
void enqueue(void);

void test_main(void)
{
    int cnt[8];
    int total = 10000;

    for (int bit = 0; bit < 10; bit += 3)
    {
        cnt[0] = cnt[1] = cnt[2] = cnt[3] = cnt[4] = cnt[5] = cnt[6] = cnt[7] = 0;

        for (int i = 0; i < total; i++)
        {
            int val = my_pop(0);
            int x = (val >> bit) & 7;
            if (x == 0) { my_push(1); cnt[0]++; }
            else if (x == 1) { my_push(2); cnt[1]++; }
            else if (x == 2) { my_push(3); cnt[2]++; }
            else if (x == 3) { my_push(4); cnt[3]++; }
            else if (x == 4) { my_push(5); cnt[4]++; }
            else if (x == 5) { my_push(6); cnt[5]++; }
            else if (x == 6) { my_push(7); cnt[6]++; }
            else { my_push(8); cnt[7]++; }
        }

        for (int i = 0; i < cnt[7]; i++) { my_pop(8); my_push(0); }
        for (int i = 0; i < cnt[6]; i++) { my_pop(7); my_push(0); }
        for (int i = 0; i < cnt[5]; i++) { my_pop(6); my_push(0); }
        for (int i = 0; i < cnt[4]; i++) { my_pop(5); my_push(0); }
        for (int i = 0; i < cnt[3]; i++) { my_pop(4); my_push(0); }
        for (int i = 0; i < cnt[2]; i++) { my_pop(3); my_push(0); }
        for (int i = 0; i < cnt[1]; i++) { my_pop(2); my_push(0); }
        for (int i = 0; i < cnt[0]; i++) { my_pop(1); my_push(0); }
    }

    for (int i = 0; i < total; i++) { my_pop(0); enqueue(); }
}