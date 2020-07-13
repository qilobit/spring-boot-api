package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import models.Headphone;
import repository.HeadphoneRepository;

@RestController
public class HeadphoneController {
	
	@Autowired
	private HeadphoneRepository repository;


	  @GetMapping("/headphones")
	  List<Headphone> all() {
	    return repository.findAll();
	  }

	  @PostMapping("/headphones")
	  Headphone newEmployee(@RequestBody Headphone newHeadphone) {
	    return repository.save(newHeadphone);
	  }
	  
	  @GetMapping("/headphones/{id}")
	  Headphone one(@PathVariable Long id) {

	    return repository.findById(id)
	      .orElseThrow(() -> new HeadphoneNotFoundException(id));
	  }

	  @PutMapping("/headphones/{id}")
	  Headphone replaceEmployee(@RequestBody Headphone newHeadphone, @PathVariable Long id) {

	    return repository.findById(id)
	      .map(headphone -> {
	    	  headphone.setAsin(newHeadphone.getAsin());
	        return repository.save(headphone);
	      })
	      .orElseGet(() -> {
	    	  newHeadphone.setId(id);
	        return repository.save(newHeadphone);
	      });
	  }

	  @DeleteMapping("/headphones/{id}")
	  void deleteHeadphone(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
	  
}
