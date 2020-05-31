package com.truesize.shoegraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.truesize.AccountService;
import com.truesize.OwnedShoe;
import com.truesize.shoegraph.DirectedShoeEdge;
import com.truesize.shoegraph.ShoeSearcher;

public class ShoeSizeRecommendSearcherSmartBFS implements ShoeSearcher{

	
	class ShoeCodeWithDistance{
		public String shoeCode;
		public double sizeDiff;
		public ShoeCodeWithDistance(String shoeCode, double sizeDiff){
			this.shoeCode = shoeCode;
			this.sizeDiff = sizeDiff;
		}
	}
	private Double getDoubleListAverage(List<Double> nums) {
		Double total = 0.0;
		for(Double num : nums) {
			total += num;
		}
		return total/nums.size();
	}
	public String getSizeRecc(String desiredShoeCode, AllShoeRepository allShoeRepository, AccountService ac){
		List<Double> sizeReccs = new ArrayList<>();
		if(ac == null) {
			return "account service is null";
		}
		if(ac.getProfile() == null) {
			return "Not_Logged_In";
		}
		List<OwnedShoe> ownedShoes = ac.getProfile().getOwnedShoes();

		if(ownedShoes.size() == 0) {
			return "No_Owned_Shoes";
		}
		
		//get a size reccomendation based on each owned shoe
		for(OwnedShoe shoe : ownedShoes) {
			String sizeRecc = getSizeReccFromShoe(desiredShoeCode, allShoeRepository, shoe);
			if(sizeRecc != "Shoe_Not_Found") {
				Double sizeReccAsNum = Double.parseDouble(sizeRecc);
				sizeReccs.add(sizeReccAsNum);
			}
		}
		
		//return an average of the found recommendations
		if(sizeReccs.size() == 0) {
			return "Shoe_Not_Found";
		}
		else {
			return getDoubleListAverage(sizeReccs).toString();
		}
	}
	
	private String getSizeReccFromShoe(String desiredShoeCode, AllShoeRepository allShoeRepository, OwnedShoe shoe) {
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
            List<DirectedShoeEdge> edges = currentNode.getEdges();
            edges.sort(new ShoeEdgeComparator());

            for(DirectedShoeEdge e : edges) {
                String edgeAsString = e.endShoeNode.uniqueShoeCode;
                if(!visitedShoes.contains(edgeAsString)){
					double sizeDiffToEdge = currentNode.getImmediateSizeDiff(edgeAsString);
					double sizeDiff = currentShoeInfo.sizeDiff + sizeDiffToEdge; 
					bfsQueue.add(new ShoeCodeWithDistance(edgeAsString, sizeDiff));
				}
            }
		}

		return "Shoe_Not_Found";
    }
    
    class ShoeEdgeComparator implements Comparator<DirectedShoeEdge> {
        @Override
        public int compare(DirectedShoeEdge a, DirectedShoeEdge b) {
            return ((Integer) a.connectionMultiplicity).compareTo(((Integer) b.connectionMultiplicity));
        }
    }
}