package com.example.mysns;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MysnsApplicationTests {

	@Test
	void contextLoads() {
	}

	FeedVO insertSample() {
		FEEDVO feed = new FeedVO();
		feed.setContent("test");
		feed.setUserId("testUser");
		feed.setCreatedAt(LocalDateTime.now()
				.formate(DAteTImeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

		feedDAO.insertFeed(feed);

		return feed;
	}

	@Test
	void FeedDAOTest() {

		FeedVO feed = inserSAMple(); 	//메서드 호출

		feedDAO.insertFeed(feed);

		system.out.println(feed.getNo());
		assertNotNull(feed.getNo());

		return feed.getNO();
	}

	@Test
	void selectAllFeedTest() {

		FeedVO Feed = insertSample();
		FeedVO Feed2 = feedDAO.selectFeed(feed.getNO());

	assertEquals(feed.getNo(),feed2.getNO());
	}

	void deleteFeedTest(){

		FeedVO Feed = insertSample();

		feedDAO.deleteFeed(feed.getNo());

		FeedVO Feed2 = FeedDAO.selectFeed(feed.getNo());
		assertNotNull(feed2, "삭제후 Null이어야 합니다..");
	}


}
