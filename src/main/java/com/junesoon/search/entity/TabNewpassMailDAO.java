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
 * TabNewpassMail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.dreamweb.entity.TabNewpassMail
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TabNewpassMailDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TabNewpassMailDAO.class);
	// property constants
	public static final String USERNAME = "username";

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

	public void save(TabNewpassMail transientInstance) {
		log.debug("saving TabNewpassMail instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TabNewpassMail persistentInstance) {
		log.debug("deleting TabNewpassMail instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TabNewpassMail findById(java.lang.String id) {
		log.debug("getting TabNewpassMail instance with id: " + id);
		try {
			TabNewpassMail instance = (TabNewpassMail) getCurrentSession().get(
					"com.dreamweb.entity.TabNewpassMail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TabNewpassMail instance) {
		log.debug("finding TabNewpassMail instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.dreamweb.entity.TabNewpassMail")
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
		log.debug("finding TabNewpassMail instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TabNewpassMail as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findAll() {
		log.debug("finding all TabNewpassMail instances");
		try {
			String queryString = "from TabNewpassMail";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TabNewpassMail merge(TabNewpassMail detachedInstance) {
		log.debug("merging TabNewpassMail instance");
		try {
			TabNewpassMail result = (TabNewpassMail) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TabNewpassMail instance) {
		log.debug("attaching dirty TabNewpassMail instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TabNewpassMail instance) {
		log.debug("attaching clean TabNewpassMail instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TabNewpassMailDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TabNewpassMailDAO) ctx.getBean("TabNewpassMailDAO");
	}
}