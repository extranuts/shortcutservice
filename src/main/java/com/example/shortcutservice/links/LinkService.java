package com.example.shortcutservice.links;


import com.example.shortcutservice.common.ShortLink;

public interface LinkService {

    void save(ShortLink link);

    void remove(String link);

    ShortLink get(String code);

    ShortLink randomPull();

    String randomKey();

}
