package com.truesize.shoegraph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;


public class ShoeSizeRecommendSearcherSmartBFS extends ShoeSizeRecommendSearcherBFS{

	public void addToBfsQueue(Queue<ShoeCodeWithDistance> bfsQueue, ShoeCodeWithDistance currentShoeInfo, 
							  HashSet<String> visitedShoes, AllShoeRepository allShoeRepository){

		ShoeNode currentNode = allShoeRepository.findByUniqueShoeCode(currentShoeInfo.getShoeCode());

		//sort the edges by higher to lower multiplicity
		List<DirectedShoeEdge> sortedEdges = currentNode.getEdges();
		sortedEdges.sort(new ShoeEdgeComparator());
		
		//Add to the bfs queue in the sorted order
		for(DirectedShoeEdge e : sortedEdges) {
			String edgeAsString = e.endShoeNode.getUniqueShoeCode();
			if(!visitedShoes.contains(edgeAsString)){
				double sizeDiffToEdge = currentNode.getImmediateSizeDiff(edgeAsString);
				double sizeDiff = currentShoeInfo.getSizeDiff() + sizeDiffToEdge; 
				bfsQueue.add(new ShoeCodeWithDistance(edgeAsString, sizeDiff));
			}
		}
	}
    
    class ShoeEdgeComparator implements Comparator<DirectedShoeEdge> {
        @Override
        public int compare(DirectedShoeEdge a, DirectedShoeEdge b) {
            return ((Integer) a.getConnectionMultiplicity()).compareTo(((Integer) b.getConnectionMultiplicity()));
        }
    }
}