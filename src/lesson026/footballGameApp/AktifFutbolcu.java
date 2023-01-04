package lesson026.footballGameApp;

public abstract class AktifFutbolcu extends Futbolcu {

	public AktifFutbolcu(String adSoyad, int formaNo) {
		super(adSoyad, formaNo);
		// TODO Auto-generated constructor stub
	}
//

	public boolean pasVer() {
		int pasSkor = pasSkor();

		if (pasSkor() > 65) {
			System.out.println("Pas başarılı");
			return true;
		} else {
			System.err.println("Pas Başarısız!");
			return false;
		}
	}

	public abstract int pasSkor();// abstract sınıfın govdesi olmaz-implement ilede yapılırdı bu soru

	public abstract int golSkor(int kurtaris);

	public boolean golVurusu(int kurtaris) {
		int golSkor = golSkor(kurtaris);

		if (golSkor > 68) {
			System.out.println("GOOOOOOL!!!!!!!!");
			return true;
		} else {
			System.err.println("GOL ŞANSI KAÇTI!!");
			return false;
		}
	}
}
