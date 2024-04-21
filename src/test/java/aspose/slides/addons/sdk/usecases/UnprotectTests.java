package aspose.slides.addons.sdk.usecases;

import aspose.slides.addons.sdk.ApiException;
import aspose.slides.addons.sdk.ApiResponse;
import aspose.slides.addons.sdk.api.SlidesApi;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UnprotectTests {
    private final SlidesApi api = new SlidesApi();
    private final String testFile = "../../TestData/protected.pptx";
    private final String password = "password";

    @Test
    public void Unprotect() throws ApiException {
        File file = new File(testFile);

        File response = api.unprotect(password, file);

        assertNotNull(response);
        assertTrue(response.length()>0);
    }

    @Test
    public void UnprotectWithHttpInfo() throws ApiException {
        File file = new File(testFile);

        ApiResponse response = api.unprotectWithHttpInfo(password, file);

        assertTrue(response.getStatusCode() == 200);
        File f = new File(response.getData().toString());
        assertTrue(f.exists());
    }
}
