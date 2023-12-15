package test;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
// import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;

// import org.hl7.fhir.instance.model.api.IIdType;
// import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Bundle;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PostBundleFromJsonFile {

	public static void main(String[] args) throws IOException {

		FhirContext ctx = FhirContext.forR4();
		IGenericClient client = ctx.newRestfulGenericClient("http://localhost:8080/fhir");

		Path filePath = Path.of("./assets/Bundle-heslinga-dan-bundle.json");
		// Path filePath = Path.of("./assets/EXM130-7.3.000-bundle.json");
		String fileContent = Files.readString(filePath);
		// System.out.println(fileContent);
		System.out.println(filePath);

		IParser parser = ctx.newJsonParser();

		// Parse it
		Bundle parsed = parser.parseResource(Bundle.class, fileContent);
		Bundle resp = client.transaction().withBundle(parsed).execute();
		// IIdType id = outcome.getId();
		// System.out.println("Got ID: " + ?id.getValue());
		System.out.println(ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(resp));
	}
}