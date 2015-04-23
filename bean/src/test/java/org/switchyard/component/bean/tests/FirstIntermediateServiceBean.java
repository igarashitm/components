package org.switchyard.component.bean;

import javax.inject.Inject;

@Service(name="FirstIntermediateService")
public class FirstIntermediateServiceBean implements BeanReferenceService {

    @Inject
    @Reference("BeanReferenceService")
    private BeanReferenceService _bean;

    @Override
    public String invoke(String input) {
        String out = _bean.invoke(input);
        assert out.indexOf("FirstIntermediate") >= 0: "consumer was not me!? - " + out;
        return input + out;
    }

}
