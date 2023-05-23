package Java_�젙�꽍_媛앹껜吏�쒕뀗.ch07;

import j12_�긽�냽.Animal;

class Tv{
	boolean power; // �쟾�썝�긽�깭(ON/OFF)
	int channel; // 梨꾨꼸
	
	void power() {
		power = !power;
	}
	void channelUp() {
		++channel;
	}
	void channelDown() {
		--channel;
	}
}
class SmartTv extends Tv{ // SmartTv�뒗 Tv�뿉 罹≪뀡(�옄留�)�쓣 蹂댁뿬二쇰뒗 湲곕뒫�쓣 異붽�
	boolean caption;	  // 罹≪뀡�긽�깭(on/off)
	void displayCaption(String text) {
		if(caption) {	  // 罹≪뀡 �긽�깭媛� on(true)�씪 �븣留� text瑜� 蹂댁뿬以��떎.
			System.out.println(text);
			}
		}
	}

public class Ex7_1 {
	
	public static void main(String[] args) {
		SmartTv stv = new SmartTv();
		stv.channel = 10;				//議곗긽 �겢�옒�뒪濡쒕��꽣 �긽�냽諛쏆� 硫ㅻ쾭
		stv.channelUp();				//議곗긽 �겢�옒�뒪濡쒕��꽣 �긽�냽諛쏆� 硫ㅻ쾭
		System.out.println(stv.channel);
		stv.displayCaption("Hello, World");
		stv.caption = true;				//罹≪뀡(�옄留�) 湲곕뒫�쓣耳좊떎
		stv.displayCaption("Hello, World");

	}

}
