import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class tictactoe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

        public static void main(String[] args) {

        char [][] board = {{' ','|',' ','|',' '}, 
            {'-','+','-','+','-'}, 
            {' ','|',' ','|',' '}, 
            {'-','+','-','+','-'}, 
            {' ','|',' ','|',' '}};

        

        printBoard(board);

        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Masukkan angka (1-9): ");
            int playerPos = scan.nextInt();
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)){
                System.out.println("Posisition taken! Masukkan posisi yang benar");
                playerPos = scan.nextInt();
            }

            letakPiece(board, playerPos, "player");

            String hasil = cekPemenang();
            if(hasil.length() > 0){
                System.out.println(hasil);
                break;
            }

            Random ran = new Random();
            int cpuPos = ran.nextInt(9) + 1;
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
                System.out.println("Posisition taken! Masukkan posisi yang benar");
                cpuPos = ran.nextInt(9)+1;
            }
            letakPiece(board, cpuPos, "cpu");

            printBoard(board);

            hasil = cekPemenang();
            if(hasil.length() > 0){
                System.out.println(hasil);
                break;
            }
        }

    }
        public static void printBoard(char[][] board){
            for(char[] row : board){
                for(char c : row){
                    System.out.print(c);
                }
                System.out.println();
            }
    }
    public static void letakPiece(char[][] board, int pos, String user){

        char symbol = ' ';
        if(user.equals("player")){
            symbol = 'x';
            playerPositions.add(pos);
        }else if(user.equals("cpu")){
            symbol = 'o';
            cpuPositions.add(pos);
        }
        
        

        switch(pos){
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
                break;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;
                break;
            default:
                break;
            
             }
    
        }
        public static String cekPemenang(){

            
            List<Integer> topRow = Arrays.asList(1, 2, 3);
            List<Integer> midRow = Arrays.asList(4, 5, 6);
            List<Integer> botRow = Arrays.asList(7, 8, 9);
            List<Integer> leftCol = Arrays.asList(1, 4, 7);
            List<Integer> midCol = Arrays.asList(2, 5, 8);
            List<Integer> rightCol = Arrays.asList(3, 6, 9);
            List<Integer> cross1 = Arrays.asList(1, 5, 9);
            List<Integer> cross2 = Arrays.asList(7, 5, 3);
            List<List<Integer>> winning = new ArrayList<List<Integer>>();


            winning.add(topRow);
            winning.add(midRow);
            winning.add(botRow);
            winning.add(leftCol);
            winning.add(midCol);
            winning.add(rightCol);
            winning.add(cross1);
            winning.add(cross2);

            for(List l : winning){
                if(playerPositions.containsAll(l)){
                    return "Congratulations you won!";
                }else if(cpuPositions.containsAll(l)){
                    return "CPU wins!";
                }else if(playerPositions.size() + cpuPositions.size()== 9){
                    return "TIE!";
                }
            }
        


            return "";
        }
    
}

        
    
    
            
        

    

