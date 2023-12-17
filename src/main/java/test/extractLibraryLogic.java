package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.hl7.fhir.r4.model.Attachment;
import org.hl7.fhir.r4.model.Library;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;

public class extractLibraryLogic {

	public static void main(String[] args) throws IOException {
		FhirContext ctx = FhirContext.forR4();
		IGenericClient fhirClient = ctx.newRestfulGenericClient("http://localhost:8080/fhir");
		// Step 1: Retrieve the FHIR Library resource
		Library library = fhirClient.read()
				.resource(Library.class)
				.withId("ColorectalCancerScreeningsFHIR")
				// .withId("MATGlobalCommonFunctionsFHIR4")
				// .withId("CumulativeMedicationDurationFHIR4")
				// .withId("HospiceFHIR4")
				// .withId("FHIRHelpers")
				// .withId("PalliativeCareFHIR")
				// .withId("SupplementalDataElementsFHIR4")
				// .withId("AdvancedIllnessandFrailtyExclusionECQMFHIR4")
				// .withId("AdultOutpatientEncountersFHIR4")
				.execute();
		// Step 2: Access the Content Element
		List<Attachment> attachments = library.getContent();
		if (!attachments.isEmpty()) {
			Attachment firstAttachment = attachments.get(0);
			byte[] base64BinaryData = firstAttachment.getData(); // Get byte array directly
			Path outPath = Path.of("./assets/decodedCql.cql");
			// it appears the Files.write implicitly converts base64Binary bytes
			Files.write(outPath, base64BinaryData);
			System.out.println("Success");
		} else {
			System.out.println("No attachments found in the Library content.");
		}
	}
}