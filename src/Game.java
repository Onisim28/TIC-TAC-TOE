import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    static final char vertical_line = '|';
    static final char blank = ' ';
    static final char X = 'X', O = '0';
    static char[][] tablou = {{vertical_line, blank, vertical_line, blank, vertical_line, blank, vertical_line, blank, vertical_line,
            blank, vertical_line},
            {vertical_line, blank, vertical_line, blank, vertical_line, blank, vertical_line, blank, vertical_line,
                    blank, vertical_line},
            {vertical_line, blank, vertical_line, blank, vertical_line, blank, vertical_line, blank, vertical_line,
                    blank, vertical_line}};
    static Scanner citire = new Scanner(System.in);
    static int ce_casuta_alegi;
    static boolean terminare_joc = false;
    static int[] V = new int[20];
    static int count_to9 = 0;

    public static void initializare_vector_valori_nule() {
        for (int i = 0; i < 10; i++)
            V[i] = 0;
    }

    public static void draw_the_map() {

        for (int i = 0; i < 3; i++) {
            System.out.print("\n");
            for (int j = 0; j < 11; j++)
                System.out.print(tablou[i][j]);
        }
    }


    public static void X_or_0_Turn(char xsau0) {
        int i;
        System.out.println("\n" + xsau0 + " Aseaza!\nSelectati poztia unde doriti sa asezati:");
        while (true) {
            try {

                ce_casuta_alegi = citire.nextInt();
                for (i = 0; i < 10; i++) {
                    if (V[i] == ce_casuta_alegi) { //Daca si x si 0 vor pune tot pe pozitia 1, nu se va putea acest lucru
                        System.out.println("Trebuie sa alegi o casuta libera!");
                        break; //Va iesi din for pentru a da loc sintaxei de mai jos
                    }
                }
                if (V[i] == ce_casuta_alegi) //Daca si x si 0 vor pune tot pe pozitia 1, nu se va putea acest lucru
                    continue;             //Se va incepe din nou de la inceptul blocului de while

                if ((ce_casuta_alegi < 1) || (ce_casuta_alegi > 9)) {
                    System.out.println("Trebuie sa alegi un nr cuprins intre 1-9 (numar intreg)");
                    continue;
                }

                switch (ce_casuta_alegi) {
                    case 1: {
                        tablou[0][1] = xsau0;
                        V[0] = 1;
                    } //Memoram in vector valoarea introdusa de la tastatura
                    break;                        //Vreau ca sa nu poata fi inlocuita o casuta dupa a fost asezat x sau 0

                    case 2: {
                        tablou[0][5] = xsau0;
                        V[1] = 2;
                    }
                    break;

                    case 3: {
                        tablou[0][9] = xsau0;
                        V[2] = 3;
                    }
                    break;

                    case 4: {
                        tablou[1][1] = xsau0;
                        V[3] = 4;
                    }
                    break;

                    case 5: {
                        tablou[1][5] = xsau0;
                        V[4] = 5;
                    }
                    break;

                    case 6: {
                        tablou[1][9] = xsau0;
                        V[5] = 6;
                    }
                    break;

                    case 7: {
                        tablou[2][1] = xsau0;
                        V[6] = 7;
                    }
                    break;

                    case 8: {
                        tablou[2][5] = xsau0;
                        V[7] = 8;
                    }
                    break;

                    case 9: {
                        tablou[2][9] = xsau0;
                        V[8] = 9;
                    }
                    break;
                }
                count_to9++; //Daca atingem 9 casute inseamna ca e egalitate

                break;
            } catch (InputMismatchException e) {
                System.out.println("Trebuie sa alegi un numar intre 1-9(numere intregi)");
                citire.next();
            }

        }
    }

    public static void functionality(char xsau0) {
        //Trying to figure out all the possibilities of winning
        if ((tablou[0][1] == xsau0) && (tablou[0][5] == xsau0) && (tablou[0][9] == xsau0)) {
            System.out.println("\n" + xsau0 + " ESTE CASTIGATORUL!!!");
            terminare_joc = true;
        } else if ((tablou[1][1] == xsau0) && (tablou[1][5] == xsau0) && (tablou[1][9] == xsau0)) {
            System.out.println("\n" + xsau0 + " ESTE CASTIGATORUL!!!");
            terminare_joc = true;
        } else if ((tablou[2][1] == xsau0) && (tablou[2][5] == xsau0) && (tablou[2][9] == xsau0)) {
            System.out.println("\n" + xsau0 + " ESTE CASTIGATORUL!!!");
            terminare_joc = true;
        } else if ((tablou[0][1] == xsau0) && (tablou[1][1] == xsau0) && (tablou[2][1] == xsau0)) {
            System.out.println("\n" + xsau0 + " ESTE CASTIGATORUL!!!");
            terminare_joc = true;
        } else if ((tablou[0][5] == xsau0) && (tablou[1][5] == xsau0) && (tablou[2][5] == xsau0)) {
            System.out.println("\n" + xsau0 + " ESTE CASTIGATORUL!!!");
            terminare_joc = true;
        } else if ((tablou[0][9] == xsau0) && (tablou[1][9] == xsau0) && (tablou[2][9] == xsau0)) {
            System.out.println("\n" + xsau0 + " ESTE CASTIGATORUL!!!");
            terminare_joc = true;
        } else if ((tablou[0][1] == xsau0) && (tablou[1][5] == xsau0) && (tablou[2][9] == xsau0)) {
            System.out.println("\n" + xsau0 + " ESTE CASTIGATORUL!!!");
            terminare_joc = true;
        } else if ((tablou[0][9] == xsau0) && (tablou[1][5] == xsau0) && (tablou[2][1] == xsau0)) {
            System.out.println("\n" + xsau0 + " ESTE CASTIGATORUL!!!");
            terminare_joc = true;
        }
    }


    public static void main(String[] args) {
        char user1 = 'X', user2 = 'O';

        int schimbare_intre_x_si_0 = 0;
        while (true) {
            draw_the_map();//Pentru a ne spune cine va castiga sau daca va fi remiza
            functionality(user1); //testam daca am castigat cu x
            functionality(user2);//testam daca am castigat cu 0
            if (count_to9 == 9) {
                System.out.println("\nEGALITATE!!");
                break;
            }
            if (terminare_joc) //in caz ca se termina jocul, se iasa afara din bucla
                break;
            if (schimbare_intre_x_si_0 == 0) //Cand e tura lui X
            {
                X_or_0_Turn(user1);
                schimbare_intre_x_si_0 = 1;
            } else {  //Cand e tura lui y
                X_or_0_Turn(user2);
                schimbare_intre_x_si_0 = 0;
            }
        }

    }
}

/*
     |X||X||X|
     |X||X||X|
     |X||X||X|
 */
