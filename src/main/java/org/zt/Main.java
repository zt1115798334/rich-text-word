package org.zt;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import org.ddr.poi.html.HtmlRenderPolicy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ${USER}
 * date: ${DATE} ${TIME}
 * description:
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String html = String.join("", Files.readAllLines(Paths.get("C:\\Users\\zhang\\Desktop\\Untitled-1.html")));
        HtmlRenderPolicy htmlRenderPolicy = new HtmlRenderPolicy();
        Configure configure = Configure.builder()
                .bind("key", htmlRenderPolicy)
                .build();
        Map<String, Object> data = new HashMap<>();
        data.put("key", html);
        XWPFTemplate.compile("E:\\IdeaProjects\\rich-text-word\\src\\main\\resources\\input.docx", configure).render(data).writeToFile("output.docx");
    }
}