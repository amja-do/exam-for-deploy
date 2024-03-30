package org.exam.exam_jee.Beans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;

import java.io.IOException;

@ManagedBean
@ViewScoped
public class NavigationBean {


    public String goToHome(){
        return "/index.xhtml";
    }

    public String goToAddEmployee(){
        return "/new-user.xhtml";
    }

    public String goToAddProject(){
        return "/new-project.xhtml";
    }

    public String goToAffect(){
        return "/affect.xhtml";
    }

    public static void redirectToIndexPage() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
