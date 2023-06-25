package collection;


public class Ex05 {
	public static void main(String[] args) throws InterruptedException{
		// throw(드로우즈) : callee에서 발생한 예외를 caller에게 전가시킨다
		// 드로우즈가 없으면 try,catch를 각각 써줘야 한다
		// 예외를 무한정 전가시키기 위함이 아닌 하위코드에서 발생한 예외를 적절한 
		// 상위 단계에서 모아 일괄적으로 처리하고, 예외 처리의 효율설을 증대시키기 위한 문법
		
		// callee(콜리) : 호출 당하는 것(어디선가 호출하면 그 명령을 받고 해결)
		// caller(콜러) : 호출 하는 것 (명령을 어딘가로 전달함)
		
		for(int i = 5; i != -1; i++) {
			System.out.println(i);
			
			Thread.sleep(1000);
		}
		System.out.println("End");
		
		// try : 예외발생 가능성이 있는 것을 묶어두는 영역
		// catch : 예외가 발생했을때 어떻게 해결할 것인지의 방안을 담당하는 영역
		// finally : 예외에 상관없이 마무리 코드를 쓸때 사용(리컨보다 우선순위가 높다)
		// 그러므로 함수가 종료되도 finally(파이널리)는 실행된다
		
		// throw : 예외가 발생하면 to catch에 던진다
		// (예외가 발생하면 catch가 있는 곳으로 앞으로 던진다)
		// throws : 예외가 발생하면 to caller에 던진다
		// (나를 불러세워서 일을 시키는 콜러에게 예외를 뒤로 던진다)
		
		// 로그인 폼에 ;를 하게 만들면 안된다 (;는 반드시 예외처리 해줘야 함)
		// 이유 : SQL에 들어가면 인덱션이 된다(인덱션 : 코드 주입공격으로 간주함)
	} 
	
}
