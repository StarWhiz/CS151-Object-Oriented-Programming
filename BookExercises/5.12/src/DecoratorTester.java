/*
 *  Tai Dao
 *  006769100
 *  Borrowed a lot from the 5.13 solution
 * 
 */

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

class DecoratorTester
{
	static FileWriter fWriter;
	static FileReader fReader;
	static BufferedReader bReader;
	static EncryptingWriter eWriter;
	static DecryptingReader dWriter;

	
	public static void main(String[] args) throws IOException
	{
		File file = new File("textfile.txt");
		
		
		String plaintext = "Lettuce Test This Darn Pattern";
		char[] character = plaintext.toCharArray();

		fWriter = new FileWriter(file);
		eWriter = new EncryptingWriter(fWriter);
		
		
		eWriter.write(character, 0, character.length);
		eWriter.flush();
		fWriter.flush();
		
		
		
		fReader = new FileReader(file);
		dWriter = new DecryptingReader(fReader);
		bReader = new BufferedReader(dWriter.getReader());
		
		
		String text = bReader.readLine();
		char[] cbuf = text.toCharArray();
		dWriter.read(cbuf, 0, cbuf.length);

		
		fWriter.close();
		eWriter.close();
		dWriter.close();
		bReader.close();
   } 
}
