package aspose.slides.addons.sdk.usecases;

import aspose.slides.addons.sdk.ApiException;
import aspose.slides.addons.sdk.ApiResponse;
import aspose.slides.addons.sdk.api.SlidesApi;
import aspose.slides.addons.sdk.model.ReplaceTextOptions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ReplaceTextTests {
    private final SlidesApi api = new SlidesApi();
    private final String testFile = "../../TestData/test.pptx";
    private final String oldValue = "Text to replace";
    private final String newValue = "New value";
    @Test
    public void replaceText() throws ApiException {
        List<File> documents = new ArrayList<>();
        documents.add(new File(testFile));

        ReplaceTextOptions options = new ReplaceTextOptions();
        options.setOldValue(oldValue);
        options.setNewValue(newValue);
        options.setIgnoreCase(true);

        File response = api.replaceText(options, documents);
        assertNotNull(response);
        assertTrue(response.length()>0);
    }

    @Test
    public void replaceTextWithHttpInfo() throws ApiException {
        List<File> documents = new ArrayList<>();
        documents.add(new File(testFile));

        ReplaceTextOptions options = new ReplaceTextOptions();
        options.setOldValue(oldValue);
        options.setNewValue(newValue);
        options.setIgnoreCase(true);

        ApiResponse response = api.replaceTextWithHttpInfo(options, documents);
        assertTrue(response.getStatusCode() == 200);
        File f = new File(response.getData().toString());
        assertTrue(f.exists());
    }
}
