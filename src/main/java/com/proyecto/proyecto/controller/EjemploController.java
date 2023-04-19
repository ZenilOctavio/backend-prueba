
package com.proyecto.proyecto.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EjemploController {
    
    // @GetMapping("/")
    // public String index(){
    //     return "index";
    // }
    
    @GetMapping("/")
    public ResponseEntity<Resource> cargarArchivoHtml() throws IOException {
        return getResource("index.html");
    }
    
    @GetMapping("/about")
    public ResponseEntity<Resource> about() throws IOException{
        return getResource("/about/index.html");
    }

    public ResponseEntity<Resource> getResource(String path) throws IOException{
            File file = new File(System.getProperty("user.dir")+"/src/main/resources/static/"+path);
        // System.out.println(file.getAbsolutePath());
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=" + file.getName());
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("text/html"))
                .body(resource);

    }
    
}
