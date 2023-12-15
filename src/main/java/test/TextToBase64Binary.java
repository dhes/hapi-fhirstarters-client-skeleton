package test;

import java.util.Base64;

// import org.hl7.fhir.r4.model.Base64BinaryType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextToBase64Binary {
	public static void main(String[] args) throws IOException {
		String textValue = "Hello world";

		String encodedString = Base64.getEncoder().encodeToString(textValue.getBytes());

		// Print the result
		System.out.println("Text: " + textValue);
		System.out.println("Base64Binary: " + encodedString);

		// Path outPath = Path.of("./assets/base64TextOut.txt");
		// Files.write(outPath, base64BinaryValue.getBytes());
	}

	// private static Base64BinaryType textToBase64Binary(String textValue) {
	// // Encode text to base64
	// byte[] encodedBytes =
	// Base64.getEncoder().encode(textValue.getBytes(StandardCharsets.UTF_8));

	// // Create a Base64BinaryType instance
	// return new Base64BinaryType(encodedBytes);
}
