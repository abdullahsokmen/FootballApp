package lesson026.footballGameApp;

import java.util.Random;

public abstract class Futbolcu {// abstract yapmamızın sebebi futbolcu newlemicez soyutlamak için

	private String adSoyad;
	private int formaNo;
	private int dayanıklılık;
	private int hiz;
	private int pas;
	private int sut;
	private int yetenek;
	private int kararlılık;
	private int dogalForm;
	private int sans;

//
	public Futbolcu(String adSoyad, int formaNo) {
		this.formaNo = formaNo;
		this.adSoyad = adSoyad;
		this.dayanıklılık = rastgeleYetenekPuaniAta();
		this.hiz = rastgeleYetenekPuaniAta();
		this.pas = rastgeleYetenekPuaniAta();
		this.sut = rastgeleYetenekPuaniAta();
		this.yetenek = rastgeleYetenekPuaniAta();
		this.kararlılık = rastgeleYetenekPuaniAta();
		this.dogalForm = rastgeleYetenekPuaniAta();
		this.sans = rastgeleYetenekPuaniAta();

	}

	public int rastgeleYetenekPuaniAta() {
		Random random = new Random();
		return random.nextInt(50, 101);
	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public int getFormaNo() {
		return formaNo;
	}

	public void setFormaNo(int formaNo) {
		this.formaNo = formaNo;
	}

	public int getDayanıklılık() {
		return dayanıklılık;
	}

	public void setDayanıklılık(int dayanıklılık) {
		this.dayanıklılık = dayanıklılık;
	}

	public int getHız() {
		return hiz;
	}

	public void setHız(int hız) {
		this.hiz = hız;
	}

	public int getPas() {
		return pas;
	}

	public void setPas(int pas) {
		this.pas = pas;
	}

	public int getSut() {
		return sut;
	}

	public void setSut(int sut) {
		this.sut = sut;
	}

	public int getYetenek() {
		return yetenek;
	}

	public void setYetenek(int yetenek) {
		this.yetenek = yetenek;
	}

	public int getKararlılık() {
		return kararlılık;
	}

	public void setKararlılık(int kararlılık) {
		this.kararlılık = kararlılık;
	}

	public int getDogalForm() {
		return dogalForm;
	}

	public void setDogalForm(int dogalForm) {
		this.dogalForm = dogalForm;
	}

	public int getSans() {
		return sans;
	}

	public void setSans(int sans) {
		this.sans = sans;
	}

	@Override
	public String toString() {
		return "Futbolcu [adSoyad=" + adSoyad + ", formaNo=" + formaNo + ", dayanıklılık=" + dayanıklılık + ", hız="
				+ hiz + ", pas=" + pas + ", sut=" + sut + ", yetenek=" + yetenek + ", kararlılık=" + kararlılık
				+ ", dogalForm=" + dogalForm + ", sans=" + sans + "]";
	}

}
