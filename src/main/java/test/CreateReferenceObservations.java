package test;

import ca.uhn.fhir.context.FhirContext;
// import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.api.MethodOutcome;
// import ca.uhn.fhir.rest.api.SearchStyleEnum;
// import ca.uhn.fhir.rest.api.SummaryEnum;
import ca.uhn.fhir.rest.client.api.IGenericClient;
// import ca.uhn.fhir.rest.param.DateRangeParam;
// import ca.uhn.fhir.util.BundleUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

// import java.util.ArrayList;
// import java.util.List;

// import org.hl7.fhir.instance.model.api.IBaseBundle;
// import org.hl7.fhir.instance.model.api.IBaseResource;
// import org.hl7.fhir.instance.model.api.IIdType;
// import org.hl7.fhir.r4.model.Bundle;
// import org.hl7.fhir.r4.model.Enumerations;
// import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Observation;
// import org.hl7.fhir.r4.model.Observation;
// import org.hl7.fhir.r4.model.OperationOutcome;
// import org.hl7.fhir.r4.model.Enumerations;
// import org.hl7.fhir.r4.model.IdType;
// import org.hl7.fhir.r4.model.Observation;
// import org.hl7.fhir.r4.model.Reference;
// import org.hl7.fhir.r4.model.Bundle;
// import org.hl7.fhir.r4.model.Patient;
// import org.hl7.fhir.r4.model.Provenance;
// import org.hl7.fhir.r4.model.Organization;
// import java.io.*;
// import org.hl7.fhir.r4.model.Quantity;
// import org.hl7.fhir.r4.model.Quantity;

public class CreateReferenceObservations {

