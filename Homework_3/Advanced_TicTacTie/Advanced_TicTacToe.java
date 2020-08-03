package Advanced_TicTacTie;


import java.util.Random;
import java.util.Scanner;

public class Advanced_TicTacToe {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final int WIN_RAW = 4;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static int fieldSizeY = 5;
    private static int fieldSizeX = 5;
    private static char[][] field;
    private static String dangerDirection;
    private static int dangerX = 3;
    private static int dangerY = 3;


    static int tempver;


    private static void initField() {
        //fieldSizeX = 3;
        //fieldSizeY = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++)
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        System.out.println();

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++)
                System.out.print(field[y][x] + "|");
            System.out.println();
        }

        for (int x = 0; x <= fieldSizeX * 2 + 1; x++)
            System.out.print("-");
        System.out.println();
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода X и Y (от 1 до "+ fieldSizeX + ") через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static void aiTurn() {
        int center_x = (fieldSizeX - 1) / 2;
        int center_y = (fieldSizeY - 1) / 2;
        boolean isAI_made_move = false;

        //counter_hor = 0;    // raw checker
        //counter_ver = 0;    // column checker
        //counter_diag1 = 0;  // diagonal / checker
        //counter_diag2 = 0;  // diagonal \ checker
        int x;
        int y;

        // check first move to center
        if (isEmptyCell(center_x, center_y)) {
            field[center_y][center_x] = DOT_AI;
            isAI_made_move = true;
        } else {
            // check if potential human move lead to win in 2 turns and block
            /*if (checkWin_common(DOT_HUMAN, (WIN_RAW - 1))) { //
                if(isValidCell(dangerX,dangerY)) field[dangerY][dangerX] = DOT_AI;
                //System.out.println(dangerX + " <-x -- y ->  " + dangerY);
                System.out.println("H in 2 turns");
            }else*/
            //check if potential AI move lead to win in 1 turns
            if (!isAI_made_move && (checkWin_common(DOT_AI, (WIN_RAW - 1)))) { // check if computer could win
                if (isValidCell(dangerX, dangerY)) field[dangerY][dangerX] = DOT_AI;
                //System.out.println("AI in can win");
                isAI_made_move = true;
            }else //if potential human move lead to win in 1 turn and block
            if (!isAI_made_move && checkWin_common(DOT_HUMAN, (WIN_RAW - 1))) {
                if (isValidCell(dangerX, dangerY)) {
                    field[dangerY][dangerX] = DOT_AI;
                    isAI_made_move = true;
                }
                //System.out.println(dangerX + " <-x -- y ->  " + dangerY);
                //System.out.println("H in 1 turns");

            } else
                // check if potential human move lead to win in 2 turn and block
                if (!isAI_made_move && checkWin_common(DOT_HUMAN, (WIN_RAW - 2))) {
                    if (isValidCell(dangerX, dangerY)) {
                        field[dangerY][dangerX] = DOT_AI;
                        isAI_made_move = true;
                    }
                    //System.out.println(dangerX + " <-x -- y ->  " + dangerY);
                    //System.out.println("H in 1 turns");

                } else
                    if(!isAI_made_move && dangerX<0){
                     do {
                        x = RANDOM.nextInt(fieldSizeX);
                        y = RANDOM.nextInt(fieldSizeY);
                     } while (!isEmptyCell(x, y));
                    field[y][x] = DOT_AI;
                    System.out.println("RANDOM");
                }

            }

    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) return false;
            }
        }
        return true;
    }
    private static boolean checkWin_common (char c, int wr){

        int temphor; int tempdiag1;
        int counter_hor = 0;    // raw checker
        int counter_ver = 0;    // column checker
        int counter_diag1 = 0;  // diagonal / checker
        int counter_diag2 = 0;  // diagonal \ checker
        int counterMAX = 0;
        dangerX = -1;
        boolean move_Assigned= false;

//---------------------------------check raws-------------------------
        for(int y = 0; y < fieldSizeY; y++) {
            counter_hor = 0;
            for (int x = 0; x < fieldSizeX; x++) {
                temphor = (wr == WIN_RAW) ? 0 : counter_hor;
                counter_hor = (field[y][x] == c) ? counter_hor+1 : temphor;
                counterMAX = counter_hor;

                if ((counter_hor) == wr) {
                    dangerDirection = "hor";
                    for(int i=1;i<WIN_RAW;i++) {
                        if (isValidCell(x - i, y) && (isEmptyCell(x - i, y))) {
                            dangerX = x - i;
                            dangerY = y;
                            move_Assigned = true;
                            //System.out.println(dangerX + " " + dangerY);
                        }

                    }
                        if(!move_Assigned && isValidCell(x+1,y) && isEmptyCell(x+1,y)){
                            dangerX=x+1;
                            dangerY=y;
                            move_Assigned = true;
                            //System.out.println(dangerX + " " + dangerY);
                        }

                    break;
                }
            }
            //System.out.println(counter_hor + " ");
            //System.out.println(dangerX + " " + dangerY);
            if ((counter_hor)==wr) break;
        }
//---------------------------------check columns------------------------
        for(int x = 0; x < fieldSizeX && !move_Assigned; x++) {   //columns
            counter_ver = 0;
            for (int y = 0; y < fieldSizeY; y++) {
                if (wr == WIN_RAW)
                    counter_ver = (field[y][x] == c) ? counter_ver+1 : 0;
                else{
                    counter_ver = (field[y][x] == c) ? counter_ver+1 : counter_ver;
                }

                //tempver = (wr == WIN_RAW) ? 0 : counter_ver;
                //counter_ver = (field[y][x] == c) ? counter_ver+1 : tempver;
                //System.out.print("c_ver =  " + counter_ver + "  ");
                if ((counter_ver) == wr) {
                    dangerDirection = "ver";
                    for(int i=1;i<WIN_RAW;i++){
                        if(isValidCell(x,y-i) && (isEmptyCell(x,y-i))) {
                        dangerX = x;
                        dangerY = y - i;
                        move_Assigned = true;
                        //System.out.println(dangerX + " " + dangerY);
                        }
                    }
                    if(isValidCell(x,y+1) && isEmptyCell(x,y+1)){
                        dangerX=x;
                        dangerY=y+1;
                        move_Assigned = true;
                        //System.out.println(dangerX + " " + dangerY);
                    }
                    break;
                }
            }

            if ((counter_ver)==wr) break;
        }

//------------------------------------check diagonal2 \ ---------------------------
        for (int diag2=(WIN_RAW - fieldSizeX);diag2 < (WIN_RAW + fieldSizeX) && !move_Assigned;diag2++) { // check \ diagonals
            counter_diag2 =0;
            for (int y = 0; y < fieldSizeY; y++) {
                for (int x =0; x < fieldSizeX; x++) {

                    if (y == x + diag2) {
                        if (wr == WIN_RAW)
                            counter_diag2 = (field[y][x] == c) ? (counter_diag2+1) : 0;
                        else {
                            counter_diag2 = (field[y][x] == c) ? (counter_diag2 + 1) : counter_diag2;
                        }
                    }
                    if(counter_diag2 == wr) {
                        dangerDirection = "diag2";
                        for (int i=0;i<WIN_RAW;i++){
                            if((isValidCell(x-i,y-i) && (isEmptyCell(x-i,y-i)))) {
                                dangerX = x - i;
                                dangerY = y - i;
                                move_Assigned = true;
                                //System.out.println(dangerX + " " + dangerY);
                            }
                        }
                            if(!move_Assigned && isValidCell(x+1,y+1) && isEmptyCell(x+1,y+1)){
                                dangerX=x+1;
                                dangerY=y+1;
                                move_Assigned = true;
                                //System.out.println(dangerX + " " + dangerY);
                            }

                        break;
                    }
                }
                if(counter_diag2 == wr) break;
            }
            if(counter_diag2 == wr) break;
        }

        //------------------------------------check diagonal1 / ---------------------------
        for (int diag1=(WIN_RAW-1);!move_Assigned && diag1 <= (((2*fieldSizeX)-WIN_RAW)-1); diag1++) { // check / diagonals
            counter_diag1 = 0;
            for (int y = 0; y < fieldSizeY; y++) {
                for (int x = 0; x < fieldSizeX; x++) {
                    if (x + y == diag1) {
                        if (wr == WIN_RAW)
                            counter_diag1 = (field[y][x] == c) ? (counter_diag1+1) : 0;
                        else {
                            counter_diag1 = (field[y][x] == c) ? (counter_diag1 + 1) : counter_diag1;
                        }
                    }

                    if(counter_diag1 == wr) {
                        dangerDirection = "diag1";
                        for (int i=0;i<WIN_RAW;i++){
                            if((isValidCell(x+i,y-i) && (isEmptyCell(x+i,y-i)))) {
                                dangerX = x + i;
                                dangerY = y - i;
                                move_Assigned = true;
                                //System.out.println(dangerX + " " + dangerY);
                            }
                        }
                        if(isValidCell(x-1,y+1) && isEmptyCell(x-1,y+1)){
                                dangerX=x-1;
                                dangerY=y+1;
                                move_Assigned = true;
                                //System.out.println(dangerX + " " + dangerY);
                        }

                        break;
                    }
                }
                if(counter_diag1 == wr) break;
            }
            if(counter_diag1 == wr) break;
        }

        //---------------------------------------------- END OF ALL CHECKINGS ----------------
        //System.out.println(dangerX +"  " + dangerY);
        //System.out.println(dangerDirection);
        //System.out.println("counters " + counter_hor + " " + counter_ver + " " + counter_diag1 + " " + counter_diag2);
        return (counter_hor==wr | counter_ver==wr | counter_diag1==wr | counter_diag2==wr);
    }

    /*private static boolean checkWin_fieldSize3 (char c){
        int counter_hor = 0;    // raw checker
        int counter_ver = 0;    // column checker
        int counter_diag1 = 0;  // diagonal \ checker
        int counter_diag2 = 0;  // diagonal / checker
        for(int y=0;y<fieldSizeY;y++){
            for(int x=0;x<fieldSizeX;x++){
                counter_hor = (field[x][y]== c) ? counter_hor+1 : 0;
                counter_ver = (field[y][x]== c) ? counter_ver+1 : 0;
                counter_diag1 = (field[y][x]== c && x==y) ? counter_diag1+1 : 0;
                counter_diag2 = (field[y][x]== c && ((x + y + 1) == fieldSizeY)) ? counter_diag2+1 : 0;
            }
        }
        return (counter_hor==WIN_RAW || counter_ver==WIN_RAW || counter_diag1==WIN_RAW || counter_diag2==WIN_RAW);
    }*/

    /*private static boolean checkWin(char c) {
        // hor

        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // ver
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // dia
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;

    }*/

    public static void main(String[] args) {

        String answer;
        do {initField();
            printField();
            while (true) {
                humanTurn();
                if (checkEndGame(DOT_HUMAN, "Human win!")) break;
                aiTurn();
                if (checkEndGame(DOT_AI, "Computer win!")) break;
            }
            System.out.println("Wanna play again? (y/n) >>> ");
            answer = SCANNER.next();
        } while (answer.equals("y"));
        SCANNER.close();
    }

    private static boolean checkEndGame(char dot, String winMessage) {
        printField();
        if (checkWin_common(dot, WIN_RAW)) {
            System.out.println(winMessage);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }
}

