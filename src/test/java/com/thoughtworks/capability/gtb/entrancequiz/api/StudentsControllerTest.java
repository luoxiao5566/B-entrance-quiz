package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.service.GroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentsControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    GroupService groupService;

    @Test
    public void should_get_all_students() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(jsonPath("$",hasSize(15)))
                .andExpect(jsonPath("$[0].name",is("成吉思汗")))
                .andExpect(jsonPath("$[0].id",is(1)))
                .andExpect(jsonPath("$[3].name",is("钟无艳")))
                .andExpect(jsonPath("$[3].id",is(4)))
                .andExpect(jsonPath("$[8].name",is("刘禅")))
                .andExpect(jsonPath("$[8].id",is(9)))
                .andExpect(jsonPath("$[14].name",is("蔡文姬")))
                .andExpect(jsonPath("$[14].id",is(15)))
                .andExpect(status().isOk());
    }

    @Test
    public void should_add_student() throws Exception {
        String jsonString = "孙悟空";
        mockMvc.perform(post("/addStudent").contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/students"))
                .andExpect(jsonPath("$",hasSize(16)))
                .andExpect(jsonPath("$[0].name",is("成吉思汗")))
                .andExpect(jsonPath("$[0].id",is(1)))
                .andExpect(jsonPath("$[15].name",is("孙悟空")))
                .andExpect(jsonPath("$[15].id",is(16)))
                .andExpect(status().isOk());
    }

    @Test
    public void should_get_all_group() throws Exception {
        mockMvc.perform(get("/groups"))
                .andExpect(status().isOk());
    }

}
