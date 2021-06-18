package samp06;

public class VehicleImpl implements Vehicle {
	private String name, rider;
	public VehicleImpl(String name, String rider) {
		this.name=name;
		this.rider=rider;
	}
	public void ride() {
		System.out.println(name + "가 " + rider + "를 탄다");
	}
	
}
