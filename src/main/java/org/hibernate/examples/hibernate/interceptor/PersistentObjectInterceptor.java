package org.hibernate.examples.hibernate.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.EmptyInterceptor;
import org.hibernate.examples.PersistentObject;

import java.io.Serializable;

/**
 * org.hibernate.examples.hibernate.interceptor.PersistentObjectInterceptor
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 28. 오전 11:06
 */
@Slf4j
public class PersistentObjectInterceptor extends EmptyInterceptor {

    public boolean isPersisted(Object entity) {
        return entity instanceof PersistentObject && ((PersistentObject) entity).isPersisted();
    }

    @Override
    public boolean onLoad(Object entity,
                          Serializable id,
                          Object[] state,
                          String[] propertyNames,
                          org.hibernate.type.Type[] types) {
        if (entity instanceof PersistentObject) {
            ((PersistentObject) entity).onLoad();
        }
        return false;
    }

    @Override
    public boolean onSave(Object entity,
                          Serializable id,
                          Object[] state,
                          String[] propertyNames,
                          org.hibernate.type.Type[] types) {
        if (entity instanceof PersistentObject) {
            ((PersistentObject) entity).onSave();
        }
        return false;
    }

    private static final long serialVersionUID = -9072457259066614636L;
}
