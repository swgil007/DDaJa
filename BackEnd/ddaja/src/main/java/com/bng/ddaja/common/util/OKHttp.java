package com.bng.ddaja.common.util;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Slf4j
public final class OKHttp {

    private static final OkHttpClient client = new OkHttpClient();

    public static String getResponseBody(Request request) throws IOException {
        try {
            return getResponse(request).body().string();
        } catch (IOException e) {
            log.error("[OKHTTP Util] " + e.getMessage());
            throw e;
        }
    }

    private static Response getResponse(Request request) throws IOException {
        return client.newCall(request).execute();
    }
}
