package ru.shaldnikita.library.web;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@Route("index")
public class MainUI extends Div {

    public MainUI() {
        add(new Button("Login",e ->{
            UI.getCurrent().navigate("login");
        }));
    }
}
