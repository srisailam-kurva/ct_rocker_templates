package com.rocker;

import org.xhtmlrenderer.pdf.ITextOutputDevice;
import org.xhtmlrenderer.pdf.ITextUserAgent;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MyUserAgent extends ITextUserAgent {
    @Override
    protected InputStream resolveAndOpenStream(String url) {
        try {
            URL resolvedUrl = new URL(url);
            return resolvedUrl.openStream();
        } catch (IOException e) {
            throw new RuntimeException("external css path invalid :-"+e);
        }
    }

    public MyUserAgent(ITextOutputDevice outputDevice) {
        super(outputDevice);
    }
}
