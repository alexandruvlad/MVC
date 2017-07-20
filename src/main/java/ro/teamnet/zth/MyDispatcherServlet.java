package ro.teamnet.zth;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.controller.EmployeeController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyDispatcherServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        dispatchReply(request,response,"POST");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        dispatchReply(request,response,"GET");
    }

    private void dispatchReply(HttpServletRequest request, HttpServletResponse response,String method){

        try{

            Object resultToDisplay = dispatch(request,method);
            reply(response,resultToDisplay);

        } catch(Exception e ){
            e.printStackTrace();
        }

    }

    private Object dispatch(HttpServletRequest req, String meth){

        MyController controller = req.getClass().getDeclaredAnnotation(MyController.class);
        String result = "";
        if(controller.urlPath().equals("/employee")){
            MyRequestMethod requestMethod = req.getClass().getDeclaredAnnotation(MyRequestMethod.class);
            if(requestMethod.urlPath().equals("/one") && requestMethod.methodType().equals("GET")){
                Method method;

                try {
                    method = EmployeeController.class.getMethod("getOneEmployee",String.class);

                    result = (String) method.invoke(new EmployeeController());

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }

            if(requestMethod.urlPath().equals("/all")){
                Method method = null;

                try {
                    method = EmployeeController.class.getMethod("getAllEmployees");

                    result = (String) method.invoke(new EmployeeController());


                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        } else if(controller.urlPath().equals("/department")) {
            MyRequestMethod requestMethod = req.getClass().getDeclaredAnnotation(MyRequestMethod.class);
            if(requestMethod.urlPath().equals("/one") && requestMethod.methodType().equals("GET")){
                Method method;

                try {
                    method = EmployeeController.class.getMethod("getOneDepartment",String.class);

                    result = (String) method.invoke(new EmployeeController());

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } else  if(requestMethod.urlPath().equals("/all")){
                Method method = null;

                try {
                    method = EmployeeController.class.getMethod("getAllDepartments");

                    result = (String) method.invoke(new EmployeeController());


                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    private void reply(HttpServletResponse response,Object o) throws IOException {

        response.getWriter().write((String)o);
    }

}
