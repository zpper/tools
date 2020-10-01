package org.zipper.edit.service;


import org.zipper.edit.config.PluginConfig;
import org.zipper.edit.iface.TypeTransformer;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/29.
 */
public class TypeTransformerImpl implements TypeTransformer<PluginConfig> {


    @Override
    public String encoder(PluginConfig pluginConfig) {
        return null;
    }

    @Override
    public PluginConfig decoder(String str) {
        return null;
    }
}
