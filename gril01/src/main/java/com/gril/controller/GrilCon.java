package com.gril.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gril.entity.Gril;
import com.gril.inter.IGril;

@RestController
public class GrilCon {
	@Autowired
	private IGril grilImpl;
	//查找所有女人
	@GetMapping(value="/gril")
	public List<Gril> getGrilList(){
		List<Gril> grilList = grilImpl.findAll();
		return grilList;
	}
	//新增
	@PostMapping(value="/gril")
	public Gril addGril(@Valid Gril gril,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			System.out.println(bindingResult.getFieldError().getDefaultMessage());
			return null;
		}
		gril.setAge(gril.getAge());
		gril.setCup(gril.getCup());
		return grilImpl.save(gril);
	}
	//修改
	@PutMapping(value="/gril/{id}")
	public Gril updataGril(@PathVariable("id") Integer id,@RequestParam(value="cup",required=true) String cup,
			@RequestParam(value="age",required=true) Integer age){
		Gril gril = new Gril();
		gril.setAge(age);
		gril.setCup(cup);
		gril.setId(id);
		return grilImpl.save(gril);
	}
	//删除
	@DeleteMapping(value="/gril/{id}")
	public void deleteGril(@PathVariable("id") Integer id){
		 grilImpl.delete(id);
	}
	//根据id返回
	@GetMapping(value="/gril/{id}")
	public Gril getGril(@PathVariable("id") Integer id){
		return grilImpl.findOne(id);
	}
}
