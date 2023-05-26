package com.testapp.ramboostergfxtool.vipgfx.util;

import android.app.Activity;
import com.testapp.ramboostergfxtool.vipgfx.util.RequestNetwork.RequestListener;
import com.testapp.ramboostergfxtool.vipgfx.stringfog.xor.StringFogImpl;
import com.google.gson.Gson;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RequestNetworkController {
    public static final String DELETE = StringFogImpl.decrypt("EREKaGwQ");
    public static final String GET = StringFogImpl.decrypt("EhES");
    public static final String POST = StringFogImpl.decrypt("BRsVeQ==");
    public static final String PUT = StringFogImpl.decrypt("BQES");
    private static final int READ_TIMEOUT = 25000;
    public static final int REQUEST_BODY = 1;
    public static final int REQUEST_PARAM = 0;
    private static final int SOCKET_TIMEOUT = 15000;
    private static RequestNetworkController mInstance;
    protected OkHttpClient client;

    public static synchronized RequestNetworkController getInstance() {
        RequestNetworkController requestNetworkController;
        synchronized (RequestNetworkController.class) {
            if (mInstance == null) {
                mInstance = new RequestNetworkController();
            }
            requestNetworkController = mInstance;
        }
        return requestNetworkController;
    }

    private OkHttpClient getClient() {
        if (this.client == null) {
            Builder builder = new Builder();
            try {
                TrustManager[] trustManagerArr = {new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                    }

                    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                    }

                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }};
                SSLContext instance = SSLContext.getInstance(StringFogImpl.decrypt("ARgV"));
                instance.init(null, trustManagerArr, new SecureRandom());
                builder.sslSocketFactory(instance.getSocketFactory(), (X509TrustManager) trustManagerArr[0]);
                builder.connectTimeout(15000, TimeUnit.MILLISECONDS);
                builder.readTimeout(25000, TimeUnit.MILLISECONDS);
                builder.writeTimeout(25000, TimeUnit.MILLISECONDS);
                builder.hostnameVerifier(new HostnameVerifier() {
                    public boolean verify(String str, SSLSession sSLSession) {
                        return true;
                    }
                });
            } catch (Exception unused) {
            }
            this.client = builder.build();
        }
        return this.client;
    }

    public void execute(final RequestNetwork requestNetwork, String str, String str2, final String str3, final RequestListener requestListener) {
        Request.Builder builder = new Request.Builder();
        Headers.Builder builder2 = new Headers.Builder();
        if (requestNetwork.getHeaders().size() > 0) {
            for (Entry entry : requestNetwork.getHeaders().entrySet()) {
                builder2.add((String) entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        try {
            if (requestNetwork.getRequestType() != 0) {
                RequestBody create = RequestBody.create(MediaType.parse(StringFogImpl.decrypt("NCQ2QVE2NTJEVzt7LF5XOw==")), new Gson().toJson((Object) requestNetwork.getParams()));
                if (str.equals(GET)) {
                    builder.url(str2).headers(builder2.build()).get();
                } else {
                    builder.url(str2).headers(builder2.build()).method(str, create);
                }
            } else if (str.equals(GET)) {
                HttpUrl.Builder newBuilder = HttpUrl.parse(str2).newBuilder();
                if (requestNetwork.getParams().size() > 0) {
                    for (Entry entry2 : requestNetwork.getParams().entrySet()) {
                        newBuilder.addQueryParameter((String) entry2.getKey(), String.valueOf(entry2.getValue()));
                    }
                }
                builder.url(newBuilder.build()).headers(builder2.build()).get();
            } else {
                FormBody.Builder builder3 = new FormBody.Builder();
                if (requestNetwork.getParams().size() > 0) {
                    for (Entry entry3 : requestNetwork.getParams().entrySet()) {
                        builder3.add((String) entry3.getKey(), String.valueOf(entry3.getValue()));
                    }
                }
                builder.url(str2).headers(builder2.build()).method(str, builder3.build());
            }
            getClient().newCall(builder.build()).enqueue(new Callback() {
                public void onFailure(Call call, final IOException iOException) {
                    Activity activity = requestNetwork.getActivity();
                    final RequestListener requestListener1 = requestListener;
                    final String str = str3;
                    activity.runOnUiThread(new Runnable() {
                        public void run() {
                            requestListener1.onErrorResponse(str, iOException.getMessage());
                        }
                    });
                }

                public void onResponse(Call call, Response response) throws IOException {
                    final String trim = response.body().string().trim();
                    Activity activity = requestNetwork.getActivity();
                    final RequestListener requestListener2 = requestListener;
                    final String str = str3;
                    final Response response2 = response;
                    Runnable r0 = new Runnable() {
                        public void run() {
                            Headers headers = response2.headers();
                            HashMap hashMap = new HashMap();
                            for (String str : headers.names()) {
                                hashMap.put(str, headers.get(str) != null ? headers.get(str) : StringFogImpl.decrypt("OyEqQQ=="));
                            }
                            requestListener2.onResponse(str, trim, hashMap);
                        }
                    };
                    activity.runOnUiThread(r0);
                }
            });
        } catch (NullPointerException unused) {
            StringBuilder sb = new StringBuilder(StringFogImpl.decrypt("IDojVUgwNzJIXHUhNEECdQ=="));
            sb.append(str2);
            throw new NullPointerException(sb.toString());
        } catch (Exception e) {
            requestListener.onErrorResponse(str3, e.getMessage());
        }
    }
}
