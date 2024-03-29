//my tictactoe


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Integer> playerPositions=new ArrayList<>();
	static ArrayList<Integer> cpuPositions=new ArrayList<>();
	
	

	public static void main(String[] args) {

		char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' },
				               { '-', '+', '-', '+', '-' }, 
				               { ' ', '|', ' ', '|', ' ' },
				               { '-', '+', '-', '+', '-' }, 
				               { ' ', '|', ' ', '|', ' ' }

		};

		printBoard(gameBoard);
		Scanner scan = new Scanner(System.in);

		boolean gameover =true;
		while(gameover) {
		while(true) {
			
			System.out.println("Enter your position(1-9)");
			int playerPos = scan.nextInt();
			while(playerPositions.contains(playerPos)||cpuPositions.contains(playerPos)){
				System.out.println("Invalid move ! Enter again");
				playerPos = scan.nextInt();
			}
			
			
			
			
			placePiece(gameBoard,playerPos,"player");
			String result=checkWinner();
			 if(result.length()>0) {
				 System.out.println(result); 
				 break;
			 }
			
			
			Random rand = new Random();
			int cpuPos = rand.nextInt(9) +1;
			while(playerPositions.contains(cpuPos)||cpuPositions.contains(cpuPos)){
				
				cpuPos = rand.nextInt(9) +1;
			}
            placePiece(gameBoard,cpuPos,"cpu");
            
			printBoard(gameBoard);
			
			 result=checkWinner();
			 if(result.length()>0) {
				 System.out.println(result); 
				 break;
			 }
			

			 
			 
			 

		}
		
		 scan = new Scanner(System.in);
		 System.out.println("Do you want to continue playing?(Y/N)");
		 String yn=scan.nextLine().toLowerCase();
		System.out.println(yn);
		 switch(yn){
		 case "y":
			 emptyBoard(gameBoard);
			 
			 printBoard(gameBoard);
			 
			 playerPositions.clear();
			 cpuPositions.clear();
			 gameover=true;
			 
			 break;
			 
		 case "n":
			 gameover=false;
			 System.out.println("Thanks for playing ! :)");
			 break;
			 
		default:
			break;
			
			 
		 }
		 
		
		
		}



	}

	public static void printBoard(char[][] gameBoard) {

		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}

	}

	public static void placePiece(char[][] gameBoard, int pos, String user) {
		
		char symbol=' ';
		if(user.equals("player")) {
			symbol='X';
			playerPositions.add(pos);
		}else if(user.equals("cpu")) {
			symbol='O';
			cpuPositions.add(pos);
		}
		
		
		switch (pos) {

		case 1:
			gameBoard[0][0]= symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
		default:
			break;
		}
	}
	
	public static String checkWinner() {
		List<Integer> topRow =Arrays.asList(1,2,3);
		List<Integer> midRow =Arrays.asList(4,5,6);
		List<Integer>botRow =Arrays.asList(7,8,9);
		List<Integer>leftCol =Arrays.asList(1,4,7);
		List<Integer> midCol =Arrays.asList(2,5,8);
		List<Integer> rightCol =Arrays.asList(3,6,9);
		List <Integer>cross1 =Arrays.asList(1,5,9);
		List <Integer>cross2 =Arrays.asList(3,5,7);
		
		
		List<List<Integer>>winning = new ArrayList<>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List<Integer> l : winning) {
			
		
		if(playerPositions.containsAll(l)) {
			return "Congratulation You Won :) !!";
		}else if(cpuPositions.containsAll(l)){
			return "Sorry ! The CPU was too smart :( ";
		}else if(playerPositions.size()+cpuPositions.size()==9){
			return "Draw";
		}
		
		
		
		
	}
		return "";
	}
	
	public static void emptyBoard(char[][] gameBoard) {
		gameBoard[0][0]=' ';
		gameBoard[0][2]=' ';
		gameBoard[0][4]=' ';
		gameBoard[2][0]=' ';
		gameBoard[2][2]=' ';
		gameBoard[2][4]=' ';
		gameBoard[4][0]=' ';
		gameBoard[4][2]=' ';
		gameBoard[4][4]=' ';
		
	}

}
