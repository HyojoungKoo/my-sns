package com.example.mysns;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedDAO {
    void insertFeed(FeedVO feed);
    list<FeedVO> selectAllFeed();
    FeedVO selectFeed(@Param("no") int no);
    void detletedFeed(@Param("no") int no);




}