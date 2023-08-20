package com.ttknpdev.understandthymeleaf.log;

import com.ttknpdev.understandthymeleaf.controller.ControlPath;
import com.ttknpdev.understandthymeleaf.service.Crud;
import org.apache.log4j.Logger;

public class Logging {
    public final static Logger control = Logger.getLogger(ControlPath.class);
    public final static Logger crud = Logger.getLogger(Crud.class);
}
