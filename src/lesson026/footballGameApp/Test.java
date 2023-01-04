package lesson026.footballGameApp;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		Takim takim1 = new Takim("Fransa");// isimler örnek olarak verilmiştir
		Takim takim2 = new Takim("Arjantin");
		List<Takim> takimlar = new ArrayList<>();
		takimlar.add(takim1);
		takimlar.add(takim2);

		Mac mac = new Mac(60000, takimlar);
		mac.mac();
	}

}
