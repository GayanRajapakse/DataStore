package controllers;

import org.springframework.web.bind.annotation.RestController;

import service.DataService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class DataController {
    private DataService dataService = null;
    
    public DataController() {
    	dataService = new DataService();
	}
    
    @RequestMapping(value="/insert", method=RequestMethod.GET)
    public String index(@RequestParam(value="user", required=true) String user,
    		@RequestParam(value="title", required=true) String title,
    		@RequestParam(value="content", required=false) String content) {
		dataService.insertData(user, title, content);
        return "success";
    }
    
}
