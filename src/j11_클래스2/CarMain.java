package j11_클래스2;

public class CarMain {
	public static void main(String[]args) {
		String[] brands = {"KIA", "현대", "쌍용"};
		int[] age = {18, 22, 16};
		
		for(int i = 0; i < brands.length; i++) {
			System.out.println(i + 1 + "번 자동차 브랜드: " + brands[i]);
			System.out.println(i + 1 + "번 자동차 년식: " + age[i]);
		}
		CarBrand carBrand = new CarBrand();
		
		
		carBrand.setBrand("KIA");
		System.out.println(carBrand.getBrand());
	}
}
