package com.spring.pointcut;

public class BehaviorImpl implements Behavior {
	
	
	
	@Override
	public void 잠자기() {
		System.out.println("피곤해 피곤해.. 오늘은 너무 너무 피곤해.");
	}

	@Override
	public void 공부하기() {
		System.out.println("不狂不及(불광불급)");
	}

	@Override
	public void 밥먹기() {
		System.out.println("점심은 잘임's에서 직화제육덮밥 먹어야지~");
	}

	@Override
	public void 데이트() {
		System.out.println("날이 좀더 Spring해지면 하는 걸로..");
	}

	@Override
	public void 운동() {
		System.out.println("하고싶은데.. 시간이 없네요..ㅠ");
	}

	@Override
	public void 놀기() {
		System.out.println("다음기회에.");
	}

	@Override
	public void 정신수양() {
		System.out.println("이너피스.");
	}

}
