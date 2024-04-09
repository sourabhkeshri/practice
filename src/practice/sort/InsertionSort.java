package practice.sort;

public class InsertionSort {
	public static void main(String[] args) {
		int[] a = { 5, 2, 1, 89, 7, 555, 5 };
		inertionsort(a,a.length);
		for(int aa:a) {
			System.out.println(aa);
		}

	}

	private static void inertionsort(int[] a, int n) {
		for(int i=1;i<n;i++) {
			int key=a[i];
			int j;
			for(j=i-1;j>=0 && key<a[j];j--) {
				a[j+1]=a[j];
			}
			a[j+1]=key;
		}
	}
}
