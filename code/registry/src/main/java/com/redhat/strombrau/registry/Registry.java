package com.redhat.strombrau.registry;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;


/**
 * Singleton registry that stores data in Zookeeper
 * @author hhiden
 */
@Singleton
@Startup
public class Registry {
    private static final Logger logger = Logger.getLogger(Registry.class.getName());

    @Inject
    @ConfigProperty(name = "zookeeper.host", defaultValue = "localhost")
    private String zookeeperHost;
    
    @Inject
    @ConfigProperty(name = "zookeeper.port", defaultValue = "2181")
    private int zookeeperPort;
    
    @PostConstruct
    public void init(){
        logger.info("Registry init: " + zookeeperHost + ":" + zookeeperPort);
    }
    
}
