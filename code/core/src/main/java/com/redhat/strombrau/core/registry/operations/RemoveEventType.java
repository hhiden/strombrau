package com.redhat.strombrau.core.registry.operations;

import com.redhat.strombrau.core.registry.RegistryException;
import com.redhat.strombrau.core.registry.RegistryOperation;
import com.redhat.strombrau.core.registry.items.EventType;

/**
 * Removes an event type from the registry
 * @author hhiden
 */
public class RemoveEventType extends RegistryOperation {
    String eventTypeName;

    public RemoveEventType(String name) {
        this.eventTypeName = name;
    }
    
    public RemoveEventType(EventType eventType){
        this.eventTypeName = eventType.name;
    }

    @Override
    public void performOperation() throws RegistryException {
        try {
            connection.removeKey("events/" + eventTypeName);
        } catch (Exception ex){
            throw new RegistryException("Error performing operation" , ex);
        }        
    }    
}