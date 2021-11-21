package Trees;

public class VerifyPreorderSequenceinBinarySearchTree {
	int currentIndex = 0;
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) {
        	return false;
        }
        return verifyPreorderHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean verifyPreorderHelper(int[] preorder, int lowerBound, int upperBound) {
    	if(currentIndex == preorder.length) {
    		return true;
    	}
    	int val = preorder[currentIndex];
    	if(val > upperBound || val < lowerBound) {
    		return false;
    	}
    	currentIndex++;
    	
    	return verifyPreorderHelper(preorder, lowerBound, val) || verifyPreorderHelper(preorder, val, upperBound);
    }
}
