package com.equator.leetcode;

import java.util.*;

/**
 * @Author: Equator
 * @Date: 2020/4/13 10:31
 **/

public class Problem355 {
    class User {
        Integer uid;
        Set<Integer> followees = new HashSet<>();
    }

    class Tweet {
        Integer uid;
        Integer tweetId;

        public Tweet(Integer uid, Integer tweetId) {
            this.uid = uid;
            this.tweetId = tweetId;
        }
    }

    class Twitter {
        Map<Integer, User> userMap;
        List<Tweet> tweetList = new ArrayList<>();

        public Twitter() {
            userMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            User user = userMap.get(userId);
            if (user == null) {
                user = new User();
            }
            userMap.put(userId, user);
            tweetList.add(new Tweet(userId, tweetId));
        }

        public List<Integer> getNewsFeed(int userId) {
            User user = userMap.get(userId);
            if (user == null) {
                userMap.put(userId, new User());
                return Collections.emptyList();
            }
            List<Integer> tweets = new LinkedList<>();
            Set<Integer> followees = user.followees;
            int size = 0;
            for (int i = tweetList.size() - 1; i >= 0; i--) {
                if (size == 10) {
                    return tweets;
                }
                Tweet tweet = tweetList.get(i);
                if (tweet.uid == userId || followees.contains(tweet.uid)) {
                    tweets.add(tweet.tweetId);
                    size++;
                }
            }
            return tweets;
        }


        public void follow(int followerId, int followeeId) {
            User user = userMap.get(followerId);
            if (user == null) {
                user = new User();
            }
            user.followees.add(followeeId);
            userMap.put(followerId, user);
        }

        public void unfollow(int followerId, int followeeId) {
            User user = userMap.get(followerId);
            if (user == null) {
                user = new User();
            }
            user.followees.remove(followeeId);
            userMap.put(followerId, user);
        }
    }
}
