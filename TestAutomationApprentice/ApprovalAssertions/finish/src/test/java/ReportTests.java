import com.itextpdf.text.pdf.PdfReader;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.io.*;

public class ReportTests {

    @Test
    public void testList() {
        Approvals.verify("Hello World");
    }

    @Test
    public void testPdfFile() throws IOException {
        String textifiedFile = convertPdfFileToString("src/test/resources/example.pdf");

        Approvals.verify(textifiedFile);
    }

    private String convertPdfFileToString(String filePathWithName) throws IOException {
        PdfReader reader = new PdfReader(filePathWithName);
        return new String(reader.getPageContent(1));
    }
}

