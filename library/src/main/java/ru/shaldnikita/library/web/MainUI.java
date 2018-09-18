package ru.shaldnikita.library.web;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;

/**
 * @author Nikita Shaldenkov <nikita.shaldenkov@bostongene.com>
 */
@Route("")
public class MainUI extends Div {

    public MainUI() {
        add(new Label("SECuRED PAGE"));
    }
}
