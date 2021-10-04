package hu.me.iit.webalk.first;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@GetMapping(path="/gyoker", produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	responseDto gyoker() {
		responseDto responseDto = new responseDto();
		responseDto.setId(123);
		responseDto.setMessage("hello");
		return responseDto;
	}
	
}
