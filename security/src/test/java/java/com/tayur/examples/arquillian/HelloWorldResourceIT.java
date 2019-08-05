/*******************************************************************************
 * *  * ////////////////////////////////////////////////////////////////////////
 *  *  * //
 *  *  * // Copyright (c) 2006-2016 Cigital Asia Pvt. Ltd.
 *  *  * // All Rights Reserved.
 *  *  * //
 *  *  * // NOTICE: All contents of this file are the intellectual property
 *  *  * // of Cigital Asia Pvt. Ltd., The contents should not
 *  *  * // be reused as a whole or partially. The reproduction of this
 *  *  * // content is strictly prohibited without prior written permission
 *  *  * // from Cigital Asia Pvt. Ltd.
 *  *  * //
 *  *  * ////////////////////////////////////////////////////////////////////////
 ******************************************************************************/
package com.tayur.examples.arquillian;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class HelloWorldResourceIT {

	@ArquillianResource
	private URL deploymentURL;

	private Client client = ClientBuilder.newClient();

	@Deployment(testable = true)
	public static WebArchive createDeployment() {

		// Import Maven runtime dependencies
		File[] files = Maven.resolver().loadPomFromFile("pom.xml").importCompileAndRuntimeDependencies()
				.importRuntimeAndTestDependencies().resolve().withTransitivity().asFile();

		// Create deploy file
		WebArchive archive = ShrinkWrap.create(WebArchive.class, "arquillian-jacoco.war").addPackages(true, "com.tayur")
				.setWebXML(new File("src/test/resources/web.xml")).addAsLibraries(files);

		System.out.println(archive.toString(true));

		return archive;

	}

	@Test
	public void shouldBeAbleToConnect() throws Exception {

		assertTrue(deploymentURL.toString() != null);
	}

}
