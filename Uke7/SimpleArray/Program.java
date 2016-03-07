import java.util.Iterator;

public class Program {

	public static void main(String[] args) {

		SimpleArrayList<String> sal = new SimpleArrayList<String>();

		sal.leggTil("hi");
		sal.leggTil("ha");
		sal.leggTil("ho");
		sal.leggTil("hallo");
		sal.leggTil("hei");

		System.out.println();

		Iterator<String> it = sal.iterator();

		while (it.hasNext()){
			String hei = it.next();
			if (!hei.equals("hei")) it.remove();
		}

		for (String s : sal){
			System.out.println(s);
		}

	}
}