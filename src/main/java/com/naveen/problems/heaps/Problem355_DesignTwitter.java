package com.naveen.problems.heaps;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/*
* https://leetcode.com/problems/design-twitter/
* Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see
* the 10 most recent tweets in the user's news feed.
Implement the Twitter class:
Twitter() Initializes your twitter object.

* void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId.
Each call to this function will be made with a unique tweetId.

List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed.
Each item in the news feed must be posted by users who the user followed or by the user themself.
Tweets must be ordered from most recent to least recent.

void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]

Explanation
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
* */
public class Problem355_DesignTwitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
    static class Twitter {
        Map<Integer, Set<Integer>> followers = new HashMap<>();
        Map<Integer, LinkedList> posts = new HashMap<>();
        AtomicInteger sequence = new AtomicInteger();

        private Set<Integer> getFollowers(int userId) {
            Set<Integer> res = followers.computeIfAbsent(userId, k -> new HashSet<>());
            res.add(userId);
            return res;
        }

        private LinkedList getPosts(int userId) {
            return posts.computeIfAbsent(userId, k -> new LinkedList());
        }

        public void postTweet(int userId, int tweetId) {
            LinkedList usersPosts = getPosts(userId);
            usersPosts.addFirst(new int[]{sequence.incrementAndGet(), tweetId, userId});
            posts.put(userId, usersPosts);
        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Node> pq = new PriorityQueue<>((p1, p2) -> p2.data[0] - p1.data[0]);
            Set<Integer> follows = getFollowers(userId);
            List<Integer> res = new ArrayList<>();
            for (int fId : follows) {
                Node node = getPosts(fId).getFirst();
                if (node != null && node.data != null)
                    pq.offer(node);
            }

            int i = 10;
            while (i-- > 0 && !pq.isEmpty()) {
                Node e = pq.poll();
                res.add(e.data[1]);
                if (e.next != null) pq.offer(e.next);
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            getFollowers(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            getFollowers(followerId).remove(followeeId);
        }

        static class LinkedList {
            Node head;
            public void addFirst(int[] v) {
                Node node = new Node(v);
                node.next = head;
                head = node;
            }
            public Node getFirst() {
                return head;
            }
        }

        static class Node {
            int[] data;
            Node next;
            public Node(int[] data) {
                this.data = data;
            }
        }
    }
}
