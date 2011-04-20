/*
 *  soapUI, copyright (C) 2004-2011 eviware.com 
 *
 *  soapUI is free software; you can redistribute it and/or modify it under the 
 *  terms of version 2.1 of the GNU Lesser General Public License as published by 
 *  the Free Software Foundation.
 *
 *  soapUI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 *  even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU Lesser General Public License for more details at gnu.org.
 */

package com.eviware.soapui.impl.rest.support;

import junit.framework.TestCase;

import com.eviware.soapui.impl.rest.RestService;
import com.eviware.soapui.impl.rest.RestServiceFactory;
import com.eviware.soapui.impl.wsdl.WsdlProject;

public class WadlImporterTestCase extends TestCase
{
	public void testWadlImporter() throws Exception
	{
		WsdlProject project = new WsdlProject();
		RestService service = ( RestService )project.addNewInterface( "REST Service", RestServiceFactory.REST_TYPE );
		WadlImporter importer = new WadlImporter( service );
		importer.initFromWadl( WadlImporter.class.getResource( "/wadl/YahooSearch.wadl" ).toString() );
		assertEquals( service.getName(), "REST Service" );
		assertEquals( 1, service.getResourceList().size() );
		assertEquals( 0, service.getResourceList().get( 0 ).getChildResourceCount() );
		assertEquals( 1, service.getResourceList().get( 0 ).getRestMethodCount() );
	}
}