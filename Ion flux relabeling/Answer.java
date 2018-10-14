import java.util.Arrays;



public class Answer {

	public static void main(String[] args) {
		int[] q=new int[] {19, 14, 28};
		int h=5;

		System.out.println(Arrays.toString(answer(h,q)));
	}

    public static int[] answer(int h, int[] q) {
    	int n=q.length;
    	int[] res=new int[n];
    	int head=(int)(Math.pow(2, h)-1);
    	for(int i=0;i<n;i++) {

    		if(q[i]==head) {
    			res[i]=-1;
    		} else {
    			res[i]=find(head,(head-1)/2,q[i]);
    		}

    	}
    	return res;


    }

    public static int find(int head, int diff, int target) {
    	//Difference between left node and right node is always 2^(l)-1, with l being height of the child node
    	int right=head-1;
    	int left=right-diff;
    	if(target==left||target==right) {
    		return head;
    	} else if(target<left) {
    		return find(left,diff/2,target);
    	} else {
    		return find(right,diff/2,target);
    	}
    }
}
