package org.switchyard.component.bean;

import javax.inject.Inject;

@Service(name="SecondIntermediateService")
public class SecondIntermediateServiceBean implements BeanReferenceService {

    @Inject
    @Reference("BeanReferenceService")
    private BeanReferenceService _bean;

    @Override
    public String invoke(String input) {
        String out = _bean.invoke(input);
        assert out.indexOf("SecondIntermediate") >= 0: "consumer was not me!? - " + out;
        return input + out;
    }

}
