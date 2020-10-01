package org.zipper.edit;


import org.junit.Test;
import org.zipper.edit.iface.TypeTransformer;
import org.zipper.edit.service.TypeTransformerImpl;
import org.zipper.edit.util.S;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Locale;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/27.
 */
public class EditTest {

    @Test
    public void get() {

//        ResourceBundle bundle = ResourceBundle.getBundle("message", new Locale("zh", "CN"));
//        String cancel = bundle.getString("cancelKey");
//        System.out.println(cancel);


        Locale[] locales = Locale.getAvailableLocales();
        for (int i = 0; i < locales.length; i++) {
            Locale locale = locales[i];
            if (!S.isEmpty(locale.getDisplayCountry())) {
                if (!locale.getDisplayLanguage().equals("English")) {
                    continue;
                }

                System.out.println(locale.getDisplayCountry());
                System.out.println(locale.getDisplayLanguage());
                System.out.println(locale.getCountry());
                System.out.println(locale.getDisplayName(locale));
                System.out.println(locale.getDisplayScript(locale));
                System.out.println(locale.getDisplayVariant(locale));
                System.out.println("#############################");
            }
        }

    }


    @Test
    public void getFx() {
        Class<?> entitiClass = null;
        Type genericSuperclass = TypeTransformerImpl.class.getGenericSuperclass();
        for (int i = 0; i < TypeTransformerImpl.class.getTypeParameters().length; i++) {
            System.out.println(TypeTransformerImpl.class.getTypeParameters()[i].getTypeName());
        }

        for (int i = TypeTransformerImpl.class.getInterfaces().length - 1; i >= 0; i--) {
            Class<?> ifce = TypeTransformerImpl.class.getInterfaces()[i];
            for (int i1 = ifce.getTypeParameters().length - 1; i1 >= 0; i1--) {
                System.out.println(ifce.getTypeParameters()[i1].getName());
            }

        }
        if (genericSuperclass instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass)
                    .getActualTypeArguments();
            if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                entitiClass = (Class<?>) actualTypeArguments[0];
            }
        }


    }

}
