package com.pacemaker.blackarchive.inspections;

import com.pacemaker.blackarchive.documents.RegisterDocumentRequest;
import groovy.lang.*;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.ImportCustomizer;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class Inspector {

	private Script inspection;
	private final AutowireCapableBeanFactory beanFactory;

	public Inspector(AutowireCapableBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public void apply(String text) {
		final CompilerConfiguration cc = new CompilerConfiguration();

		cc.setScriptBaseClass(Inspection.class.getName());
		cc.addCompilationCustomizers(new ImportCustomizer().addImports(RegisterDocumentRequest.class.getName()));
		GroovyShell shell = new GroovyShell(cc);
		inspection = shell.parse(text);
		beanFactory.autowireBean(inspection);
	}

	public RegisterDocumentRequest inspect(RegisterDocumentRequest request) {
		final Binding binding = new Binding();
		binding.setVariable("request", request);

		inspection.setBinding(binding);
		inspection.run();
		return request;
	}
}
