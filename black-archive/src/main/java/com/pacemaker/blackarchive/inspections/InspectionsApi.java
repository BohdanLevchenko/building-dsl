package com.pacemaker.blackarchive.inspections;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inspections")
public class InspectionsApi {
	private final Inspector inspector;

	public InspectionsApi(Inspector inspector) {
		this.inspector = inspector;
	}

	@PostMapping
	void apply(@RequestBody String text) {
		inspector.apply(text);
	}
}
