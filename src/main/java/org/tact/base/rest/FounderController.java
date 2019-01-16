package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tact.base.jpa.domain.FounderMeter;
import org.tact.base.respository.FounderMeterRepository;

@RestController
@RequestMapping(value = "/founder-meter")
public class FounderController {
	
	
	@Autowired
    private FounderMeterRepository ffRepository;
	
	/**
	 * 
	 * @return
	 * 
	 * possible urls:
	 * 		/founder-meter
	 * 		http://localhost:1878/founder-meter
	 */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public <T> T listUsers() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        map.put("five", "six");
        map.put("seven", "eight");
        
        return (T) map;
    }
    
    /**
     * 
     * @param liLink
     * @return
     * 
     * possible urls:
     * 		/by/li-link/jpa
	 * 		/founder-meter/by/li-link/jpa
	 * 		http://localhost:1878/founder-meter/by/li-link/jpa
	 * 
     */
    @GetMapping(value = "/by/li-link/jpa")
    public <T> T getFFounderByLinkedInLinkJPA(
    		@RequestParam(value = "li_link")String liLink) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        FounderMeter fFounder = ffRepository.findByLinkedinLink(liLink);
        
        map.put("li_link", liLink);
        map.put("city", fFounder);
        
        return (T) map;
    }
    
    /**
     * 
     * @return
     * 
     * possible urls:
     * 		/get/all/jpa
	 * 		/founder-meter/get/all/jpa
	 * 		http://localhost:1878/founder-meter/get/all/jpa
     */
    @GetMapping(value = "/get/all/jpa")
    public <T> T getAllFoundersJPA(
    		) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        List<FounderMeter> fFounderList = ffRepository.findAll();
        
        map.put("founders", fFounderList);        
        
        return (T) map;
    }    
}
