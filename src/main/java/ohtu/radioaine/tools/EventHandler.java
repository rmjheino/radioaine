/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.radioaine.tools;

import ohtu.radioaine.domain.Batch;
import ohtu.radioaine.domain.Event;
import ohtu.radioaine.domain.Substance;
import ohtu.radioaine.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;



/**
 *
 * @author Richard Moneybags
 */
public class EventHandler {
    
    public static Event newBatchEvent(Batch batch, String sig) {
        Event event = new Event();
        event.setInfo("type=arrived "+batch.toString());
        event.setArrivalDate(batch.getArrivalDate());
        return event;
    }

    public static Event updateBatchEvent(Batch batch, String sig) {
        Event event = new Event();
        event.setInfo("type=modifyBatch "+batch.toString());
        return event;
    }

    public static Event addToBatchEvent(Batch batch, String sig) {
        Event event = new Event();
        event.setInfo("type=addToBatch "+batch.toString());
        return event;
    }
    
    public static Event qualityCheckEvent(Batch batch, String sig) {
        Event event = new Event();
        event.setInfo("type=qualityCheck "+batch.toString());
        return event;
    }
    
    public static Event newSubstanceEvent(Substance substance, String sig){
        Event event = new Event();
        event.setInfo("type=newSubstance "+substance.toString());
        return event;
    }  
}
