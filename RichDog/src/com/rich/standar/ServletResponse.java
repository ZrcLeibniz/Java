package com.rich.standar;

import java.io.IOException;
import java.io.PrintWriter;

public interface ServletResponse {
    PrintWriter getWriter() throws IOException;

    void setContentType(String s);
}
