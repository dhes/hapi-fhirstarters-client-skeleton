// package test;

// import java.nio.charset.StandardCharsets;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.util.Base64;
// import org.hl7.fhir.r4.model.Attachment;
// import org.hl7.fhir.r4.model.Library;

// import ca.uhn.fhir.context.FhirContext;
// import ca.uhn.fhir.rest.client.api.IGenericClient;

// public class importModifiedColonCancerScreeningCqlToLibrary {

// public static void main(String[] args) {
// // Assume fhirClient is an instance of IGenericClient
// FhirContext ctx = FhirContext.forR4();
// IGenericClient fhirClient =
// ctx.newRestfulGenericClient("http://localhost:8080/fhir");

// // Step 1: Retrieve the FHIR Library resource
// Library library = fhirClient.read()
// .resource(Library.class)
// .withId("ColorectalCancerScreeningsFHIR")
// .execute();

// // Step 2: Read the modified CQL content from the file
// Path cqlFilePath = Paths.get("decodedCql.cql");
// try {
// String modifiedCqlContent = Files.readString(cqlFilePath);

// // Step 3: Convert modified CQL content to Base64
// String modifiedBase64BinaryData = Base64.getEncoder()
// .encodeToString(modifiedCqlContent.getBytes(StandardCharsets.UTF_8));

// // Step 4: Update the FHIR Library Resource
// Attachment updatedAttachment = new Attachment()
// .setContentType("text/cql")
// .setData(modifiedBase64BinaryData.getBytes(StandardCharsets.UTF_8));

// // Assuming there is only one attachment in the content list
// library.getContent().get(0).setData(updatedAttachment.getData());

// // Step 5: Update the FHIR Library Resource on the Server
// MethodOutcome outcome = fhirClient.update()
// .resource(library)
// .execute();

// System.out.println("FHIR Library updated successfully.");
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
// }