package hu.me.iit.webalk.dependency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServiceImplTest {

	@Mock Dependency dependency;
	
	@InjectMocks ServiceImpl service;
	
	@Test
	void testCalculate() {
		//given
		
		//when
		service.calculate();
		//then
		verify(dependency ,times(1)).helpNoParameterNoReturnValue();
	}
	@Test 
	void testreturn5() {
		//given
		final int FIVE = 5;
		//when
		int result = service.return5();
		//then
		assertEquals(FIVE, result);
	}
	@Test 
	void testdependencyReturnValueIsUsed() {
		//given
		final int FIVE = 5;
		when(dependency.helpNoParameterReturnValue()).thenReturn(FIVE);
		//when
		int result = service.callHelpAndUseReturnValue();
		//then
		verify(dependency ,times(1)).helpNoParameterReturnValue();
		assertEquals(FIVE, result);
	}
}
