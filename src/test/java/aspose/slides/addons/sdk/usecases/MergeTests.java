package aspose.slides.addons.sdk.usecases;

import aspose.slides.addons.sdk.ApiException;
import aspose.slides.addons.sdk.ApiResponse;
import aspose.slides.addons.sdk.api.SlidesApi;
import aspose.slides.addons.sdk.model.ExportFormat;
import aspose.slides.addons.sdk.model.MergeOptions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MergeTests {

    private final SlidesApi api = new SlidesApi();
    private final String testFile = "../../TestData/test.pptx";
    private final String masterFile = "../../TestData/master.pptx";

    @Test
    public void merge() throws ApiException {
        ExportFormat format = ExportFormat.PDF;
        List<File> documents = new ArrayList<>();
        documents.add(new File(testFile));
        documents.add(new File(masterFile));

        MergeOptions options = new MergeOptions();
        options.setMasterFileName("master.pptx");
        options.setExcludeMasterFile(false);

        File response = api.merge(format, documents, options);
        assertNotNull(response);
        assertTrue(response.length()>0);
    }

    @Test
    public void mergeWithHttpInfo() throws ApiException {
        ExportFormat format = ExportFormat.PDF;
        List<File> documents = new ArrayList<>();
        documents.add(new File(testFile));
        documents.add(new File(masterFile));

        MergeOptions options = new MergeOptions();
        options.setMasterFileName("master.pptx");
        options.setExcludeMasterFile(false);

        ApiResponse response = api.mergeWithHttpInfo(format, documents, options);
        assertTrue(response.getStatusCode() == 200);
        File f = new File(response.getData().toString());
        assertTrue(f.exists());
    }
}