	public static void main(String[] args) throws FileNotFoundException {

		FhirContext ctx = FhirContext.forR4();

		// Create a new Observation resource
		Observation observation0 = new Observation();

		// Set the resource ID
		observation0.setId("colon-hyperplastic-polyp");

		// Set the profile
		// observation0.getMeta().addProfile("http://hl7.org/fhir/us/example/StructureDefinition/heslinga-dan-clinical-result");

		// Set the status
		// observation0.setStatus(Observation.ObservationStatus.FINAL);

		// Set the subject
		// observation0.setSubject(new Reference("Patient/heslinga-dan").setDisplay("Dan
		// Heslinga"));

		// Set the category
		CodeableConcept category = new CodeableConcept();
		category.addCoding()
				.setCode("LP7839-6")
				.setSystem("http://loinc.org")
				.setDisplay("Pathology");
		observation0.getCategory().add(category);

		// Set the code
		// observation0.setCode(new CodeableConcept()
		// .addCoding()
		// .setCode("34574-4")
		// .setSystem("http://loinc.org")
		// .setDisplay("Pathology report final diagnosis"));
		observation0.getCode()
				.addCoding()
				.setCode("34574-4")
				.setSystem("http://loinc.org")
				.setDisplay("Pathology report final diagnosis");

		// Set the valueCodeableConcept
		// observation0.setValue(new CodeableConcept()
		// .addCoding()
		// .setCode("89452002")
		// .setSystem("http://snomed.info/sct")
		// .setDisplay("Hyperplastic polyp of intestine (disorder)"));
		CodeableConcept valueCodeableConcept = new CodeableConcept();
		valueCodeableConcept.addCoding(new Coding()
				.setCode("89452002")
				.setSystem("http://snomed.info/sct")
				.setDisplay("Hyperplastic polyp of intestine (disorder)"));
		observation0.setValue(valueCodeableConcept);

		// Create a FHIR client instance
		IGenericClient client = ctx.newRestfulGenericClient("http://localhost:8080/fhir");

		// Create the observation on the server
		MethodOutcome response = client.create().resource(observation0).execute();

		// FhirContext ctx = FhirContext.forR4();
		// IGenericClient client =
		// ctx.newRestfulGenericClient("http://localhost:8080/fhir");

		// // Bard contributed this code
		// // Create a bundle containing resources with custom IDs
		// Bundle bundle = new Bundle();
		// bundle.setType(Bundle.BundleType.TRANSACTION);

		// CodeableConcept laboratoryCategory = new CodeableConcept();
		// laboratoryCategory.addCoding()
		// .setSystem("http://loinc.org")
		// .setCode("LP7839-6")
		// .setDisplay("Pathology");

		// CodeableConcept colonHyperplasticPolypPathology = new CodeableConcept();
		// laboratoryCategory.addCoding()
		// .setSystem("http://loinc.org")
		// .setCode("LP7839-6")
		// .setDisplay("Pathology");

		// // Create Observation resource 0 with custom ID
		// Observation observation0 = new Observation();
		// observation0.setId(new IdType("Observation", "colon-hyperplastic-polyp"));
		// observation0.getCategory().add(laboratoryCategory);
		// observation0
		// .getCode()
		// .addCoding()
		// .setSystem("http://snomed.info/sct")
		// .setCode("89452002")
		// .setDisplay("hyperplastic polyp of intestine (disorder)");

		// bundle.addEntry()
		// .setResource(observation0)
		// .getRequest()
		// .setUrl("/Observation")
		// .setMethod(Bundle.HTTPVerb.POST);

		// // Create Observation resource 1 with custom ID
		// Observation observation1 = new Observation();
		// observation1.setId(new IdType("Observation", "colon-tubular-adenoma"));

		// bundle.addEntry()
		// .setResource(observation1)
		// .getRequest()
		// .setUrl("/Observation")
		// .setMethod(Bundle.HTTPVerb.POST);

		// // Create Observation resource 2 with custom ID
		// Observation observation2 = new Observation();
		// observation2.setId(new IdType("Observation", "ccolon-mucosal-fold"));
		// bundle.addEntry()
		// .setResource(observation2)
		// .getRequest()
		// .setUrl("/Observation")
		// .setMethod(Bundle.HTTPVerb.POST);

		// // Create Observation resource 3 with custom ID
		// Observation observation3 = new Observation();
		// observation3.setId(new IdType("Observation",
		// "colon-sessile-serrated-polyp"));
		// bundle.addEntry()
		// .setResource(observation3)
		// .getRequest()
		// .setUrl("/Observation")
		// .setMethod(Bundle.HTTPVerb.POST);

		// // Create Observation resource 4 with custom ID
		// Observation observation4 = new Observation();
		// observation4.setId(new IdType("Observation", "colon-benign-lymphoid-polyp"));
		// bundle.addEntry()
		// .setResource(observation4)
		// .getRequest()
		// .setUrl("/Observation")
		// .setMethod(Bundle.HTTPVerb.POST);

		// // Create Observation resource 5 with custom ID
		// Observation observation5 = new Observation();
		// observation5.setId(new IdType("Observation",
		// "colon-polyp-piecemeal-excision-false"));
		// bundle.addEntry()
		// .setResource(observation5)
		// .getRequest()
		// .setUrl("/Observation")
		// .setMethod(Bundle.HTTPVerb.POST);

		// // Create Observation resource 6 with custom ID
		// Observation observation6 = new Observation();
		// observation6.setId(new IdType("Observation",
		// "colon-polyp-piecemeal-excision-true"));
		// bundle.addEntry()
		// .setResource(observation6)
		// .getRequest()
		// .setUrl("/Observation")
		// .setMethod(Bundle.HTTPVerb.POST);

		// // Create Observation resource 7 with custom ID
		// Observation observation7 = new Observation();
		// observation7.setId(new IdType("Observation",
		// "colon-polyp-severe-dysplasia-false"));
		// bundle.addEntry()
		// .setResource(observation7)
		// .getRequest()
		// .setUrl("/Observation")
		// .setMethod(Bundle.HTTPVerb.POST);

		// // Create Observation resource 8 with custom ID
		// Observation observation8 = new Observation();
		// observation8.setId(new IdType("Observation",
		// "colon-polyp-severe-dysplasia-true"));
		// bundle.addEntry()
		// .setResource(observation8)
		// .getRequest()
		// .setUrl("/Observation")
		// .setMethod(Bundle.HTTPVerb.POST);

		// // Create Observation resource 9 with custom ID
		// Observation observation9 = new Observation();
		// observation9.setId(new IdType("Observation",
		// "colon-polyp-no-evidence-of-malignant-neoplasm-true"));
		// bundle.addEntry()
		// .setResource(observation0)
		// .getRequest()
		// .setUrl("/Observation")
		// .setMethod(Bundle.HTTPVerb.POST);

		// // Create Observation resource 10 with custom ID
		// Observation observation10 = new Observation();
		// observation10.setId(new IdType("Observation",
		// "colon-polyp-no-evidence-of-malignant-neoplasm-false"));
		// bundle.addEntry()
		// .setResource(observation10)
		// .getRequest()
		// .setUrl("/Observation")
		// .setMethod(Bundle.HTTPVerb.POST);

		// // Upload the bundle to the server
		// Bundle response = client.transaction().withBundle(bundle).execute();
		// //
		// System.out.println(ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(response));

		// new
		PrintWriter writer = new PrintWriter(new File("./response.txt"));
		writer.println(response);
		writer.close();
		System.out.println("Response saved to file: response.txt");
	}
}
