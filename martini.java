import java.io.*;
import java.util.*;

public class martini {
	public static void drawGlass (int indent, int base, int half){
		if (base < 1){
			return;
		}
		printSpace(indent);
		printStars(base);
		drawGlass(indent + 1, base - 2, half);
		stem(half, base - 1);
		if (base + 2 > (half * 2) + 1){
			printBase(base);
		}
	}

	public static void printSpace (int indent){
		if (indent > 0){
			System.out.print(" ");
			printSpace(indent - 1);
		}
	}

	public static void printStars (int base){
		if (base > 0){
			System.out.print("*");
			printStars(base - 1);
		}
		else{
			System.out.println();
		}
	}

	public static void printBase (int base){
	if (base > 0){
		System.out.print("‾");
		printBase(base - 1);
	}
	else{
		System.out.println();
	}
}

	public static void stem (int indent, int height){
		if (height > 0){
			printSpace(indent);
			System.out.println("|");
		}
	}

	public static void main (String[] args){
		int base = 0;
		Scanner in = new Scanner(System.in);
		while ((base % 2 == 0) || (base < 0)){
			System.out.println("Please enter a whole odd number: ");
			base = in.nextInt();
		}

		System.out.println();
		int indent = 0;
		int half = (base + 1)/2;
		drawGlass(indent, base + 2, half);
		System.out.println();
	}
}
