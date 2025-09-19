package utilities;

//import java.net.URL;

//Extent report 5.x...//version

/*import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;*/

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//public class ExtentReportManager implements ITestListener {

    public class ExtentManager {

        private static ExtentReports extent;

        public static ExtentReports getInstance() {
            if (extent == null) {
                String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
                ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
                reporter.config().setReportName("Automation Test Report");
                reporter.config().setDocumentTitle("Test Results");

                extent = new ExtentReports();
                extent.attachReporter(reporter);
                extent.setSystemInfo("Tester", "YourName");
            }
            return extent;
        }

}
