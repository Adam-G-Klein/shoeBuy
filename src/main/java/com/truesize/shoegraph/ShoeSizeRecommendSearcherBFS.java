package com.truesize.shoegraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.truesize.AccountService;
import com.truesize.OwnedShoe;

public class ShoeSizeRecommendSearcherBFS implements ShoeSearcher{

	private String noShoeErrorMessage = "Shoe_Not_Found";
	
	class ShoeCodeWithDistance{
		private String shoeCode;
		private double sizeDiff;
		public ShoeCodeWithDistance(String shoeCode, double sizeDiff){
			this.shoeCode = shoeCode;
			this.sizeDiff = sizeDiff;
		}
		public String getShoeCode(){
			return shoeCode;
		}
		public double getSizeDiff(){
			return sizeDiff;
		}
	}

	public String getNoShoeError(){
		return noShoeErrorMessage;
	}
	public Double getDoubleListAverage(List<Double> nums) {
		if(nums.isEmpty()) {
			return null;
		}
		Double total = 0.0;
		for(Double num : nums) {
			total += num;
		}
		return total/nums.size();
	}

	//returns null on error
	public List<OwnedShoe> getOwnedShoes (AccountService ac) {
		if(ac == null || ac.getProfile() == null) {
			return Collections.emptyList();
		}
		return ac.getProfile().getOwnedShoes();
	}

	public List<Double> getListOfSizeReccs(List<OwnedShoe> ownedShoes, String desiredShoeCode, AllShoeRepository allShoeRepository) {
		List<Double> sizeReccs = new ArrayList<>();
		for(OwnedShoe shoe : ownedShoes) {
			String sizeRecc = getSizeReccFromShoe(desiredShoeCode, allShoeRepository, shoe);
			if(!sizeRecc.equals(getNoShoeError())) {
				Double sizeReccAsNum = Double.parseDouble(sizeRecc);
				sizeReccs.add(sizeReccAsNum);
			}
		}
		return sizeReccs;
	}
	public String getSizeRecc(String desiredShoeCode, AllShoeRepository allShoeRepository, AccountService ac){

		List<OwnedShoe> ownedShoes = getOwnedShoes(ac);

		if(ownedShoes.isEmpty()) {
			return "ERROR";
		}
		
		//get a size reccomendation based on each owned shoe
		List<Double> sizeReccs = getListOfSizeReccs(ownedShoes, desiredShoeCode, allShoeRepository);
		
		//return an average of the found recommendations
		if(sizeReccs.isEmpty()) {
			return getNoShoeError();
		}
		else {
			return getDoubleListAverage(sizeReccs).toString();
		}
	}

	public String getSizeReccFromShoe(String desiredShoeCode, AllShoeRepository allShoeRepository, OwnedShoe shoe) {

		String usersShoe = ShoeNode.generateUniqueCode(shoe.getShoeModel(),shoe.getShoeBrand(),shoe.getShoeSex());
		
		Queue<ShoeCodeWithDistance> bfsQueue = new LinkedList<>();
		HashSet<String> visitedShoes = new HashSet<>(); 

		bfsQueue.add(new ShoeCodeWithDistance(usersShoe, 0.0));

		while(!bfsQueue.isEmpty()) {
			ShoeCodeWithDistance currentShoeInfo = bfsQueue.remove();
			visitedShoes.add(currentShoeInfo.shoeCode);

			//shoe is found
			if(currentShoeInfo.shoeCode.equals(desiredShoeCode)) {
				return Double.toString(shoe.getShoeSize() + currentShoeInfo.getSizeDiff());
			}
			addToBfsQueue(bfsQueue, currentShoeInfo, visitedShoes, allShoeRepository);
		}

		return getNoShoeError();
	}

	public void addToBfsQueue(Queue<ShoeCodeWithDistance> bfsQueue, ShoeCodeWithDistance currentShoeInfo, 
							  Set<String> visitedShoes, AllShoeRepository allShoeRepository){

		ShoeNode currentNode = allShoeRepository.findByUniqueShoeCode(currentShoeInfo.getShoeCode());
		List<String> edges = currentNode.getEdgesAsShoeCodes();

		//Add edges to the bfs
		for(String edge : edges) {
			if(!visitedShoes.contains(edge)){
				double sizeDiffToEdge = currentNode.getImmediateSizeDiff(edge);
				double sizeDiff = currentShoeInfo.getSizeDiff() + sizeDiffToEdge; 
				bfsQueue.add(new ShoeCodeWithDistance(edge, sizeDiff));
			}
		}
	}
    
}