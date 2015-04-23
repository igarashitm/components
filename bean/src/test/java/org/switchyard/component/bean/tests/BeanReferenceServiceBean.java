package org.switchyard.component.bean;

import javax.inject.Inject;

import org.switchyard.Context;
import org.switchyard.ServiceReference;

@Service(name="BeanReferenceService")
public class BeanReferenceServiceBean implements BeanReferenceService {

    @Inject
    private Context _context;

    @Override
    public String invoke(String input) {
        ServiceReference ref = (ServiceReference) _context.getPropertyValue("org.switchyard.bus.camel.consumer");
        return ref.getName().toString();
    }

}
