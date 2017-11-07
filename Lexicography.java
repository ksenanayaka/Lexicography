import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


	static boolean Lexicography(char[] S, int x, int y, int n)
	{
		for (int i=0;i<n;i++)
		{
			if (S[x] < S[y])
				return false;
			else if (S[x] > S[y])
				return true;
			x = (x+1)%n;
			y = (y+1)%n;
		}
		return true;
	}

	// Function to find starting index
	// of lexicographically smallest sequence
	static int smallestSequence(char[] S, int n)
	{
		int index = 0;
		for (int i=1; i<n; i++)
	
			// if new sequence is smaller
			if (compareSeq(S, index, i, n))
	
				// change index of current min
				index = i;
	
		return index;
	}
	
	// Function to print lexicographically
	// smallest sequence
	static int minRotate(String str)
	{
		int len = str.length();
		char[] S=str.toCharArray();
		int starting_index = smallestSequence(S, len);

		return (smallestSequence(S, len));
	}

	public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;

        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }

        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        String inscription;

        try {
            inscription = in.nextLine();
        } catch (Exception e) {
            inscription = null;
        }

        res = minRotate(inscription);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}