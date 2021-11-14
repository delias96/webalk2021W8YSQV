package hu.me.iit.singleton;

import org.springframework.stereotype.Component;

@Component
public class DependencyImp implements Dependency {
	@Override
	public void helpNoParameterNoReturnValue() {
		
	}

	@Override
	public int helpNoParameterReturnValue() {
		return 45;
	}

	@Override
	public void helpWithParameterNoReturnValue(int a) {
		
		
	}

	@Override
	public String important(String text) {
		return text;
		
	}
}
