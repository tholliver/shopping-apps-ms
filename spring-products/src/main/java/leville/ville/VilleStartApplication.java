package leville.ville;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
public class VilleStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(VilleStartApplication.class, args);
	}

//	@GetMapping("/hi")
//	public GreetResponse greetings(@RequestParam("num") int num){
//		return new GreetResponse("Hey", num, "2/08/2023");
//	}
//	 record GreetResponse(String greet, int num, String birth){};
}
