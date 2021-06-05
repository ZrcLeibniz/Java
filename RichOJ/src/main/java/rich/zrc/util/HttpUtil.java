package rich.zrc.util;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class HttpUtil {
    public static String readBody(HttpServletRequest req) throws UnsupportedEncodingException {
        int contentLength = req.getContentLength();
        byte[] buf = new byte[contentLength];
        try(InputStream inputStream = req.getInputStream()) {
            inputStream.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(buf, "utf-8");
    }

}
