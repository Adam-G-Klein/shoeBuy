package com.truesize.shoegraph;

public class ShoeSearchFactory {
    public static ShoeSearcher createSearcher(String searchType) {
        if(searchType.equals("ShoeSizeRecommendSearcherBFS")){
            return new ShoeSizeRecommendSearcherBFS();
        }
        /*else if(searchType.equals("Some other way of searching")){
            
        }*/
        return null;
    }
}