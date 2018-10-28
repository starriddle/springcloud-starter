package com.cyl.demo.hessian.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cyl.demo.hessian.server.entity.School;
import com.cyl.demo.hessian.server.service.SchoolService;

/**
 * School Service 实现类
 *
 * @author CYL
 * @date 2018-10-27
 * @see SchoolService
 */
public class SchoolServiceImpl implements SchoolService {

    private List<School> schools = new ArrayList<>();

    private static final String LOCK = "School";

    @Override
    public Integer count() {
        return schools.size();
    }

    @Override
    public School getById(Integer id) {
        if (id > 0 && id <= schools.size()) {
            return schools.get(id-1);
        } else {
            return null;
        }
    }

    @Override
	public School create(School school) {
        synchronized (LOCK) {
            school.setId(schools.size() + 1);
            schools.add(school);
        }
        return school;
    }

    @Override
	public int create(String name, String address) {
        School school;
        synchronized (LOCK) {
            school = new School(schools.size() + 1, name, address);
            schools.add(school);
        }
        return school.getId();
    }
}
