package se.diabol.wct.report;

/**
 * The reports of the web capacity test.
 * 
 * @author marcus
 */
public class WebCapacityReport {

	/**
	 * @return a summary level text report of the results of the test.
	 */
	public String textSummary() {
		// TODO Auto-generated method stub
		return new StringBuilder("").
				append("***** Web Capacity Report *****\n").
				append("URL: http://localhost:8080/marcus-web/index.html\n").
				append("Time limit per step: 3s\n").
				append("\n").
				append("Capacity: 2138 requests/s\n").
				append("* request time: 500 ms/request\n").
				append("* concurrency: 200\n").
				append("Request time threshold: 2430 requests/s\n").
				append("* concurrency: 300\n").
				toString();
	}

}
