package per.tmp.data.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class UIController {
	
	@Value("${myapp.restservice.url}")
	private String URL_AVG_PX;
	
	@RequestMapping(value="/welcome", method=RequestMethod.POST)
	public String showAvgPx(ModelMap model, @RequestParam int number) {
		String url = URL_AVG_PX + number;
		RestTemplate template = new RestTemplate();
		
		Double avgPx = template.getForObject(url, Double.class);
		
		String msg = "Avg Px of last " + number + " entries is " + avgPx;
		model.put("showMsg", msg);
		return "welcome";
	}
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model){
        return "welcome";
    }
}
