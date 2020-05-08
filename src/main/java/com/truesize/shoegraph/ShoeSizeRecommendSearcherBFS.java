package com.truesize.shoegraph;


public class ShoeSizeRecommendSearcherBFS implements ShoeSearcher{
	
	//TODO: do a BFS search to find shoe
	public String getSizeRecc(String shoeCode, AllShoeRepository allShoeRepository) {
		//---- the users data, will need to pull this from Ted's database -----
		double usersSize = 8.5;
		String usersShoe = ShoeNode.generateUniqueCode("kd9","nike","m");
		//---- ---------------------------------------------------------- -----
		
		Double sizeRecc = allShoeRepository.findByUniqueShoeCode(usersShoe).getImmediateSizeDiff(shoeCode);
        
        if(sizeRecc == null){
            return "Shoe_Not_Found";
        }
        else {
            return Double.toString(sizeRecc);
        }
	}
    
}