package com.sda.javaee9spring.component;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //let's make singleton not singleton by choosing PROTOTYPE
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //parem kopeerida, mitte kirjutada Stringi. Ava scope ja copy
public class MySecondComponent {//component is generic component. It's singleton and we going to change that by adding @Scope
}
