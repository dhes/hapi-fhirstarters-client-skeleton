package test;

// import org.hl7.fhir.r4.model.Base64BinaryType;
import java.util.Base64;

import org.hl7.fhir.r4.model.Base64BinaryType;

import java.nio.charset.StandardCharsets;

public class TextToBase64Binary {
	public static void main(String[] args) {
		String textValue = "Hello world";

		// Convert text to base64Binary
		Base64BinaryType base64BinaryType = textToBase64Binary(textValue);

		// Access the base64Binary value
		String base64BinaryValue = base64BinaryType.getValueAsString();

		// Print the result
		System.out.println("Text: " + textValue);
		System.out.println("Base64Binary: " + base64BinaryValue);
	}

	private static Base64BinaryType textToBase64Binary(String textValue) {
		// Encode text to base64
		byte[] encodedBytes = Base64.getEncoder().encode(textValue.getBytes(StandardCharsets.UTF_8));

		// Create a Base64BinaryType instance
		return new Base64BinaryType(encodedBytes);
	}
}
