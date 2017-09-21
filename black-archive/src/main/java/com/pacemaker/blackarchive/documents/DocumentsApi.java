package com.pacemaker.blackarchive.documents;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/documents")
public class DocumentsApi {

	private final DocumentRegistrar documentRegistrar;

	public DocumentsApi(DocumentRegistrar documentRegistrar) {
		this.documentRegistrar = documentRegistrar;
	}

	@GetMapping
	Collection<Document> all() {
		return this.documentRegistrar.all();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Document register(@RequestBody RegisterDocumentRequest request) {
		return this.documentRegistrar.register(request);
	}

}
