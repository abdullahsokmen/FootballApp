package lesson026.footballGameApp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Mac {
	long sure;
	List<Takim> takimlar;
	int[] macSkoru;
	Queue<AktifFutbolcu> pasAtacakFutbolcular = new LinkedList<>();

	public Mac() { // s

		this.takimlar = new ArrayList<>();
		macSkoru = new int[2];
		takimlar.add(new Takim("Ev Sahibi"));
		takimlar.add(new Takim("Deplasman"));
	}

	public Mac(int sure, List<Takim> takimlar) {
		this.takimlar = takimlar;
		this.sure = setSure(sure);
		macSkoru = new int[2];
	}

	public long getSure() {
		return sure;
	}

	public List<Takim> getTakimlar() {
		return takimlar;
	}

	public long setSure(long sure) {

		return this.sure = sure + System.currentTimeMillis();

	}

	public void setTakimlar(List<Takim> takimlar) {
		this.takimlar = takimlar;
	}

	public Takim takimDegistir(Takim takim) {
		int teamIndex = takimlar.indexOf(takim);// 0-1

		if (teamIndex == 1) {
			teamIndex = 0;
		} else {
			teamIndex = 1;
		}
		return takimlar.get(teamIndex);

	}

	public Takim takimDegistir2(Takim takim) {

		if (takimlar.get(0).equals(takim)) {
			return takimlar.get(1);
		} else {
			return takimlar.get(0);
		}

	}

	public Queue<AktifFutbolcu> kuyrugaOyuncuSec(Takim takim) {
		int index = passKontrol(12);
		for (int i = 0; i < 4; i++) {
			pasAtacakFutbolcular.offer(takim.getFutbolcular().get(index));
			index = passKontrol(index);

		}
		return pasAtacakFutbolcular;
	}

	public void oyna(Takim takim) throws InterruptedException {
		int index = passKontrol(12);
		for (int i = 0; i < 3; i++) {
			List<AktifFutbolcu> futbolcular = takim.getFutbolcular();
			if (futbolcular.get(index).pasVer()) {
				int pasAlacakOyuncuIndex = passKontrol(index);
				System.out.println(takim.getAd() + " adlı takımdan " + futbolcular.get(index).getFormaNo()
						+ " nolu oyuncu " + futbolcular.get(pasAlacakOyuncuIndex).getFormaNo() + " pas atıyor");
				index = pasAlacakOyuncuIndex;
				Thread.sleep(1500);

			} else {
				System.out.println(takim.getAd() + " adlı takımdan " + futbolcular.get(index).getFormaNo()
						+ " nolu oyuncunun pası başarısız oldu !!! ");
				takim = takimDegistir(takim);
				i = -1;
				index = passKontrol(12);
				Thread.sleep(1500);
			}
		}

		golVurusu(takim.getFutbolcular().get(index), takim);
		takim = takimDegistir(takim);
	}

	public void golVurusu(AktifFutbolcu futbolcu, Takim takim) throws InterruptedException {
		Kaleci kaleci = takimDegistir(takim).getKaleci();
		System.out.println("Kaleci topa uzanıyor .......");
		Thread.sleep(1500);
		if (futbolcu.golVurusu(kaleci.kurtarisSkor())) {
			System.out.println("Goll goll golll");
			int takimIndex = takimlar.indexOf(takim);
			macSkoru[takimIndex] += 1;
			System.out.println(futbolcu.getFormaNo() + " nolu futbolcu golu atıyor...!!!");
			skorGoster();
		} else {
			System.out.println(futbolcu.getFormaNo() + " nolu futbolcu golu kaçırdı...!!!");
		}

	}

	public void skorGoster() {

		System.out.println(" Mac skoru");
		System.out.println("================================");
		System.out.println(
				takimlar.get(0).getAd() + ": " + macSkoru[0] + " - " + takimlar.get(1).getAd() + ": " + macSkoru[1]);

	}

	public int passKontrol(int index) {
		Random random = new Random();
		int oyuncuIndex = random.nextInt(10);

		while (index == oyuncuIndex) {
			oyuncuIndex = random.nextInt(10);
		}

		return oyuncuIndex;
	}

	public Takim yaziTura() {
		Random random = new Random();
		int index = random.nextInt(2);

		return takimlar.get(index);
	}

	public void mac() throws InterruptedException {

		System.out.println("Yazı tura atılıyor ve maça ....");
		Thread.sleep(1000);
		Takim takim = yaziTura();
		System.out.println(takim.getAd() + " takim başlıyor ....");
		while (sure > System.currentTimeMillis()) {
			takim = takimDegistir(takim);
			oyna(takim);
			System.out.println((sure - System.currentTimeMillis()) / 1000 + " saniye kaldı");
		}
		System.out.println("----------------------");
		System.out.println("Maç Sona erdi!");
		skorGoster();
	}

}
