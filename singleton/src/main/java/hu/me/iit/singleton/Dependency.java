package hu.me.iit.singleton;


public interface Dependency {
	void helpNoParameterNoReturnValue();
	int helpNoParameterReturnValue();
	void helpWithParameterNoReturnValue(int a);
	String important(String text);
}
