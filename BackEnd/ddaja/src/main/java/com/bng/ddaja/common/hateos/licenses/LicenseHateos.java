package com.bng.ddaja.common.hateos.licenses;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.bng.ddaja.common.dto.Link;
import com.bng.ddaja.common.hateos.CommonHateos;

public enum LicenseHateos implements CommonHateos {
    SELF("GET", "https://api.ddaja.com/licenses/")
    , UPDATE("PATCH", "https://api.ddaja.com/licenses/")
    , REPLACE("PUT", "https://api.ddaja.com/licenses/")
    , DELETE("DELETE", "https://api.ddaja.com/licenses/");

    public String method;
    public String url;
    //private static final List<LicenseHateos> = Arrays.stream(super.values()).collect(Collectors.toList());
    LicenseHateos(String method, String url) {
        this.method = method;
        this.url = url;
    }

    @Override
    public Link initLink(long id) {
        return new Link(name(), new StringBuilder().append(url).append(Long.toString(id)).toString(), method);
    }
}
