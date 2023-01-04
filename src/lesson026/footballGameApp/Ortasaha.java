package lesson026.footballGameApp;

import java.util.Random;

public class Ortasaha extends AktifFutbolcu {

	private int uzunTop;
	private int ilkDokunus;
	private int topSurme;
	private int uretkenlik;
	private int ozelYetenek;

	public Ortasaha(String adSoyad, int formaNo) {
		super(adSoyad, formaNo);
		this.uzunTop = rastgeleYetenekPuaniAta();
		this.ilkDokunus = rastgeleYetenekPuaniAta();
		this.topSurme = rastgeleYetenekPuaniAta();
		this.uretkenlik = rastgeleYetenekPuaniAta();
		this.ozelYetenek = rastgeleYetenekPuaniAta();
	}

	@Override
	public int rastgeleYetenekPuaniAta() {
		Random random = new Random();
		return random.nextInt(60, 101);
	}

	public int getUzunTop() {
		return uzunTop;
	}

	public void setUzunTop(int uzunTop) {
		this.uzunTop = uzunTop;
	}

	public int getIlkDokunus() {
		return ilkDokunus;
	}

	public void setIlkDokunus(int ilkDokunus) {
		this.ilkDokunus = ilkDokunus;
	}

	public int getTopSurme() {
		return topSurme;
	}

	public void setTopSurme(int topSurme) {
		this.topSurme = topSurme;
	}

	public int getUretkenlik() {
		return uretkenlik;
	}

	public void setUretkenlik(int uretkenlik) {
		this.uretkenlik = uretkenlik;
	}

	public int getOzelYetenek() {
		return ozelYetenek;
	}

	public void setOzelYetenek(int ozelYetenek) {
		this.ozelYetenek = ozelYetenek;
	}

	@Override
	public String toString() {
		return "Ortasaha [uzunTop=" + uzunTop + ", ilkDokunus=" + ilkDokunus + ", topSurme=" + topSurme
				+ ", uretkenlik=" + uretkenlik + ", ozelYetenek=" + ozelYetenek + ", getAdSoyad()=" + getAdSoyad()
				+ ", getFormaNo()=" + getFormaNo() + ", getDayanıklılık()=" + getDayanıklılık() + ", getHız()="
				+ getHız() + ", getPas()=" + getPas() + ", getSut()=" + getSut() + ", getYetenek()=" + getYetenek()
				+ ", getKararlılık()=" + getKararlılık() + ", getDogalForm()=" + getDogalForm() + ", getSans()="
				+ getSans() + "]";
	}

	@Override
	public int pasSkor() {
		Random random = new Random();
		int bonus = random.nextInt(1, 8);

		return (int) (getPas() * 0.2 + getYetenek() * 0.2 + ozelYetenek * 0.2 + getDayanıklılık() * 0.1
				+ getDogalForm() * 0.1 + getSans() * 0.1 + bonus);

	}

	public int golSkor(int kurtaris) {
		/*
		 *
		 * Bonus= 1 ile 6 arasında rastgele bir sayı * dogalForm*0.075 Kurtarış=karşı
		 * takım kalecisinden gelen kurtarış skor değeri.
		 * yetenek*0.2+ozelYetenek*0.2+sut*0.2+ilkDokunus*0.1+kararlilik*0.1+sans*0.1+
		 * dogalForm*0.1+bonus-kurtarış
		 *
		 *
		 *
		 */
		Random random = new Random();
		double bonus = (random.nextDouble(1, 6) * getDogalForm() * 0.075);

		return (int) (getYetenek() * 0.2 + ozelYetenek * 0.2 + getSut() * 0.2 + +ilkDokunus * 0.1
				+ getKararlılık() * 0.1 + getSans() * 0.1 + getDogalForm() * 0.1 + bonus - kurtaris);
	}

}
