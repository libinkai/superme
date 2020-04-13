package com.equator.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 设计一个限制大小的堆，效果更好
 *
 * @Author: Equator
 * @Date: 2020/4/13 10:31
 **/

public class Problem355Better {
    class User {
        Integer uid;
        Set<Integer> followees = new HashSet<>();
        List<Tweet> tweets = new ArrayList<>();
    }

    class Tweet implements Comparable<Tweet> {
        long time = System.nanoTime();
        Integer tweetId;

        public Tweet(Integer tweetId) {
            this.tweetId = tweetId;
        }

        @Override
        public int compareTo(Tweet o) {
            return (int) (o.time - this.time);
        }
    }

    class Twitter {
        Map<Integer, User> userMap;

        public Twitter() {
            userMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            User user = userMap.get(userId);
            if (user == null) {
                user = new User();
            }
            user.tweets.add(new Tweet(tweetId));
            userMap.put(userId, user);
        }

        public List<Integer> getNewsFeed(int userId) {
            User user = userMap.get(userId);
            if (user == null) {
                userMap.put(userId, new User());
                return Collections.emptyList();
            }
            List<Integer> tweets = new LinkedList<>();
            Set<Integer> followees = user.followees;
            PriorityQueue<Tweet> tweetPriorityQueue = new PriorityQueue<>();
            // 别人的
            for (Integer followeeId : followees) {
                if (followeeId.equals(userId)) {
                    continue;
                }
                User followee = userMap.get(followeeId);
                if (followee == null) {
                    break;
                }
                for (int i = followee.tweets.size() - 1; i > followee.tweets.size() - 11 && i >= 0; i--) {
                    tweetPriorityQueue.add(followee.tweets.get(i));
                }
            }
            // 自己的
            for (int i = user.tweets.size() - 1; i > user.tweets.size() - 11 && i >= 0; i--) {
                tweetPriorityQueue.add(user.tweets.get(i));
            }
            for (int i = 0; i < 10; i++) {
                Tweet tweet = tweetPriorityQueue.poll();
                if (tweet == null) {
                    break;
                }
                tweets.add(tweet.tweetId);
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

    @Test
    public void main() {
        Twitter twitter = new Twitter();
        twitter.follow(1, 5);
        twitter.getNewsFeed(1);
    }
}
