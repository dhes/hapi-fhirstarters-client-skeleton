package test;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;

import org.hl7.fhir.instance.model.api.IIdType;
import org.hl7.fhir.r4.model.Patient;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PostNewPatientFromJsonFile {

	public static void main(String[] args) throws IOException {

		FhirContext ctx = FhirContext.forR4();
		IGenericClient client = ctx.newRestfulGenericClient("http://localhost:8080/fhir");

		Path filePath = Path.of("./assets/Patient-heslinga-dan.json");
		String fileContent = Files.readString(filePath);
		System.out.println(fileContent);

		IParser parser = ctx.newJsonParser();

		// Parse it
		Patient parsed = parser.parseResource(Patient.class, fileContent);
		System.out.println(parsed.getName().get(0).getFamily());

		MethodOutcome outcome = client.create()
				.resource(parsed)
				.prettyPrint()
				.encodedJson()
				.execute();
		IIdType id = outcome.getId();
		System.out.println("Got ID: " + id.getValue());
	}
}