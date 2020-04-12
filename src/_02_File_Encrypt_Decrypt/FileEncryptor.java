package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Type a message here");
		String k = JOptionPane.showInputDialog("Type a cipher key here");
		int key = Integer.parseInt(k);
		String encryptedMessage = encrypt(message, key);
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/test.txt");
			fw.write(message);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String encrypt(String m, int key) {
		String plainAlphabet = "abcdefghijklmnopqrstuvwxyz";
		String cipherAlphabet = plainAlphabet.substring(key) + plainAlphabet.substring(0, key);
		String plainText = m.toLowerCase();
		String cipherText = "";
		int index;
		
		for (int i = 0; i < plainText.length(); i++) {
			for (int j = 0; j < plainAlphabet.length(); j++) {
				if (plainText.substring(i, i+1).equals(plainAlphabet.substring(j, j+1))) {
					index = j;
					cipherText += cipherAlphabet.substring(index, index + 1);
				}
			}
			if (plainText.substring(i, i+1).equals(" ")) {
				cipherText += " ";
			}
		}
		
		return cipherText;
	}
}
