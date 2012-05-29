import java.io.*;
import java.util.*;

public class hourglass {
	public static void drawln (int indent, int base){
		if (base > 1){
			printsp(indent);//draw indent
			printstar (base);//draw dots
			drawln(indent + 1, base - 2);
			printsp(indent);
			printstar (base);
		}
		else if (base == 1){
			printsp(indent);
			printstar (base);
		}
	}

	public static void printsp (int space){
		if (space > 0){
			System.out.print(" ");
			printsp(space -1);
		}
	}

	public static void printstar (int star){
		if (star > 0){
			System.out.print("*");
			printstar(star - 1);
		}
		else { 
			System.out.print ("\n");
		}
	}

	public static void main (String[] args){
		int base = 0;
		Scanner in = new Scanner(System.in);
		while ((base % 2 == 0) && (base < 0)){
			System.out.println ("Enter an odd number: ");
			base = in.nextInt();
		}
		int indent = 0;
		drawln(indent, base);
		System.out.println ("The End!");
	}
}
