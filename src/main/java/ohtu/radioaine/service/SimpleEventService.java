/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.radioaine.service;

import java.sql.Timestamp;
import java.util.List;
import ohtu.radioaine.database.EventDBDao;
import ohtu.radioaine.domain.Event;
import ohtu.radioaine.domain.Event3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Richard Moneybags
 */
@Service
public class SimpleEventService implements EventService {
    
    @Autowired
    private EventDBDao storageDao;
    
    @Override
    @Transactional
    public Event createOrUpdate(Event event) {
        return storageDao.createOrUpdate(event);
    }

    @Override
    @Transactional
    public List<Event> list() {
        return storageDao.list();
    }

    @Override
    @Transactional
    public Event read(int id) {
        return storageDao.read(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Event e = storageDao.read(id);
        if (e != null) {
            storageDao.delete(e);
        }
    }

    @Override
    public List<Event> listArrivedByDate(Timestamp start, Timestamp end) {
        return storageDao.listArrivedByDate(start, end);
    }

    @Override
    public List<Event> list(String name) {
        return storageDao.list(name);
    }
}
