package com.pacemaker.blackarchive.inspections;

import org.springframework.stereotype.Service;

@Service
public class Alerter {
	public void notify(String recipient, String message) {
		System.out.println("NOTIFY");
		System.out.println(recipient);
		System.out.println(message);
	}
}
