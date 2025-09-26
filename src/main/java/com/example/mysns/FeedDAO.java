package com.example.mysns;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FeedDAO {
    void insertFeed(FeedVO feed);

    void insertFeedImg(FeedImgVO feedImg);

    FeedImgVO selectFeedImg(@Param("no") int no);

    List<FeedVO> selectAllFeed();

    FeedVO selectFeed(@Param("no") int no);

    void deleteFeed(@Param("no") int no);
}
