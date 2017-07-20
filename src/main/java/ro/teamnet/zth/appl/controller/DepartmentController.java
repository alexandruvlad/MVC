package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

@MyController(urlPath = "/departments")
public class DepartmentController {

    @MyRequestMethod(urlPath = "/all", methodType = "GET")
    public String getAllDepartments (){
        return "allDepartments";
    }

    @MyRequestMethod(urlPath = "/one", methodType = "GET")
    public String getOneDepartment () {
        return "getRandomDepartment";
    }

}
