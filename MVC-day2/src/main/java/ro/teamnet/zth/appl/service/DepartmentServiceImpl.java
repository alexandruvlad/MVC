package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.domain.Department;

import java.util.List;

/**
 * Developer: Viorelt
 * <p>
 * Copyright (c) 2017 Teamnet International. All Rights Reserved.
 * <p>
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet International.
 **/

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao=new DepartmentDao();

    public Department findOne(Long id) {
        return departmentDao.findDepartmentById(id);
    }

    public List<Department> findAll() {
        return departmentDao.findAllDepartments();
    }

    public Department insertDepartment(Department department) {
        return departmentDao.insertDepartment(department);
    }

    public Department updateDepartment(Department department) {
        return departmentDao.updateDepartment(department);
    }

    public void deleteDepartment(Department department) {
        departmentDao.deleteDepartment(department);
    }
}
