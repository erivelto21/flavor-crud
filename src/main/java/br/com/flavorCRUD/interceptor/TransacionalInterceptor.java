package br.com.flavorCRUD.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transacional
public class TransacionalInterceptor {

	@Inject
	private EntityManager entityManager;

	@AroundInvoke
	public Object intercept(InvocationContext invocationContext) throws Exception {
		entityManager.getTransaction().begin();
		
		Object result = invocationContext.proceed();

		entityManager.getTransaction().commit();
		
		return result;
	}
}
