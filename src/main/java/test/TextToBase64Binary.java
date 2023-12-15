package test;

import java.util.Base64;

// import org.hl7.fhir.r4.model.Base64BinaryType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextToBase64Binary {
	public static void main(String[] args) throws IOException {
		// String textValue = "Hello world";
		Path inPath = Path.of("./assets/textIn.txt");
		String textValue = Files.readString(inPath);
		String encodedString = Base64.getEncoder().encodeToString(textValue.getBytes());
		// Print the result
		System.out.println("Text: " + textValue);
		System.out.println("Base64Binary: " + encodedString);
		Path outPath = Path.of("./assets/base64TextOut.txt");
		Files.write(outPath, encodedString.getBytes());
	}
}
