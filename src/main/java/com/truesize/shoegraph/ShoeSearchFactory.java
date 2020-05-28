package com.truesize.shoegraph;

public class ShoeSearchFactory {
    public static ShoeSearcher createSearcher(String searchType) {
        if(searchType.equals("ShoeSizeRecommendSearcherBFS")){
            return new ShoeSizeRecommendSearcherBFS();
        }
        else if(searchType.equals("ShoeSizeRecommendSearcherSmartBFS")){
            return new ShoeSizeRecommendSearcherSmartBFS();
        }
        return null;
    }
}