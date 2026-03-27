#include <stdio.h>
#include <stdlib.h>

int **crearMatriz(int n, int m) {
    int i;
    int **M = (int**)malloc(n * sizeof(int*));
    if (M == NULL) exit(1);

    for (i = 0; i < n; i++) {
        *(M + i) = (int*)malloc(m * sizeof(int));
        if (*(M + i) == NULL) exit(1);
    }
    return M;
}

void leerMatriz(int **M, int n, int m, const char *nombre) {
    int i, j;
    printf("\nDame los datos de la matriz %s\n", nombre);
    for (i = 0; i < n; i++) {
        for (j = 0; j < m; j++) {
            printf("%s[%d][%d]: ", nombre, i, j);
            scanf("%d", (*(M + i) + j));
        }
    }
}

void imprimirMatriz(int **M, int n, int m, const char *nombre, int mostrarDir) {
    int i, j;
    printf("\n%s:\n", nombre);
    for (i = 0; i < n; i++) {
        for (j = 0; j < m; j++) {
            printf("%6d", *(*(M + i) + j));
        }
        printf("\n");
    }

    if (mostrarDir) {
        printf("\nDirecciones de %s:\n", nombre);
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                printf("[%d][%d] -> %p\n", i, j, (void*)(*(M + i) + j));
            }
        }
    }
}

int **sumarMatrices(int **A, int **B, int n, int m) {
    int i, j;
    int **C = crearMatriz(n, m);

    for (i = 0; i < n; i++) {
        for (j = 0; j < m; j++) {
            *(*(C + i) + j) = *(*(A + i) + j) + *(*(B + i) + j);
        }
    }
    return C;
}

int **multiplicarMatrices(int **A, int n, int m, int **B, int p) {
    int i, j, k;
    int **C = crearMatriz(n, p);

    for (i = 0; i < n; i++) {
        for (j = 0; j < p; j++) {
            *(*(C + i) + j) = 0;
            for (k = 0; k < m; k++) {
                *(*(C + i) + j) += (*(*(A + i) + k)) * (*(*(B + k) + j));
            }
        }
    }
    return C;
}

void liberarMatriz(int **M, int n) {
    int i;
    for (i = 0; i < n; i++) {
        free(*(M + i));
    }
    free(M);
}

int main() {
    int nA, mA, nB, mB;
    int **A, **B, **S, **P;
    int op;

    printf("Dimensiones de A (filas cols): ");
    scanf("%d %d", &nA, &mA);

    printf("Dimensiones de B (filas cols): ");
    scanf("%d %d", &nB, &mB);

    A = crearMatriz(nA, mA);
    B = crearMatriz(nB, mB);

    leerMatriz(A, nA, mA, "A");
    leerMatriz(B, nB, mB, "B");

    printf("\n1) Suma A + B\n2) Multiplicacion A x B\nOpcion: ");
    scanf("%d", &op);

    if (op == 1) {
        if (nA != nB || mA != mB) {
            printf("\nNo se puede sumar: dimensiones diferentes.\n");
        } else {
            S = sumarMatrices(A, B, nA, mA);
            imprimirMatriz(S, nA, mA, "S = A + B", 1);
            liberarMatriz(S, nA);
        }
    } else if (op == 2) {
        if (mA != nB) {
            printf("\nNo se puede multiplicar: cols(A) != filas(B).\n");
        } else {
            P = multiplicarMatrices(A, nA, mA, B, mB);
            imprimirMatriz(P, nA, mB, "P = A x B", 1);
            liberarMatriz(P, nA);
        }
    } else {
        printf("\nOpcion invalida.\n");
    }

    liberarMatriz(A, nA);
    liberarMatriz(B, nB);

    return 0;
}