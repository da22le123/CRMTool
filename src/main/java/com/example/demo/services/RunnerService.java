package com.example.demo.services;

import com.example.demo.model.Runner;
import com.example.demo.repos.RunnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class RunnerService {

    @Autowired
    private RunnerRepository runnerRepository;

    @Transactional
    public String createRunner(Runner runner){
        try {
            if (!runnerRepository.existsByEmail(runner.getEmail())){
                Integer maxId = runnerRepository.findMaxId();
                int newId = (maxId == null ? 100000 : maxId + 1);
                runner.setId(newId);
                runnerRepository.save(runner);
                return "Runner record created successfully with ID: " + newId + ".";
            } else {
                return "Runner already exists in the database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Runner> readRunners(){
        return runnerRepository.findAll();
    }

    @Transactional
    public String updateRunner(Runner runner){
        if (runnerRepository.existsById(runner.getId())){
            try {
                List<Runner> runners = runnerRepository.findRunnersById(runner.getId());
                runners.stream().forEach(s -> {
                    Runner runnerToBeUpdate = runnerRepository.findById((s.getId())).get();
                    runnerToBeUpdate.setName(runner.getName());
                    runnerToBeUpdate.setAddress(runner.getAddress());
                    runnerToBeUpdate.setCity(runner.getCity());
                    runnerToBeUpdate.setCountry(runner.getCountry());
                    runnerToBeUpdate.setPostalCode(runner.getPostalCode());
                    runnerToBeUpdate.setPhoneNumber(runner.getPhoneNumber());
                    runnerToBeUpdate.setEmail(runner.getEmail());
                    runnerToBeUpdate.setRegistrationFee(runner.getRegistrationFee());
                    runnerRepository.save(runnerToBeUpdate);
                });
                return "Runner record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Student does not exists in the database.";
        }
    }

    @Transactional
    public String deleteRunner(Runner runner){
        if (runnerRepository.existsByEmail(runner.getEmail())){
            try {
                List<Runner> students = runnerRepository.findByEmail(runner.getEmail());
                students.stream().forEach(s -> {
                    runnerRepository.delete(s);
                });
                return "Student record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Student does not exist";
        }
    }
}
