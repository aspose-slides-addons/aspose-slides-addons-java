package aspose.slides.addons.sdk.usecases;

import aspose.slides.addons.sdk.ApiException;
import aspose.slides.addons.sdk.ApiResponse;
import aspose.slides.addons.sdk.api.SlidesApi;
import aspose.slides.addons.sdk.model.ExportFormat;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ConvertTests {
    private final SlidesApi api = new SlidesApi();
    private final String testFile = "../../TestData/Test.pptx";

    @Test
    public void convert() throws ApiException {
        ExportFormat format = ExportFormat.PDF;
        List<File> documents = new ArrayList<>();
        documents.add(new File(testFile));

        File response = api.convert(format, documents);
        assertNotNull(response);
        assertTrue(response.length()>0);
    }

    @Test
    public void convertWithHttpInfo() throws ApiException {
        ExportFormat format = ExportFormat.PDF;
        List<File> documents = new ArrayList<>();
        documents.add(new File(testFile));

        ApiResponse response = api.convertWithHttpInfo(format, documents);
        assertTrue(response.getStatusCode() == 200);
        File f = new File(response.getData().toString());
        assertTrue(f.exists());
    }

}
