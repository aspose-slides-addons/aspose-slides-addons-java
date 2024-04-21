package aspose.slides.addons.sdk.usecases;

import aspose.slides.addons.sdk.ApiException;
import aspose.slides.addons.sdk.ApiResponse;
import aspose.slides.addons.sdk.api.SlidesApi;
import aspose.slides.addons.sdk.model.ExportFormat;
import aspose.slides.addons.sdk.model.SplitOptions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SplitTests {
    private final SlidesApi api = new SlidesApi();
    private final String testFile = "../../TestData/test.pptx";

    @Test
    public void split() throws ApiException {
        ExportFormat format = ExportFormat.PDF;
        File file = new File(testFile);

        SplitOptions splitOptions = new SplitOptions();
        splitOptions.setSlidesRange("1,2-4,5");

        File response = api.split(format, file, splitOptions);
        assertNotNull(response);
        assertTrue(response.length()>0);
    }

    @Test
    public void splitWithHttpInfo() throws ApiException {
        ExportFormat format = ExportFormat.PDF;
        File file = new File(testFile);

        SplitOptions options = new SplitOptions();
        options.setSlidesRange("1,2-4,5");

        ApiResponse response = api.splitWithHttpInfo(format, file, options);
        assertTrue(response.getStatusCode() == 200);
        File f = new File(response.getData().toString());
        assertTrue(f.exists());
    }
}
