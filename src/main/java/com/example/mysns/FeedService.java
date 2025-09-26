package com.example.mysns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FeedService {

    @Autowired
    private FeedDAO feedDAO;

    public void createFeed(FeedVO feedVO, MultipartFile[] images) throws IOException {

        //게시글 등록
        feedDAO.insertFeed(feedVO);

        //게시물 이미지 등록
        for (MultipartFile img : images) {
            FeedImgVO feedImg = new FeedImgVO();
            feedImg.setFeedNo(feedVO.getNo());
            feedImg.setImage(img.getBytes());

            feedDAO.insertFeedImg(feedImg);
        }
    }

    public List<FeedVO> getAllFeeds() {
        return feedDAO.selectAllFeed();
    }

    public FeedImgVO getFeedImg(int no) {
        return feedDAO.selectFeedImg(no);

    }
}
