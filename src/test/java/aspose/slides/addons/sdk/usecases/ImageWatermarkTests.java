package aspose.slides.addons.sdk.usecases;

import aspose.slides.addons.sdk.ApiException;
import aspose.slides.addons.sdk.ApiResponse;
import aspose.slides.addons.sdk.api.SlidesApi;
import aspose.slides.addons.sdk.model.ImageWatermarkOptions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ImageWatermarkTests {
    private final SlidesApi api = new SlidesApi();
    private final String testFile = "../../TestData/test.pptx";
    private final String watermark = "../../TestData/watermark.png";
    private final Integer imageAngle = -45;
    private final Integer zoom = 50;

    @Test
    public void imageWatermark() throws ApiException {
        List<File> documents = new ArrayList<>();
        documents.add(new File(testFile));
        File watermarkFile = new File(watermark);

        ImageWatermarkOptions options = new ImageWatermarkOptions();
        options.setAngle(imageAngle);
        options.setZoom(zoom);

        File response = api.imageWatermark(documents, watermarkFile, options);
        assertNotNull(response);
        assertTrue(response.length()>0);
    }

    @Test
    public void imageWatermarkWithHttpInfo() throws ApiException {
        List<File> documents = new ArrayList<>();
        documents.add(new File(testFile));
        File watermarkFile = new File(watermark);

        ImageWatermarkOptions options = new ImageWatermarkOptions();
        options.setAngle(imageAngle);
        options.setZoom(zoom);

        ApiResponse response = api.imageWatermarkWithHttpInfo(documents, watermarkFile, options);

        assertTrue(response.getStatusCode() == 200);
        File f = new File(response.getData().toString());
        assertTrue(f.exists());
    }
}
