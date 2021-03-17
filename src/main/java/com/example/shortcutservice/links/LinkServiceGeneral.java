package com.example.shortcutservice.links;


import com.example.shortcutservice.common.ShortLink;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author
 * @return
 */

@Service
public class LinkServiceGeneral implements LinkService{

    private final Long SAVE_TIMEOUT_MS = 5000L;

    private final RedisTemplate<String, ShortLink> template;

    public LinkServiceGeneral(RedisTemplate<String, ShortLink> template) {
        this.template = template;
    }

    @Override
    public void save(ShortLink link) {
        template.opsForValue().set(link.getCode(), link, SAVE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    @Override
    public void remove(String link) {
        template.delete(link);
    }

    @Override
    public ShortLink get(String code) {
        return template.opsForValue().get(code);
    }

    @Override
    public ShortLink randomPull() {
        String key = randomKey();
        if (key != null) {
            return get(randomKey());
        }
        return null;
    }

    @Override
    public String randomKey() {
        return template.randomKey();
    }
}
