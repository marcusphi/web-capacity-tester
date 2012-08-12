package se.diabol.wct.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import se.diabol.wct.report.ReportData;
import se.diabol.wct.report.WebCapacityReport;

public class ApacheBenchWebCapacityTester implements WebCapacityTester {

	ReportData data = new ReportData();

	public void execute() throws IOException {
		String command = "ab";
		String args = "-t 1 -c 10";
		String url = "http://localhost:8080/marcus-web/index.html";
		Process process = new ProcessBuilder(command, args, url).start();
		BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));

		String line = in.readLine();
		while (line != null) {
			line = in.readLine();
			System.out.println(line);
		}

		process.destroy();
	}

	public WebCapacityReport report() {
		// TODO Auto-generated method stub

		return new WebCapacityReport();
	}

}
