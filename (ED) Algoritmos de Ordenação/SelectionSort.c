#include <stdio.h>
#include <stdlib.h>
#define LEN 10

void selectionSort(int array[]) {
    // m: menor valor
    // a: auxiliar
    // o: esta ordenado? (boolean)
    
    int m, a, o;

    for (size_t i = 0; i < LEN; i++) {
        a = m = i;
        o = 1;

        for (size_t j = i + 1; j < LEN; j++){
            if (array[j] < array[m]) m = j;
            if (array[a] > array[j]) o = 0;
            a = j;
        }

        if(o) break;

        a = array[i];
        array[i] = array[m];
        array[m] = a;
    }
}

void fillArray(int array[]) {
    srand(time(NULL));

    for (size_t i = 0; i < LEN; i++)
        array[i] = rand() % 1000;
}

void showArray(int array[]) {
    for (size_t i = 0; i < LEN; i++) {
        if(array[i] < 100) printf("0");
        if(array[i] < 10) printf("0");

        printf("%d", array[i]);
        if(i < LEN - 1) printf(", ");
    }
}

void main(int argc, char const *argv[]) {
    system("cls");

    int values[LEN];

    fillArray(values);

    printf("Array antes de ser ordenado\n");
    showArray(values);

    selectionSort(values);

    printf("\n\nArray depois de ser ordenado\n");
    showArray(values);

    printf("\n");
}
