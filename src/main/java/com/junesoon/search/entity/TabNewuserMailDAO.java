package com.junesoon.search.entity;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * TabNewuserMail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.dreamweb.entity.TabNewuserMail
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TabNewuserMailDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TabNewuserMailDAO.class);
	// property constants
	public static final String USER_NAME = "userName";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(TabNewuserMail transientInstance) {
		log.debug("saving TabNewuserMail instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TabNewuserMail persistentInstance) {
		log.debug("deleting TabNewuserMail instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TabNewuserMail findById(java.lang.String id) {
		log.debug("getting TabNewuserMail instance with id: " + id);
		try {
			TabNewuserMail instance = (TabNewuserMail) getCurrentSession().get(
					"com.dreamweb.entity.TabNewuserMail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TabNewuserMail instance) {
		log.debug("finding TabNewuserMail instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.dreamweb.entity.TabNewuserMail")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TabNewuserMail instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TabNewuserMail as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findAll() {
		log.debug("finding all TabNewuserMail instances");
		try {
			String queryString = "from TabNewuserMail";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TabNewuserMail merge(TabNewuserMail detachedInstance) {
		log.debug("merging TabNewuserMail instance");
		try {
			TabNewuserMail result = (TabNewuserMail) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TabNewuserMail instance) {
		log.debug("attaching dirty TabNewuserMail instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TabNewuserMail instance) {
		log.debug("attaching clean TabNewuserMail instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TabNewuserMailDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TabNewuserMailDAO) ctx.getBean("TabNewuserMailDAO");
	}
}