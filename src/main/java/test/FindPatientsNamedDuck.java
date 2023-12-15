package test;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;
// import java.io.*;

public class FindPatientsNamedDuck {

	public static void main(String[] args) {

		// We're connecting to a R4 compliant server in this example

		FhirContext ctx = FhirContext.forR4();
		String serverBase = "https://hapi.fhir.org/baseR4";

		IGenericClient client = ctx.newRestfulGenericClient(serverBase);

		// Perform a search
		Bundle results = client.search()
				.forResource(Patient.class)
				.where(Patient.FAMILY.matches().value("duck"))
				.returnBundle(Bundle.class)
				.execute();

		System.out.println("Found " + results.getEntry().size() + " patients named 'duck'");
	}
}