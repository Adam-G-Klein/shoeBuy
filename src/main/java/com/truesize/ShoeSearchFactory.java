package com.truesize;

public class ShoeSearchFactory {
    public ShoeSearcher createSearcher(String searchType) {
        if(searchType.equals("ShoeSizeRecommendSearcher")){
            return new ShoeSizeRecommendSearcher();
        }
        else if(searchType.equals("SimilarShoeSearcher")){
            
        }
        return null;
    }
}