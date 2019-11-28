package com.example.demo.mongodb.entity.thread;

import com.example.demo.entity.BaseResponse;

import java.util.ArrayList;
import java.util.List;

public class RecommendedThreadsResponse extends BaseResponse {
    List<BrefThread> recommendedBriefThreads = new ArrayList<>();

    public List<BrefThread> getRecommendedBriefThreads() {
        return recommendedBriefThreads;
    }

    public void setRecommendedBriefThreads(List<BrefThread> recommendedBriefThreads) {
        this.recommendedBriefThreads = recommendedBriefThreads;
    }
}
