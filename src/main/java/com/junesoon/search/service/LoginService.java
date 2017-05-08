package com.junesoon.search.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.junesoon.search.entity.TabUserinfoBase;
import com.junesoon.search.entity.TabUserinfoBaseDAO;

@Transactional
public class LoginService extends HibernateDaoSupport {

	@Resource
	SessionFactory sessionFactory;

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	TabUserinfoBaseDAO userinfoBaseDAO = TabUserinfoBaseDAO
			.getFromApplicationContext(context);

	public Object getByParma(TabUserinfoBase userinfoBase) {

		@SuppressWarnings("unchecked")
		List<Object> list = userinfoBaseDAO.findByThreeProperties("userName",
				"password", "userFlag", userinfoBase.getUserName(),
				userinfoBase.getPassword(), userinfoBase.getUserFlag());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;

	}

	/**
	 * ��query�еĲ�����ֵ
	 * 
	 * @param query
	 * @param queryParams
	 */
	protected void setQueryParams(Query query, Object[] queryParams) {
		if (queryParams != null && queryParams.length > 0) {
			for (int i = 0; i < queryParams.length; i++) {
				query.setParameter(i, queryParams[i]);
			}
		}
	}
	
}
