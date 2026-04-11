#include <stdio.h>

void get_school_position(int school_index, int* posX, int* posY);
void get_student_position(int student_index, int* posX, int* posY);
void set_student_school(int student_index, int school_index);

static double my_sqrt(double x) {
    if (x == 0) return 0;

    double left = 0;
    double right = x;
    double mid = 0;

    for (int i = 0; i < 100; i++) {
        mid = (left + right) / 2;

        if (mid * mid > x) {
            right = mid;
        }
        else {
            left = mid;
        }
    }

    return mid;
}

void run_contest(void)
{
    extern int printf(const char*, ...);

    void get_school_position(int, int*, int*);
    void get_student_position(int, int*, int*);
    void set_student_school(int, int);

    static int run = 1;
    static double totalScore = 0;

    int sx[3], sy[3];
    static int px[10000], py[10000];
    static int dist2[10000][3];
    static int assigned[10000];
    static int count[3];

    double totalDist;
    int penalty;
    double score;
    int i, j, dx, dy, best, bestD;
    int over, gain, gap, minGain, bestStudent, changed;

    for (j = 0; j < 3; j++)
        get_school_position(j, &sx[j], &sy[j]);

    for (i = 0; i < 10000; i++)
        get_student_position(i, &px[i], &py[i]);

    for (j = 0; j < 3; j++)
        count[j] = 0;

    for (i = 0; i < 10000; i++)
    {
        dx = px[i] - sx[0];
        dy = py[i] - sy[0];
        dist2[i][0] = dx * dx + dy * dy;
        bestD = dist2[i][0];
        best = 0;

        for (j = 1; j < 3; j++)
        {
            dx = px[i] - sx[j];
            dy = py[i] - sy[j];
            dist2[i][j] = dx * dx + dy * dy;

            if (dist2[i][j] < bestD)
            {
                bestD = dist2[i][j];
                best = j;
            }
        }

        assigned[i] = best;
        count[best]++;
    }

    do {
        changed = 0;

        for (over = 0; over < 3; over++)
        {
            if (count[over] <= 3500) continue;

            gain = -1;
            for (j = 0; j < 3; j++)
            {
                if (j == over) continue;
                if (count[j] < 3500)
                {
                    if (gain == -1 || count[j] < count[gain])
                        gain = j;
                }
            }
            if (gain == -1) break;

            minGain = 0x7fffffff;
            bestStudent = -1;

            for (i = 0; i < 10000; i++)
            {
                if (assigned[i] != over) continue;
                gap = dist2[i][gain] - dist2[i][over];
                if (gap < minGain)
                {
                    minGain = gap;
                    bestStudent = i;
                }
            }

            count[over]--;
            count[gain]++;
            assigned[bestStudent] = gain;
            changed = 1;
        }

    } while (changed);

    for (i = 0; i < 10000; i++)
        set_student_school(i, assigned[i]);

    totalDist = 0;
    for (i = 0; i < 10000; i++)
        totalDist += my_sqrt((double)dist2[i][assigned[i]]);

    penalty = 0;
    for (j = 0; j < 3; j++)
    {
        if (count[j] > 3500)
            penalty += (count[j] - 3500) * 10000;
    }

    score = totalDist + penalty;
    totalScore += score;

    printf("Run %d - Score: %.2f  (school: %d %d %d)\n",
        run, score, count[0], count[1], count[2]);

    if (run == 10)
    {
        printf("Total Score: %.0f\n", totalScore);
        printf("Result Distance: %.0f\n", totalScore / 100000.0);
    }

    run++;
}
