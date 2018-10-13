import java.util.Arrays;


/**
 *
 */

/**
 * @author beethovenzhang
 *
 */
public class Answer {
	public static void main(String[] args) {
		System.out.println(nextID("210022",3));
		System.out.println(answer("123456",7));
	}

	public static int answer(String n, int b) {
		String n0=nextID(n,b);
		return findCycle(n0,b);
        // Your code goes here.

    }

	//find the next minion ID
	public static String nextID(String n, int b) {
		int l=n.length();
		char[] a=n.toCharArray();
		Arrays.sort(a);
		int y=Integer.parseInt(new String(a),b);
		for(int i=0;i<l/2;i++) {
			char temp=a[i];
			a[i]=a[l-1-i];
			a[l-1-i]=temp;
		}
		int x=Integer.parseInt(new String(a),b);
		String z=Integer.toString(x-y,b);
		if(z.length()==l) {
			return z;
		} else {
			char[] c=new char[l-z.length()];
			Arrays.fill(c, '0');
			z=new String(c)+z;
			return z;
		}


	}

	//find the cycle length
	public static int findCycle(String n0,int b) {
		String slow=nextID(n0,b);
		String fast=nextID(slow,b);
		//The fast runner and the slow runner will eventually meet inside the cycle
		while(!slow.equals(fast)) {
			slow=nextID(slow,b);
			fast=nextID(nextID(fast,b),b);
		}

		int res=1;
		fast=nextID(slow,b);
		while(!slow.equals(fast)) {
			fast=nextID(fast,b);
			res++;
		}
		return res;
	}

}
