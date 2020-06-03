package com.truesize.shoegraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.truesize.AccountService;
import com.truesize.OwnedShoe;

public class ShoeSizeRecommendSearcherSmartBFS extends ShoeSizeRecommendSearcherBFS{

	public String getSizeRecc(String desiredShoeCode, AllShoeRepository allShoeRepository, AccountService ac){
		List<Double> sizeReccs = new ArrayList<>();
		if(ac == null) {
			return "account service is null";
		}
		if(ac.getProfile() == null) {
			return "Not_Logged_In";
		}
		List<OwnedShoe> ownedShoes = ac.getProfile().getOwnedShoes();

		if(ownedShoes.isEmpty()) {
			return "No_Owned_Shoes";
		}
		
		//get a size reccomendation based on each owned shoe
		for(OwnedShoe shoe : ownedShoes) {
			String sizeRecc = getSizeReccFromShoe(desiredShoeCode, allShoeRepository, shoe);
			if(sizeRecc != getNoShoeError()) {
				Double sizeReccAsNum = Double.parseDouble(sizeRecc);
				sizeReccs.add(sizeReccAsNum);
			}
		}
		
		//return an average of the found recommendations
		if(sizeReccs.isEmpty()) {
			return getNoShoeError();
		}
		else {
			return getDoubleListAverage(sizeReccs).toString();
		}
	}
	
	private String getSizeReccFromShoe(String desiredShoeCode, AllShoeRepository allShoeRepository, OwnedShoe shoe) {

		String usersShoe = ShoeNode.generateUniqueCode(shoe.getShoeModel(),shoe.getShoeBrand(),shoe.getShoeSex());

		Queue<ShoeCodeWithDistance> bfsQueue = new LinkedList<>();
		HashSet<String> visitedShoes = new HashSet<>(); 

		bfsQueue.add(new ShoeCodeWithDistance(usersShoe, 0.0));

		while(!bfsQueue.isEmpty()) {
			ShoeCodeWithDistance currentShoeInfo = bfsQueue.remove();
			visitedShoes.add(currentShoeInfo.getShoeCode());

			if(currentShoeInfo.getShoeCode().equals(desiredShoeCode)) {
				//found shoe
				return Double.toString(shoe.getShoeSize() + currentShoeInfo.getSizeDiff());
			}

			ShoeNode currentNode = allShoeRepository.findByUniqueShoeCode(currentShoeInfo.getShoeCode());
            List<DirectedShoeEdge> edges = currentNode.getEdges();
            edges.sort(new ShoeEdgeComparator());

            for(DirectedShoeEdge e : edges) {
                String edgeAsString = e.endShoeNode.getUniqueShoeCode();
                if(!visitedShoes.contains(edgeAsString)){
					double sizeDiffToEdge = currentNode.getImmediateSizeDiff(edgeAsString);
					double sizeDiff = currentShoeInfo.getSizeDiff() + sizeDiffToEdge; 
					bfsQueue.add(new ShoeCodeWithDistance(edgeAsString, sizeDiff));
				}
            }
		}

		return getNoShoeError();
    }
    
    class ShoeEdgeComparator implements Comparator<DirectedShoeEdge> {
        @Override
        public int compare(DirectedShoeEdge a, DirectedShoeEdge b) {
            return ((Integer) a.getConnectionMultiplicity()).compareTo(((Integer) b.getConnectionMultiplicity()));
        }
    }
}