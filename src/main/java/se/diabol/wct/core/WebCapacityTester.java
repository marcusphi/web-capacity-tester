package se.diabol.wct.core;

import java.io.IOException;

import se.diabol.wct.report.WebCapacityReport;

public interface WebCapacityTester {

	/**
	 * Execute the capacity test. When this has been called the report methods can be called.
	 * @throws IOException
	 */
	void execute() throws IOException;

	WebCapacityReport report();

}
