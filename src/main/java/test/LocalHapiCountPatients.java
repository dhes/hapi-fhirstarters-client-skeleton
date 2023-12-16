package test;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;

public class LocalHapiCountPatients {

	/**
	 * This is the Java main method, which gets executed
	 */
	public static void main(String[] args) {

		// Create a context
		FhirContext ctx = FhirContext.forR4();

		// Create a client
		IGenericClient client = ctx.newRestfulGenericClient("https://hapi.fhir.org/baseR4");
		// IGenericClient client =
		// ctx.newRestfulGenericClient("http://localhost:8080/fhir");

		// // Read a patient with the given ID
		// Patient patient =
		// client.read().resource(Patient.class).withId("example").execute();

		// // Print the output
		// String string =
		// ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(patient);
		// System.out.println(string);

		// Perform a search
		Bundle results = client.search()
				.forResource(Patient.class)
				// .where(Patient.FAMILY.matches().value("duck"))
				.returnBundle(Bundle.class)
				.execute();

		System.out.println("Found " + results.getEntry().size() + " patients");

	}

}