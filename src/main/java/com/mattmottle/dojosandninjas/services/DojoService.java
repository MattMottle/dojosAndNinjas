package com.mattmottle.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattmottle.dojosandninjas.models.Dojo;
import com.mattmottle.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}

	// Create a dojo
	public Dojo createDojo(Dojo newDojo) {
		return dojoRepository.save(newDojo);
	}
	
	// Read all dojos
	public List<Dojo> readAllDojos() {
		return dojoRepository.findAll();
	}
	// Read one person
	public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
}
