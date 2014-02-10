/**
 * 
 */
package com.employee.service.test;

import java.util.Collection;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.testng.annotations.Test;

import com.example.service.EmployeeService;
import com.example.service.domain.Employee;

/**
 * @author sbhosale
 * 
 */
public class EJBTest {

	@Test
	public void testEJB() throws NamingException {

        final Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL,"remote://localhost:9999");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//        jndiProperties.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", false);
        jndiProperties.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", false);
        jndiProperties.put("remote.connection.default.connect.options.org.xnio.Options.SASL_DISALLOWED_MECHANISMS", "JBOSS-LOCAL-USER");
        jndiProperties.put("remote.connection.default.host", "localhost");
        jndiProperties.put("remote.connection.default.port", "8080");
        jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejbuser");
        jndiProperties.put(Context.SECURITY_CREDENTIALS, "ejbuser");
        
        
        final Context context = new InitialContext(jndiProperties);
        
        EmployeeService empService= (EmployeeService) context.lookup("emp-service/EmployeeServiceController!com.example.service.EmployeeService");
		Collection<Employee> listEmp = empService.listEmployee();

		System.out.println("List Retrieved " + listEmp);
	}
	

}
