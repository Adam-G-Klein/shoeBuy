package com.truesize.shoegraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShoeSizeRecommendSearcherBFS implements ShoeSearcher{
	class ShoeCodeWithDistance{
		public String shoeCode;
		public double sizeDiff;
		public ShoeCodeWithDistance(String shoeCode, double sizeDiff){
			this.shoeCode = shoeCode;
			this.sizeDiff = sizeDiff;
		}
	}

	//TODO: do a BFS search to find shoe
	public String getSizeRecc(String desiredShoeCode, AllShoeRepository allShoeRepository) {
		//---- the users data, will need to pull this from Ted's database -----
		double usersSize = 10.0;
		String usersShoe = ShoeNode.generateUniqueCode("t1c","adidas","f");
		//---- ---------------------------------------------------------- -----

		Queue<ShoeCodeWithDistance> bfsQueue = new LinkedList<ShoeCodeWithDistance>();
		HashSet<String> visitedShoes = new HashSet(); 

		//TODO find a way to track how size difference is
		bfsQueue.add(new ShoeCodeWithDistance(usersShoe, 0.0));

		while(!bfsQueue.isEmpty()) {
			ShoeCodeWithDistance currentShoeInfo = bfsQueue.remove();
			visitedShoes.add(currentShoeInfo.shoeCode);

			if(currentShoeInfo.shoeCode.equals(desiredShoeCode)) {
				//found shoe
				return Double.toString(usersSize + currentShoeInfo.sizeDiff);
			}

			ShoeNode currentNode = allShoeRepository.findByUniqueShoeCode(currentShoeInfo.shoeCode);
			List<String> edges = currentNode.getEdgesAsShoeCodes();
			for(String edge : edges) {
				if(!visitedShoes.contains(edge)){
					double sizeDiffToEdge = currentNode.getImmediateSizeDiff(edge);
					double sizeDiff = currentShoeInfo.sizeDiff + sizeDiffToEdge; 
					bfsQueue.add(new ShoeCodeWithDistance(edge, sizeDiff));
				}
			}
		}

		return "Shoe_Not_Found";
	}
    
}