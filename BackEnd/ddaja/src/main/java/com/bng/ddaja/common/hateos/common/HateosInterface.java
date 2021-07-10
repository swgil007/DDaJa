package com.bng.ddaja.common.hateos.common;

import java.util.List;

import com.bng.ddaja.common.dto.Link;

public interface HateosInterface {
    
    public Link makeLink(Object hateos, Long id);

    public List<Link> makeHateos(Long id);
}
