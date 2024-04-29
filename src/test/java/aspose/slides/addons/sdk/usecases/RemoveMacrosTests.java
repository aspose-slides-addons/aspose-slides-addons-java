package aspose.slides.addons.sdk.usecases;

import aspose.slides.addons.sdk.ApiException;
import aspose.slides.addons.sdk.ApiResponse;
import aspose.slides.addons.sdk.api.SlidesApi;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RemoveMacrosTests {
    private final SlidesApi api = new SlidesApi();
    private final String testFile = "../../TestData/macros.pptm";

    @Test
    public void removeMacros() throws ApiException {
        File file = new File(testFile);

        File response = api.removeMacros(file);

        assertNotNull(response);
        assertTrue(response.length()>0);
    }

    @Test
    public void removeMacrosWithHttpInfo() throws ApiException {
        File file = new File(testFile);

        ApiResponse response = api.removeMacrosWithHttpInfo(file);

        assertTrue(response.getStatusCode() == 200);
        File f = new File(response.getData().toString());
        assertTrue(f.exists());
    }
}
