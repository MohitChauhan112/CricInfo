package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entities.Match;
import com.demo.services.CricketService;

@Controller
@RequestMapping("/cricket")
public class CricketController {

	@Autowired
	private CricketService cricketService;

	public CricketController(CricketService cricketService) {
		this.cricketService = cricketService;
	}

	// api for getting live matches
	@GetMapping("/live")
	public String getLiveMatchScores(Model model) {
		System.out.println("getting live match");
		List<Match> liveMatches = cricketService.getLiveMatchScores();
		model.addAttribute("liveMatches", liveMatches);
		return "matches";

	}

	@GetMapping("/complete-matches")
	public String getCompletedMatches(Model model) {

		List<Match> allMatches = cricketService.getCompletedMatches();
		model.addAttribute("AllMatches", allMatches);

		return "all_matches";
	}

}
