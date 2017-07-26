package com.gril.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gril.prop.GrilProp;

@RestController
public class Boy {
	
	@Value("${kk}")
	private String kk;
	@Autowired
	private GrilProp grilprop;
	//@RequestMapping(value="/hello/{id}",method=RequestMethod.GET)
	@GetMapping(value="/hello")
	//public String say(@RequestParam("id") Integer myid){
	public String say(@RequestParam(value = "id",defaultValue = "55",required = false) Integer myid){
		return myid.toString() ;
	}
}
