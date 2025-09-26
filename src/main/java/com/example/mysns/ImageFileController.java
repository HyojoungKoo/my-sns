package com.example.mysns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageFileController {

    @Autowired
    private FeedService feedService;

    @GetMapping("/images/{no}")
    public ResponseEntity<byte[]> getFeedImg(@PathVariable("no") int no) {

        FeedImgVO img = feedService.getFeedImg(no);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(img.getImage().length);

        return new ResponseEntity<>(img.getImage(),headers, HttpStatus.OK);
    }
}
