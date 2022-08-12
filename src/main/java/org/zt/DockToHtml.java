package org.zt;

import org.zwobble.mammoth.DocumentConverter;
import org.zwobble.mammoth.Result;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2022/8/12 11:14
 * description:
 */
public class DockToHtml {
    public static void main(String[] args) throws IOException {
        DocumentConverter converter = new DocumentConverter();
        Result<String> result = converter.convertToHtml(new File("E:\\IdeaProjects\\html-format\\output.docx"));
        String html = result.getValue(); // The generated HTML
        System.out.println(html);
        Set<String> warnings = result.getWarnings(); // Any warnings during conversion
    }
}
