package com.logesh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.logesh.model.Attempt;
import com.logesh.model.MultiplicationGenerator;
import com.logesh.model.MultiplicationResultAttempt;
import com.logesh.model.MultiplicationSolvedEvent;
import com.logesh.model.User;
import com.logesh.mulitiplication.sender.EventDispatcher;
import com.logesh.repository.AttemptRepository;
import com.logesh.repository.MultiplicationGeneratorRepository;
import com.logesh.repository.UserRepository;

@Service
public class MultiplicationGeneratorServiceImpl {
	@Autowired
	private MultiplicationGeneratorRepository repo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private AttemptRepository attemptRepo;

	@Autowired
	private EventDispatcher eventDispatcher;

	public MultiplicationGenerator generateTask() {
		int factorA = new Random().nextInt(10) + 1;
		int factorB = new Random().nextInt(10) + 1;
		int result = factorA * factorB;
		MultiplicationGenerator multiplicationTask = new MultiplicationGenerator(factorA, factorB, result);
		repo.save(multiplicationTask);
		return multiplicationTask;
	}

	public List<MultiplicationGenerator> getAllTasks() {
		// TODO Auto-generated method stub
		List<MultiplicationGenerator> tasks = new ArrayList<>();
		repo.findAll().forEach(tasks::add);
		return tasks;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveUserResponse(MultiplicationResultAttempt obj) {
		// TODO Auto-generated method stub
		User newUser = new User(obj.getUserName());
		// userRepo.save(newUser);
		Attempt attempt = new Attempt();
		attempt.setUsers(newUser);
		attempt.setUserValue(obj.getUserValue());
		MultiplicationGenerator multiplicationTask = repo.findById(obj.getMultiplicationId()).get();
		if (multiplicationTask == null) {
			System.out.println("Unable to find task...sorry!");
		}
		attempt.setMultiplicationTask(multiplicationTask);
		attempt.setCorrect(obj.getUserValue() == multiplicationTask.getResult());
		attemptRepo.save(attempt);
		System.out.println("Attempt saved! :)");

		// SEND EVENT TO MQ
		MultiplicationSolvedEvent event = new MultiplicationSolvedEvent();
		event.setAttemptId(attempt.getAttemptId());
		event.setCorrect(attempt.isCorrect());
		event.setMultiplicationId(multiplicationTask.getMultiplicationId());
		event.setUserId(newUser.getUserName());
		eventDispatcher.send(event);
		System.out.println("Event sent successfully :)");
	}

	public List<Attempt> getAllUserResponseByName(String name) {
		// TODO Auto-generated method stub
		List<Attempt> userAttempts = new ArrayList<>();
		attemptRepo.findByUsersUserName(name).forEach(userAttempts::add);
		return userAttempts;
	}

	public User getUserById(int id) {
		return userRepo.findById(id).get();
	}
}
