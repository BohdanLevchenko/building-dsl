package com.pacemaker.blackarchive.documents;

import com.pacemaker.blackarchive.inspections.Inspector;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class DocumentRegistrar {
	private final DocumentRepository documentRepository;
	private final Inspector          inspector;

	public DocumentRegistrar(DocumentRepository documentRepository, Inspector inspector) {
		this.documentRepository = documentRepository;
		this.inspector = inspector;
	}

	public Collection<Document> all() {
		return this.documentRepository.findAll();
	}

	public Document register(RegisterDocumentRequest request) {
		final Document document = documentFromRequest(this.inspector.inspect(request));
		return this.documentRepository.save(document);
	}

	private Document documentFromRequest(RegisterDocumentRequest request) {
		final Document document = new Document();
		document.setTitle(request.getTitle());
		document.setContent(request.getContent());
		return document;
	}
}
