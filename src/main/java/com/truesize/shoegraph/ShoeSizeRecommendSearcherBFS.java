package com.truesize.shoegraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.truesize.AccountService;
import com.truesize.OwnedShoe;
import com.truesize.shoegraph.ShoeSearcher;


public class ShoeSizeRecommendSearcherBFS implements ShoeSearcher{

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

		String usersShoe = ShoeNode.generateUniqueCode(shoe.getModel(),shoe.getBrand(),shoe.getSex());
		
		Queue<ShoeCodeWithDistance> bfsQueue = new LinkedList<ShoeCodeWithDistance>();
		HashSet<String> visitedShoes = new HashSet(); 

		bfsQueue.add(new ShoeCodeWithDistance(usersShoe, 0.0));

		while(!bfsQueue.isEmpty()) {
			ShoeCodeWithDistance currentShoeInfo = bfsQueue.remove();
			visitedShoes.add(currentShoeInfo.shoeCode);

			if(currentShoeInfo.shoeCode.equals(desiredShoeCode)) {
				//found shoe
				return Double.toString(shoe.getSize() + currentShoeInfo.sizeDiff);
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