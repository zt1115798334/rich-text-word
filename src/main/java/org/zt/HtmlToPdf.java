package org.zt;

import com.itextpdf.text.pdf.BaseFont;
import org.jsoup.Jsoup;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2022/8/12 15:02
 * description:
 */
public class HtmlToPdf {
    public static void main(String[] args) throws Exception {
//        htmlFileToPDF();

        htmlStringToPdf();
    }

    /**
     * htmlStringToPdf:(html字符串转换成pdf). <br/>
     * @author ChenDongWei
     * @date 2018年11月8日下午2:59:07
     * @throws Exception
     */
    private static void htmlStringToPdf() throws Exception {
        ITextRenderer renderer = new ITextRenderer();
        ITextFontResolver fontResolver = renderer.getFontResolver();
        fontResolver.addFont("C:/Windows/fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        String outFile = "/test2.pdf";
        OutputStream os = new FileOutputStream(outFile);
        String html = String.join("", Files.readAllLines(Paths.get("C:\\Users\\zhang\\Desktop\\Untitled-1.html")));
        System.out.println("text = " + html);
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(os);
        os.close();
    }

    /**
     * htmlFileToPDF:(html文件转换成pdf). <br/>
     * @author ChenDongWei
     * @date 2018年11月8日下午2:59:42
     * @throws Exception
     */
    private static void htmlFileToPDF() throws Exception {
        String inputFile = "C:/Users/ChenDongWei/Desktop/test.html";
        String outFile = "C:/Users/ChenDongWei/Desktop/test1.pdf";
        OutputStream os = new FileOutputStream(outFile);
        ITextRenderer renderer = new ITextRenderer();
        ITextFontResolver fontResolver = renderer.getFontResolver();
        fontResolver.addFont("C:/Windows/fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        String url = new File(inputFile).toURI().toURL().toString();
        renderer.setDocument(url);
        renderer.layout();
        renderer.createPDF(os);
        os.close();
    }
}
