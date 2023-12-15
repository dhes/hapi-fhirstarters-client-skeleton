package test;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.MethodOutcome;
// import ca.uhn.fhir.rest.api.MethodOutcome;
// import ca.uhn.fhir.rest.api.SearchStyleEnum;
// import ca.uhn.fhir.rest.api.SummaryEnum;
import ca.uhn.fhir.rest.client.api.IGenericClient;
// import ca.uhn.fhir.rest.param.DateRangeParam;
// import ca.uhn.fhir.util.BundleUtil;

// import java.util.ArrayList;
// import java.util.List;

// import org.hl7.fhir.instance.model.api.IBaseBundle;
// import org.hl7.fhir.instance.model.api.IBaseResource;
// import org.hl7.fhir.instance.model.api.IIdType;
// import org.hl7.fhir.r4.model.Bundle;
// import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.IdType;
// import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.OperationOutcome;
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

public class Stub {

	public static void main(String[] args) {
		FhirContext ctx = FhirContext.forR4();
		IGenericClient client = ctx.newRestfulGenericClient("http://localhost:8080/fhir");
	}
}
