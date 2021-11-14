package hu.me.iit.singleton;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class ServiceImp implements Service {

	private final Dependency dependency;
	private String value;
	
	@Value("${sajat-cucc}")
	public void setValue(String value) {
		this.value=value;
	}
	
	public ServiceImp(Dependency dependency) {
		this.value = Double.toString(Math.random());
		this.dependency = dependency;
	}

	@Override
	public String getValue() {
		return value;
	}
}
