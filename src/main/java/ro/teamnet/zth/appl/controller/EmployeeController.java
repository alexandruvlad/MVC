package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

@MyController(urlPath = "/employees")
public class EmployeeController {

    @MyRequestMethod(urlPath = "/all",methodType = "GET")
    public String getAllEmployees (){
        return "allEmployees";
    }

    @MyRequestMethod(urlPath = "/one", methodType = "GET")
    public String getOneEmployee () {
        return "getRandomEmployee";
    }

}
