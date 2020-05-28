package com.truesize.shoegraph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShoeSizeRecommendSearcherSmartBFS implements ShoeSearcher{
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