package se.diabol.wct.test.acceptance;

import static org.junit.Assert.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;

import se.diabol.wct.core.ApacheBenchWebCapacityTester;
import se.diabol.wct.core.WebCapacityTester;

public class WebCapacityTesterTest {

	@Test
	public void test() throws Exception {
		WebCapacityTester wct = new ApacheBenchWebCapacityTester();
		wct.execute();
		assertThat(wct.report().textSummary(), new WCTMatcher());
	}
}

class WCTMatcher extends BaseMatcher<String> {
	private String notFound;

	private static final String[] expectedStrings = {
		"Web Capacity Report",
		"Capacity: \\d+ requests/s",
		"Request time threshold: \\d+ requests/s"
	};

	public boolean matches(Object item) {
		boolean found = false;
		for (String expected : expectedStrings) {
			Pattern pattern = Pattern.compile(expected);
			Matcher matcher = pattern.matcher((String) item);
			found = matcher.find();
			if (!found) {
				notFound = expected;
				break;
			}
		}
		return found;
	}

	public void describeTo(Description description) {
		description.appendText("Could not find RegExp: \"" + notFound + "\"");
	}
}