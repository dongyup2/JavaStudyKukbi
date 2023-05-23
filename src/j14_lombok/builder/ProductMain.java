package j14_lombok.builder;

public class ProductMain {

	public static void main(String[] args) {
		Product product = Product.builder()
				.productCode(20220001)
				.productName("스타벅스")
				.productCategory("텀블러")
				.productDate("2023-04-10")
				.build();
		
		System.out.println(product);
	}

}
