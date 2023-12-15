package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class Base64BinaryToText {
	public static void main(String[] args) throws IOException {
		// Example base64Binary value
		// String base64BinaryValue = "SGVsbG8gd29ybGQ="; // "Hello world" in base64
		Path inPath = Path.of("./assets/base64TextIn.txt");
		// Path outPath = Path.of("./assets/textOut.txt");
		String inFileContent = Files.readString(inPath);
		byte[] decodedBytes = Base64.getDecoder().decode(inFileContent);
		String decodedString = new String(decodedBytes);
		// Print the result
		// System.out.println("Base64Binary: " + inFileContent);
		// System.out.println("Text: " + textValue);
		Path outPath = Path.of("./assets/textOut.txt");
		Files.write(outPath, decodedString.getBytes());
	}
}
