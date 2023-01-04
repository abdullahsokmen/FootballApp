package lesson026.footballGameApp;

import java.util.Random;

public class Kaleci extends Futbolcu {

	private int kurtaris;

	public Kaleci(String adSoyad, int formaNo) {
		super(adSoyad, formaNo);
		this.kurtaris = rastgeleYetenekPuaniAta();

	}

	public int getKurtaris() {
		return kurtaris;
	}

	@Override
	public int rastgeleYetenekPuaniAta() {
		Random random = new Random();
		return random.nextInt(65, 101);
	}

	public void setKurtaris(int kurtaris) {
		this.kurtaris = kurtaris;
	}

	@Override
	public String toString() {
		return "Kaleci [kurtaris=" + kurtaris + ", getAdSoyad()=" + getAdSoyad() + ", getFormaNo()=" + getFormaNo()
				+ ", getDayanıklılık()=" + getDayanıklılık() + ", getHız()=" + getHız() + ", getPas()=" + getPas()
				+ ", getSut()=" + getSut() + ", getYetenek()=" + getYetenek() + ", getKararlılık()=" + getKararlılık()
				+ ", getDogalForm()=" + getDogalForm() + ", getSans()=" + getSans() + "]";
	}

	public int kurtarisSkor() {
		Random random = new Random();
		double bonus = random.nextDouble(1, 5) * getDogalForm() * 0.025;

		return (int) (kurtaris * 0.2 + getKararlılık() * 0.1 + bonus);
	}

}
