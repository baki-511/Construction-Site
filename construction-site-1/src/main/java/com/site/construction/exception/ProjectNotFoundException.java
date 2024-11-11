package com.site.construction.exception;

public class ProjectNotFoundException extends RuntimeException{
    public ProjectNotFoundException(Integer projectID) {
        super("Project NOT Found with ID : " + projectID);
    }
}
