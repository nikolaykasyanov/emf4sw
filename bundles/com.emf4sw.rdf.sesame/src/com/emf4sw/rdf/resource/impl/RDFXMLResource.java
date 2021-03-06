/*******************************************************************************
 * Copyright (c) 2011 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package com.emf4sw.rdf.resource.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFParseException;
import org.openrdf.rio.RDFParser;
import org.openrdf.rio.helpers.StatementCollector;
import org.openrdf.rio.rdfxml.RDFXMLParser;
import org.openrdf.rio.rdfxml.util.RDFXMLPrettyWriter;
import org.openrdf.sail.memory.MemoryStore;

import com.emf4sw.rdf.resource.RDFResource;
import com.emf4sw.rdf.sesame.RDFGraph2SesameGraph;
import com.emf4sw.rdf.sesame.RDFSesameReader;
import com.emf4sw.rdf.sesame.RDFSesameWriter;

/**
 * 
 * @author <a href="mailto:g.hillairet at gmail.com">Guillaume Hillairet</a>
 * @since 0.6.5
 */
public class RDFXMLResource extends SesameResourceImpl implements RDFResource {

	public RDFXMLResource() {
		super();
		writer = new RDFSesameWriter();
		reader = new RDFSesameReader(); 
	}
	
	public RDFXMLResource(URI uri) {
		super(uri);
		writer = new RDFSesameWriter();
		reader = new RDFSesameReader();
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		final ValueFactory valueFactory = new ValueFactoryImpl();
		final RDFParser aParser = new RDFXMLParser();
		final StatementCollector collector = new StatementCollector();
		aParser.setRDFHandler(collector);
		aParser.setValueFactory(valueFactory);
		try {
			aParser.parse(inputStream, "");
		} catch (RDFParseException e) {
			e.printStackTrace();
		} catch (RDFHandlerException e) {
			e.printStackTrace();
		}
		
		((RDFSesameReader)this.reader).read(collector, this);
	}
	
	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		final Repository repository = new SailRepository(new MemoryStore());
		
		try {
			repository.initialize();
			RepositoryConnection con = repository.getConnection();
			con.add(RDFGraph2SesameGraph.extract(this.getGraph()));
			try {
				org.openrdf.rio.RDFWriter aWriter = new RDFXMLPrettyWriter(outputStream);
				con.export(aWriter);
			} catch (RDFHandlerException e) {
				e.printStackTrace();
			} finally {
				con.close();
			}
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}
}
