package com.truesize.shoegraph;

import com.truesize.AccountService;

public interface ShoeSearcher {
    String getSizeRecc(String shoeCode, AllShoeRepository allShoeRepository, AccountService ac);
    String noShoeFoundMessage = "Shoe_Not_Found";
}