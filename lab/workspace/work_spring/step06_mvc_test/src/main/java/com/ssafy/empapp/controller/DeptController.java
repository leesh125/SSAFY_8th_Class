package com.ssafy.empapp.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceView;

import com.mysql.cj.log.Slf4JLogger;
import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.model.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/depts")
@Controller
public class DeptController  {

    @Autowired
    private DeptService deptService;
    
    @GetMapping
    protected ResponseEntity<List<Dept>> getDeptList(@RequestParam(required = false) String dname, @RequestParam(required = false) String loc){
        HashMap<String, Object> conditions = new HashMap<String, Object>();
        if(dname !=null) conditions.put("dname", dname);
        if(loc !=null) conditions.put("loc", loc);
        
        return ResponseEntity.ok().body(deptService.getDepts(conditions));
    }
    
    @GetMapping("/{deptno}")
    protected ResponseEntity<?> getDeptDetail(@PathVariable int deptno)
    {
        Dept dept = deptService.getDept(deptno);
        if(dept != null)
            return ResponseEntity.ok().body(dept);
        else
            return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    protected ResponseEntity<?> register(@RequestBody Dept dept) {
        
        boolean res = deptService.registerDept(dept);
        
        if(res) {
            return ResponseEntity.created(URI.create("/api/depts/"+dept.getDeptno())).build();
        }else {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @PutMapping("/{deptno}")
    protected ResponseEntity<?> modify(@RequestBody Dept dept) {
        Dept dept2 = deptService.getDept(dept.getDeptno());
        if(dept2 != null)
        {
            boolean res = deptService.modifyDept(dept);
            if(res)
            {
                return ResponseEntity.ok().body(dept);
            }
            else
            {
                return ResponseEntity.internalServerError().build();
            }
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{deptno}")
    protected ResponseEntity<?> remove(@PathVariable int deptno) {
        Dept dept = deptService.getDept(deptno);
        if(dept != null)
        {
            boolean res = deptService.deleteDept(deptno);
            if(res)
                return ResponseEntity.noContent().build();
            else
                return ResponseEntity.internalServerError().build();
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
    
    @RequestMapping("/{deptno}/emps")
    protected ResponseEntity<?> getDeptDetailWithEmps(@PathVariable int deptno) throws Exception {
        Dept dept = deptService.getDeptWithEmps(deptno);
        if(dept!=null)
        {
            return ResponseEntity.ok().body(dept); 
        }
        return ResponseEntity.notFound().build();
    }
}