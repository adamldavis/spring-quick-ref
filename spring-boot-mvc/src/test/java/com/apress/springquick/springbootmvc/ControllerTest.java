package com.apress.springquick.springbootmvc;

import com.apress.spring_quick.jpa.simple.Course;
import com.apress.spring_quick.jpa.simple.SimpleCourseRepository;
import io.micrometer.core.instrument.MeterRegistry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 * Copyright 2020, Adam L. Davis
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SimpleCourseRepository courseRepository;
    @MockBean
    private MeterRegistry meterRegistry;

    @Test
    public void coursesShouldReturnAllCourses() throws Exception {
        Course course = new Course();
        course.setName("Java Professional");
        course.setSubtitle("Java 11");
        course.setDescription("");
        when(courseRepository.findAll()).thenReturn(List.of(course));
        mockMvc.perform(get("/api/v1/courses")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("[{\"id\":null,\"title\":\"Java Professional\"" +
                                ",\"subtitle\":\"Java 11\",\"description\":\"\"}]")));
    }

}
