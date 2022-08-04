package QRCode.qrcode.controller;

import QRCode.qrcode.entity.QRgenerator;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("qrcode")
@Api(value = "qr-code api", description = "api fot qr-code-for people use")
public class QRcontroller {

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

    @GetMapping(value = "/genrateAndDownload/{codeText}/{width}/{height}")
    public void download(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height)
            throws Exception {
        QRgenerator.generateQRCodeImage(codeText, width, height, QR_CODE_IMAGE_PATH);
    }

    @GetMapping(value = "/genrate/{codeText}/{width}/{height}")
    public ResponseEntity<byte[]> generateQRCode(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height)
            throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(QRgenerator.getQRCodeImage(codeText, width, height));
    }

    //link address http://localhost:8080/v2/api-docs
    //final link address http://localhost:8080/swagger-ui.html#/
}
