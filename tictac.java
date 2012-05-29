import java.io.*;
import java.util.*;

public class tictac {
	static int squares = 0;
	static boolean game_over = false;

	public static void check_3 (int player, char[][] game){
		int i = 0;
		while ((i < 3) && (!game_over)){
			//check verticals
			if (((game[i][0] == game[i][1]) && (game[i][1] == game[i][2]))
				&& ((game[i][0] == 'X') || (game[i][0] == 'O'))){
				System.out.println("You've won Player " + player + "!");
//				System.out.println("winning column is " + i);
				game_over = true;
			}
			//check horizontals
			if (((game[0][i] == game[1][i]) && (game[1][i] == game[2][i]))
				&& ((game[0][i] == 'X') || (game[0][i] == 'O'))){
				System.out.println("You've won Player " + player + "!");
//				System.out.println("winning row is " + i);
				game_over = true;
			}
			i++;
		}
		//checking diagonals
		int j;
		for (j = 0; j < 3; j++){ 
			if (((player == 1) && (game[j][j] != 'X')) ||
				((player == 2) && (game[j][j] != 'O'))){
				break;
			}
		}
		int k;
		for (k = 0; k < 3; k++){
			if (((player == 1) && (game[k][3-k-1] != 'X')) ||
			    ((player == 2) && (game[k][3-k-1] != 'O'))){
				break;
			}
		}
		if ((j == 3) || (k == 3)){ //you got 3 in a row diagonally
			System.out.println("You've won Player " + player + "!");
			game_over = true;
		}
	}

	public static void turn (char[][] game, int player){
		int x, y;
		//read in x & y coordinates
		boolean valid_coord = false;
		while (!valid_coord){
			Scanner in = new Scanner(System.in);
			System.out.println("Player " + player);
			System.out.println("Please enter your x coordinate: ");
			x = in.nextInt();
			System.out.println("Please enter your y coordinate: ");
			y = in.nextInt();

			//check for valid coordinates
			if ((x > 2) || (x < 0)|| (y > 2) || (y < 0)) {
				valid_coord = false;
				System.out.println("bad coordinates. try again");
			}
			else { //you have valid coordinates & now check the grid
				if ((game[x][y] == 'X') || (game[x][y] == 'O')){
					valid_coord = false;
					System.out.println("the square is already filled! try again");
				}
				else{
					if (player == 1) {
						game[x][y] = 'X';
						squares++;
					}
					else { //it's player 2 duh
						game[x][y] = 'O';
						squares++;
					}
					if (squares >= 5) {
						check_3(player, game);
					}
					valid_coord = true;
				}
			}
		}
	}


	public static void print_grid (char[][] game){
		for (int y = 2; y >= 0; y--){
			System.out.print("  ");
			for (int x = 0; x < 2; x++){
				System.out.print(game[x][y] + "  |  ");
			}
			System.out.print(game[2][y] + "\n");
			if (y != 0){
				System.out.println("---------------");
			}
		}
	}

	public static void main (String[] args){
		char [][] grid = new char [3][3];
		System.out.println("The bottom left is (0,0) and the top right is (2,2). Player 1 is X and goes first.");
		print_grid(grid);
		int player = 1;

		while ((squares < 9) && (!game_over)){
			turn(grid, player);
			print_grid(grid);

			//now switch players
			if (player == 1) { player = 2;}
			else { player = 1;}
		}
		if (squares >= 9){
			System.out.println("It's a draw! No one wins.");
		}
	}
}

