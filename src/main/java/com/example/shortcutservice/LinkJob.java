package com.example.shortcutservice;


import com.example.shortcutservice.common.ShortLink;
import com.example.shortcutservice.links.LinkService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Queue;

/**
 * @author
 * @return
 */

@Component
@EnableScheduling
public class LinkJob {

    private final Queue<String>linksQueue;
    private final LinkService linksService;

    public LinkJob(Queue<String> linksQueue, LinkService linksService) {
        this.linksQueue = linksQueue;
        this.linksService = linksService;
    }

    @Scheduled(fixedRate = 1000L)
    public void freeLink(){

        ShortLink shortLink = linksService.randomPull();
        if(shortLink != null){
            linksService.remove(shortLink.getCode());
            linksQueue.add(shortLink.getCode());
        }
    }


    @Scheduled(fixedRate = 500L)
    public void bookLink(){
        String link = linksQueue.poll();
        if(link != null) {
            linksService.save(new ShortLink(link, "google.com"));
        }
    }

    @Scheduled(fixedRate = 500L)
    public void useLink(){
        ShortLink shortLink = linksService.randomPull();
        System.out.println(shortLink);
    }
}
