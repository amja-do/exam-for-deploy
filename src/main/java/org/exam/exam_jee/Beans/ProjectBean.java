package org.exam.exam_jee.Beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import org.exam.exam_jee.Models.Projet;
import org.exam.exam_jee.Repositories.ProjectRepository;

@ManagedBean
@ViewScoped
public class ProjectBean {

    private Projet projet;
    private ProjectRepository projectRepository;


    @PostConstruct
    public void init(){
        projectRepository = new ProjectRepository();
        projet = new Projet();
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public ProjectRepository getProjectRepository() {
        return projectRepository;
    }

    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void save(){
        projectRepository.addProject(projet);
        NavigationBean.redirectToIndexPage();
    }
}
