package task;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class Bank {
	private int money;
	private int number;
	private String name;
	private String username;
	private String password;
	private String email;

	// 입금
	public void dePosit(int money) { // 매개변수로 money 를 받고 money에 값을 저장함
		this.money += money;
	}
	
	// 출금
	public void withDraw(int money) {
		if (this.money < money) {
			System.out.println("출금할 잔액이 부족합니다.");
		} else {
			this.money -= money;
		}
	}
	
	
}
