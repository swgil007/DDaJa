package com.bng.ddaja.common.hateos.licenses;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.bng.ddaja.common.dto.Link;

public enum Licenses {
    SELF("GET", "https://api.ddaja.com/licenses/")
    , UPDATE("PATCH", "https://api.ddaja.com/licenses/")
    , REPLACE("PUT", "https://api.ddaja.com/licenses/")
    , DELETE("DELETE", "https://api.ddaja.com/licenses/");

    public String method;
    public String url;

    Licenses(String method, String url) {
        this.method = method;
        this.url = url;
    }

    public Link initLink(Long id) {
        return new Link(name(), url+id.toString(), method);
    }

    public URI makeURI(Long id) {
        try {
            return new URI(initLink(id).getUrl());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Link> makeLinkList(Long id) {
        return Arrays.stream(values()).map(e -> new Link(name(), url+id.toString(), method)).collect(Collectors.toList());
    }
}
