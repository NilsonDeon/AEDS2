import java.util.Scanner;

class Q07 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int row = 0;
        int col = 0;

        for (int i = 0; i < n; i++) {

            Matrix matrix[] = new Matrix[2];

            for (int j = 0; j < 2; j++) {

                row = sc.nextInt();
                col = sc.nextInt();
                Matrix aux = new Matrix(row, col);
                aux.ler(sc);
                matrix[j] = aux;

            }

            matrix[0].mostrarDiagonalPrincipal();
            matrix[0].mostrarDiagonalSecundaria();
            matrix[0].soma(matrix[1]).imprimir();
            matrix[0].multiplicacao(matrix[1]).imprimir();
        }

        sc.close();
    }
}

class Cell {
    public int elem;
    public Cell inf, sup, ant, prox;

    public Cell() {
        this(0);
    }

    public Cell(int elem) {
        this(elem, null, null, null, null);
    }

    public Cell(int elem, Cell inf, Cell sup, Cell ant, Cell prox) {
        this.elem = elem;
        this.inf = inf;
        this.sup = sup;
        this.ant = ant;
        this.prox = prox;
    }
}

class Matrix {
    private Cell inicio;
    private int row;
    private int col;

    public Matrix() {
        this(3, 3);
    }

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;

        inicio = new Cell();
        Cell aux = inicio;

        // primeira linha
        for (int i = 1; i < col; i++) {
            aux.prox = new Cell();
            aux.prox.ant = aux;
            aux = aux.prox;
        }

        // outras linhas
        aux = inicio;
        for (int l = 1; l < row; l++, aux = aux.inf) {
            Cell i = aux;
            i.inf = new Cell();
            i.inf.sup = i;
            Cell j = i.inf;
            for (int c = 1; c < col; c++, j = j.prox) {
                i = i.prox;
                i.inf = new Cell();
                i.inf.sup = i;
                i.inf.ant = j;
                j.prox = i.inf;
            }
        }
    }

    // prenchendo com a entrada do usuario
    public void ler(Scanner sc) {

        Cell aux = inicio;
        Cell column = inicio;

        for (int l = 0; l < row; l++) {

            for (int c = 0; c < col; c++) {
                aux.elem = sc.nextInt();
                aux = aux.prox;
            }

            column = column.inf;
            aux = column;
        }
    }

    void imprimir() {

        Cell aux = inicio;
        Cell column = inicio;

        Scanner sc = new Scanner(System.in);
        for (int l = 0; l < row; l++) {

            for (int c = 0; c < col; c++) {
                System.out.print(aux.elem + " ");
                aux = aux.prox;
            }

            System.out.println("");
            column = column.inf;
            aux = column;

        }

        sc.close();

    }

    void mostrarDiagonalPrincipal() {

        Cell aux = inicio;

        System.out.print(aux.elem + " ");

        for (int c = 0; c < col - 1; c++, aux = aux.prox.inf) {
            System.out.print(aux.prox.inf.elem + " ");
        }

        System.out.println();
    }

    void mostrarDiagonalSecundaria() {

        Cell aux = inicio;
        for (int c = 0; c < col - 1; c++) {
            aux = aux.prox;
        }

        System.out.print(aux.elem + " ");

        for (int c = 0; c < col - 1; c++, aux = aux.ant.inf) {
            System.out.print(aux.ant.inf.elem + " ");
        }

        System.out.println();
    }

    Matrix soma(Matrix MatrixDois) {

        Matrix resultado = new Matrix(row, col);
        Cell auxR = resultado.inicio;
        Cell auxM1 = this.inicio;
        Cell auxM2 = MatrixDois.inicio;
        Cell mat1 = this.inicio;
        Cell mat2 = MatrixDois.inicio;
        Cell matResult = resultado.inicio;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++){
                auxR.elem = auxM1.elem + auxM2.elem;
                auxR = auxR.prox;
                auxM1 = auxM1.prox;
                auxM2 = auxM2.prox;
            }

            mat1 = auxM1 = mat1.inf;
            mat2 = auxM2 = mat2.inf;
            matResult = auxR = matResult.inf;
        }

        return resultado;
    }

    Matrix multiplicacao(Matrix MatrixDois) {

        Matrix resultado = new Matrix(row, col);
        Cell auxR = resultado.inicio;
        Cell auxM1 = this.inicio;
        Cell auxM2 = MatrixDois.inicio;
        Cell mat1 = this.inicio;
        Cell mat2 = MatrixDois.inicio;
        Cell matResult = resultado.inicio;

        for (int lR = 0; lR < row; lR++) {

            for (int l1 = 0; l1 < row; l1++) {

                for (int c = 0; c < col; c++) {

                    // calculando valor
                    auxR.elem += auxM1.elem * auxM2.elem;

                    // avancar na linha
                    auxM1 = auxM1.prox;

                    // avancar na coluna
                    auxM2 = auxM2.inf;
                }

                // avancar na linha
                auxR = auxR.prox;

                // primeiro elemento
                auxM1 = mat1;
                
                // avancar coluna
                auxM2 = mat2.prox;

            }
            
            // avancar na linha
            matResult = matResult.inf;
            auxR = matResult;

            mat1 = mat1.inf;
            auxM1 = mat1;

            // retorna para coluna primeira coluna
            auxM2 = mat2;
        }

        return resultado;
    }
}
